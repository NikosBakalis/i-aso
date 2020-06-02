package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.lang.*;
import java.util.Properties;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

/**
 * This is the class that's responsible for every communication
 * between the program and the database server.
 */
public class ICRUDImpl implements ICRUD {

    private static Connection connection; // Initialize connection with the database server.

    /**
     * Method that populates model.Hospital with values from database table.
     * @param afm requires the primary key of hospital table in database so as to retrieve the data.
     * @return the hospital values of this primary key to model.Hospital.
     */
    public Hospital getHospital(String afm) {
        try {
            String query = "SELECT * FROM hospital WHERE hospital.hospital_afm = ?;";

            ResultSet resultSet;
            Hospital hospital;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, afm);
                resultSet = preparedStatement.executeQuery();
                hospital = null;
                if (resultSet.next()) {
                    hospital = new Hospital();
                    hospital.setAfm(resultSet.getString("afm"));
                    hospital.setName(resultSet.getString("name"));
                    hospital.setFirst_street_name(resultSet.getString("first_street_name"));
                    hospital.setFirst_street_number(resultSet.getInt("first_street_number"));
                    hospital.setPrimary_phone_number(resultSet.getInt("primary_phone_number"));
                    hospital.setEmergency_phone_number(resultSet.getInt("emergency_phone_number"));
                    hospital.setEmail_address(resultSet.getString("email_address"));
                    hospital.setSecond_street_name(resultSet.getString("second_street_name"));
                    hospital.setSecond_street_number(resultSet.getInt("second_street_number"));
                }
            }
            resultSet.close();
            return hospital;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.Clinic with values from database table.
     * @param name requires the primary key of clinic table in database so as to retrieve the data.
     * @param hospital_afm requires the primary key of clinic table in database so as to retrieve the data.
     * @return the clinic values of this primary key to model.Clinic.
     */
    @Override
    public Clinic getClinic(String name, String hospital_afm) {
        try {
            String query = "SELECT * FROM clinic WHERE clinic.name = ? AND clinic.hospital_afm = ?;";

            ResultSet resultSet;
            Clinic clinic;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, hospital_afm);
                resultSet = preparedStatement.executeQuery();
                clinic = null;
                if (resultSet.next()) {
                    clinic = new Clinic();
                    clinic.setName(resultSet.getString("name"));
                    clinic.setHospitalAfm(resultSet.getString("hospital_afm"));
                }
            }
            resultSet.close();
            return clinic;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.Patient with values from database table.
     * @param amka requires the primary key of patient table in database so as to retrieve the data.
     * @return the patient values of this primary key to model.Patient.
     */
    @Override
    public Patient getPatient(String amka) {
        try {
            String query = "SELECT * FROM patient WHERE patient.amka = ?;";

            ResultSet resultSet;
            Patient patient;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, amka);
                resultSet = preparedStatement.executeQuery();
                patient = null;
                if (resultSet.next()) {
                    patient = new Patient();
                    patient.setAmka(resultSet.getString("amka"));
                    patient.setAfm(resultSet.getString("afm"));
                    patient.setFirstName(resultSet.getString("first_name"));
                    patient.setLastName(resultSet.getString("last_name"));
                    patient.setBirthDate(resultSet.getDate("birth_date"));
                    patient.setNationality(resultSet.getString("nationality"));
                    patient.setGender(resultSet.getString("gender"));
                    patient.setInsurance(resultSet.getString("insurance"));
                    patient.setFatherFirstName(resultSet.getString("father_first_name"));
                    patient.setFatherLastName(resultSet.getString("father_last_name"));
                    patient.setMotherFirstName(resultSet.getString("mother_first_name"));
                    patient.setMotherLastName(resultSet.getString("mother_last_name"));
                    patient.setFirstStreetName(resultSet.getString("first_street_name"));
                    patient.setFirstStreetNumber(resultSet.getString("first_street_number"));
                    patient.setPrimaryPhoneNumber(resultSet.getString("primary_phone_number"));
                    patient.setEmainAddress(resultSet.getString("email_address"));
                    patient.setSecondStreetName(resultSet.getString("second_street_name"));
                    patient.setSecondStreetNumber(resultSet.getString("second_street_number"));
                }
            }
            resultSet.close();
            return patient;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.PatientFolder with values from database table.
     * @param patient_amka requires the primary key of patient_folder table in database so as to retrieve the data.
     * @return the patient_folder values of this primary key to model.PatientFolder.
     */
    @Override
    public PatientFolder getPatientFolder(String patient_amka) {
        try {
            String query = "SELECT * FROM patient_folder WHERE patient_folder.patient_amka = ?;";

            ResultSet resultSet;
            PatientFolder patientFolder;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, patient_amka);
                resultSet = preparedStatement.executeQuery();
                patientFolder = null;
                if (resultSet.next()) {
                    patientFolder = new PatientFolder();
                    patientFolder.setPatientAmka(resultSet.getString("patient_amka"));
                    patientFolder.setChronicDisease(resultSet.getString("chronic_disease"));
                    patientFolder.setPatientAllergies(resultSet.getString("patient_allergies"));
                    patientFolder.setPatientSurgeries(resultSet.getString("patient_surgeries"));
                    patientFolder.setBloodType(resultSet.getString("blood_type"));
                    patientFolder.setHBV(resultSet.getString("HBV"));
                    patientFolder.setHBC(resultSet.getString("HBC"));
                }
            }
            resultSet.close();
            return patientFolder;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.PatientFile with values from database table.
     * @param file_id requires the primary key of patient_file table in database so as to retrieve the data.
     * @return the patient_file values of this primary key to model.PatientFile.
     */
    @Override
    public PatientFile getPatientFile(String file_id) {
        try {
            String query = "SELECT * FROM patient_file WHERE patient_file.file_id = ?;";

            ResultSet resultSet;
            PatientFile patientFile;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, file_id);
                resultSet = preparedStatement.executeQuery();
                patientFile = null;
                if (resultSet.next()) {
                    patientFile = new PatientFile();
                    patientFile.setPatientAmka(resultSet.getString("patient_amka"));
                    patientFile.setFileId(resultSet.getString("file_id"));
                    patientFile.setHospital(resultSet.getString("hospital"));
                    patientFile.setDiagnosis(resultSet.getString("diagnosis"));
                    patientFile.setTreatment(resultSet.getString("treatment"));
                    patientFile.setLabTests(resultSet.getString("lab_tests"));
                }
            }
            resultSet.close();
            return patientFile;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.Chamber with values from database table.
     * @param id requires the primary key of chamber table in database so as to retrieve the data.
     * @return the chamber values of this primary key to model.Chamber.
     */
    @Override
    public Chamber getChamber(String id) {
        try {
            String query = "SELECT * FROM chamber WHERE chamber.id = ?;";

            ResultSet resultSet;
            Chamber chamber;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, id);
                resultSet = preparedStatement.executeQuery();
                chamber = null;
                if (resultSet.next()) {
                    chamber = new Chamber();
                    chamber.setId(resultSet.getString("id"));
                    chamber.setClinicName(resultSet.getString("clinic_name"));
                }
            }
            resultSet.close();
            return chamber;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.Bed with values from database table.
     * @param number requires the primary key of bed table in database so as to retrieve the data.
     * @return the bed values of this primary key to model.Bed.
     */
    @Override
    public Bed getBed(String number) {
        try {
            String query = "SELECT * FROM bed WHERE bed.number = ?;";

            ResultSet resultSet;
            Bed bed;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, number);
                resultSet = preparedStatement.executeQuery();
                bed = null;
                if (resultSet.next()) {
                    bed = new Bed();
                    bed.setNumber(resultSet.getString("number"));
                    bed.setChamberId(resultSet.getString("chamber_id"));
                    bed.setIsFree(resultSet.getBoolean("is_free"));
                }
            }
            resultSet.close();
            return bed;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.AdmissionTicket with values from database table.
     * @param ticket_id requires the primary key of admission_ticket table in database so as to retrieve the data.
     * @return the admission_ticket values of this primary key to model.AdmissionTicket.
     */
    @Override
    public AdmissionTicket getAdmissionTicket(String ticket_id) {
        try {
            String query = "SELECT * FROM admission_ticket WHERE admission_ticket.ticket_id = ?;";

            ResultSet resultSet;
            AdmissionTicket admissionTicket;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, ticket_id);
                resultSet = preparedStatement.executeQuery();
                admissionTicket = null;
                if (resultSet.next()) {
                    admissionTicket = new AdmissionTicket();
                    admissionTicket.setTicketId(resultSet.getString("ticket_id"));
                    admissionTicket.setCreatedAt(resultSet.getDate("created_at"));
                    admissionTicket.setAdmissionClinic(resultSet.getString("admission_clinic"));
                    admissionTicket.setHostClinic(resultSet.getString("host_clinic"));
                    admissionTicket.setPatientChamber(resultSet.getString("patient_chamber"));
                    admissionTicket.setPatientBed(resultSet.getString("patient_bed"));
                    admissionTicket.setAdmissionText(resultSet.getString("admission_text"));
                    admissionTicket.setStage(resultSet.getString("stage"));
                }
            }
            resultSet.close();
            return admissionTicket;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.DischargeNote with values from database table.
     * @param note_id requires the primary key of discharge_note table in database so as to retrieve the data.
     * @return the discharge_note values of this primary key to model.DischargeNote.
     */
    @Override
    public DischargeNote getDischargeNote(String note_id) {
        try {
            String query = "SELECT * FROM discharge_note WHERE discharge_note.note_id = ?;";

            ResultSet resultSet;
            DischargeNote dischargeNote;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, note_id);
                resultSet = preparedStatement.executeQuery();
                dischargeNote = null;
                if (resultSet.next()) {
                    dischargeNote = new DischargeNote();
                    dischargeNote.setNoteId(resultSet.getString("note_id"));
                    dischargeNote.setCreatedAt(resultSet.getDate("created_at"));
                    dischargeNote.setDischargeText(resultSet.getString("discharge_text"));
                    dischargeNote.setAdmissionClinic(resultSet.getString("admission_clinic"));
                    dischargeNote.setStage(resultSet.getString("stage"));
                }
            }
            resultSet.close();
            return dischargeNote;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.Billing with values from database table.
     * @param billing_id requires the primary key of billing table in database so as to retrieve the data.
     * @return the billing values of this primary key to model.Billing.
     */
    @Override
    public Billing getBilling(String billing_id) {
        try {
            String query = "SELECT * FROM billing WHERE billing.billing_id = ?;";

            ResultSet resultSet;
            Billing billing;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, billing_id);
                resultSet = preparedStatement.executeQuery();
                billing = null;
                if (resultSet.next()) {
                    billing = new Billing();
                    billing.setBillingId(resultSet.getString("billing_id"));
                    billing.setCreatedAt(resultSet.getDate("created_at"));
                    billing.setPrice(resultSet.getFloat("price"));
                }
            }
            resultSet.close();
            return billing;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.User with values from database table.
     * @param username requires the primary key of user table in database so as to retrieve the data.
     * @return the user values of this primary key to model.User.
     */
    public User getUser(String username) {
        try {
            String query = "SELECT * FROM user WHERE user.user_name = ?;";

            ResultSet resultSet;
            User user;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                user = null;
                if (resultSet.next()) {
                    user = new User();
                    user.setUsername(resultSet.getString("user_name"));
                    user.setHospital_afm(resultSet.getString("hospital_afm"));
                    user.setFirst_name(resultSet.getString("first_name"));
                    user.setLast_name(resultSet.getString("last_name"));
                    user.setBirth_date(resultSet.getDate("birth_date"));
                    user.setPassword(resultSet.getString("password"));
                    user.setSpecification(resultSet.getString("specification"));
                }
            }
            resultSet.close();
            return user;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.Doctor with values from database table.
     * @param username requires the primary key of doctor table in database so as to retrieve the data.
     * @return the doctor values of this primary key to model.Doctor.
     */
    public Doctor getDoctor(String username) {
        try {
            String query = "SELECT * FROM doctor WHERE doctor.user_name = ?;";

            ResultSet resultSet;
            Doctor doctor;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                doctor = null;
                if (resultSet.next()) {
                    doctor = new Doctor();
                    doctor.setUsername(resultSet.getString("user_name"));
                    doctor.setSector(resultSet.getString("sector"));
                    doctor.setClinic(resultSet.getString("clinic"));
                }
            }
            resultSet.close();
            return doctor;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.Transfer with values from database table.
     * @param id requires the primary key of transfer table in database so as to retrieve the data.
     * @param patient_amka requires the primary key of transfer table in database so as to retrieve the data.
     * @return the transfer values of this primary key to model.Transfer.
     */
    @Override
    public Transfer getTransfer(Timestamp id, String patient_amka) {
        try {
            String query = "SELECT * FROM transfer WHERE transfer.id = ? AND transfer.patient_amka = ?;";

            ResultSet resultSet;
            Transfer transfer;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setTimestamp(1, id);
                preparedStatement.setString(2, patient_amka);
                resultSet = preparedStatement.executeQuery();
                transfer = null;
                if (resultSet.next()) {
                    transfer = new Transfer();
                    transfer.setId(resultSet.getTimestamp("id"));
                    transfer.setAuthorisedBy(resultSet.getString("authorised_by"));
                    transfer.setPatientAmka(resultSet.getString("patient_amka"));
                    transfer.setSourceClinic(resultSet.getString("source_clinic"));
                    transfer.setDestinationClinic(resultSet.getString("destination_clinic"));
                    transfer.setStage(resultSet.getString("stage"));
                }
            }
            resultSet.close();
            return transfer;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.PatientTransferOffice with values from database table.
     * @param number requires the primary key of patient_transfer_office table in database so as to retrieve the data.
     * @return the patient_transfer_office values of this primary key to model.PatientTransferOffice.
     */
    @Override
    public PatientTransferOffice getPatientTransferOffice(String number) {
        try {
            String query = "SELECT * FROM patient_transfer_office WHERE patient_transfer_office.number = ?;";

            ResultSet resultSet;
            PatientTransferOffice patientTransferOffice;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, number);
                resultSet = preparedStatement.executeQuery();
                patientTransferOffice = null;
                if (resultSet.next()) {
                    patientTransferOffice = new PatientTransferOffice();
                    patientTransferOffice.setNumber(resultSet.getString("number"));
                    patientTransferOffice.setHospitalAfm(resultSet.getString("hospital_afm"));
                }
            }
            resultSet.close();
            return patientTransferOffice;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.TransferOfficeAgent with values from database table.
     * @param username requires the primary key of transfer_office_agent table in database so as to retrieve the data.
     * @return the transfer_office_agent values of this primary key to model.TransferOfficeAgent.
     */
    @Override
    public TransferOfficeAgent getTransferOfficeAgent(String username) {
        try {
            String query = "SELECT * FROM transfer_office_agent WHERE transfer_office_agent.user_name = ?;";

            ResultSet resultSet;
            TransferOfficeAgent transferOfficeAgent;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                transferOfficeAgent = null;
                if (resultSet.next()) {
                    transferOfficeAgent = new TransferOfficeAgent();
                    transferOfficeAgent.setUsername(resultSet.getString("user_name"));
                    transferOfficeAgent.setOfficeNumber(resultSet.getString("office_number"));
                }
            }
            resultSet.close();
            return transferOfficeAgent;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.Lab with values from database table.
     * @param name requires the primary key of lab table in database so as to retrieve the data.
     * @param hospital_afm requires the primary key of lab table in database so as to retrieve the data.
     * @return the lab values of this primary key to model.Lab.
     */
    @Override
    public Lab getLab(String name, String hospital_afm) {
        try {
            String query = "SELECT * FROM lab WHERE lab.name = ? AND lab.hospital_afm = ?;";

            ResultSet resultSet;
            Lab lab;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, hospital_afm);
                resultSet = preparedStatement.executeQuery();
                lab = null;
                if (resultSet.next()) {
                    lab = new Lab();
                    lab.setName(resultSet.getString("name"));
                    lab.setHospital_afm(resultSet.getString("hospital_afm"));
                }
            }
            resultSet.close();
            return lab;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.LabAgent with values from database table.
     * @param username requires the primary key of lab_agent table in database so as to retrieve the data.
     * @return the lab_agent values of this primary key to model.LabAgent.
     */
    @Override
    public LabAgent getLabAgent(String username) {
        try {
            String query = "SELECT * FROM lab_agent WHERE lab_agent.user_name = ?;";

            ResultSet resultSet;
            LabAgent labAgent;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                labAgent = null;
                if (resultSet.next()) {
                    labAgent = new LabAgent();
                    labAgent.setUsername(resultSet.getString("user_name"));
                    labAgent.setLabName(resultSet.getString("lab_name"));
                }
            }
            resultSet.close();
            return labAgent;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.ClinicAgent with values from database table.
     * @param username requires the primary key of clinic_agent table in database so as to retrieve the data.
     * @return the clinic_agent values of this primary key to model.ClinicAgent.
     */
    @Override
    public ClinicAgent getClinicAgent(String username) {
        try {
            String query = "SELECT * FROM clinic_agent WHERE clinic_agent.user_name = ?;";

            ResultSet resultSet;
            ClinicAgent clinicAgent;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                clinicAgent = null;
                if (resultSet.next()) {
                    clinicAgent = new ClinicAgent();
                    clinicAgent.setUsername(resultSet.getString("user_name"));
                    clinicAgent.setClinic(resultSet.getString("clinic_name"));
                }
            }
            resultSet.close();
            return clinicAgent;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that populates model.ClinicAgentPost with values from database table.
     * @param postId requires the primary key of clinic_agent_post table in database so as to retrieve the data.
     * @return the clinic_agent_post values of this primary key to model.ClinicAgentPost.
     */
    @Override
    public ClinicAgentPost getClinicAgentPost(String postId) {
        try {
            String query = "SELECT * FROM clinic_agent_post WHERE clinic_agent_post.post_id = ?;";

            ResultSet resultSet;
            ClinicAgentPost clinicAgentPost;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, postId);
                resultSet = preparedStatement.executeQuery();
                clinicAgentPost = null;
                if (resultSet.next()) {
                    clinicAgentPost = new ClinicAgentPost();
                    clinicAgentPost.setId(resultSet.getString("post_id"));
                    clinicAgentPost.setClinicName(resultSet.getString("clinic_name"));
                    clinicAgentPost.setAuthor(resultSet.getString("user_name"));
                    clinicAgentPost.setTitle(resultSet.getString("title"));
                    clinicAgentPost.setText(resultSet.getString("post_text"));
                    clinicAgentPost.setCreatedAt(resultSet.getTimestamp("created_at"));
                }
            }
            resultSet.close();
            return clinicAgentPost;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that sets the discharge_note.stage of discharge_note table to APPROVED.
     * @param noteId requires the primary key of discharge_note table in database so as to change the data.
     * @return the status of the query as integer (value must be equal to 1).
     */
    public int setStageToFinal(String noteId) {
        int queryStatus = 0;
        String query = "UPDATE discharge_note SET discharge_note.stage = 2 WHERE discharge_note.note_id = ?;";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, noteId);
            queryStatus = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("MySQL UPDATE failure");
        }
        return queryStatus;
    }

    /**
     * Method that retrieves the number of all pending admission tickets.
     * @param clinicName requires the primary key of admission_ticket table in database so as to change the data.
     * @param hospitalAfm requires the primary key of admission_ticket table in database so as to change the data.
     * @return the number of pending admission tickets.
     */
    public String getPendingAdmissionTickets(String clinicName, String hospitalAfm) {
        int pendingAdmissionTickets = 0;
        String query = "SELECT COUNT(*) as count FROM admission_ticket " +
                       "INNER JOIN clinic ON clinic.name = admission_ticket.admission_clinic " +
                       "OR clinic.name = admission_ticket.host_clinic " +
                       "WHERE (admission_ticket.admission_clinic = ? OR admission_ticket.host_clinic = ?) " +
                       "AND clinic.hospital_afm = ? AND admission_ticket.stage = \"CREATED\";";
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, clinicName);
            preparedStatement.setString(2, clinicName);
            preparedStatement.setString(3, hospitalAfm);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pendingAdmissionTickets = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            System.err.println("MySQL admission tickets fetching failed");
        }
        return String.valueOf(pendingAdmissionTickets);
    }

    /**
     * Method that retrieves the number of posts of a clinic of a hospital from the database.
     * @param clinicName requires the primary key of clinic_post table in database so as to retrieve the data.
     * @param hospitalAfm requires the primary key of clinic_post table in database so as to retrieve the data.
     * @return the number of posts in one clinic of a hospital.
     */
    public String getClinicPosts(String clinicName, String hospitalAfm) {
        int clinicPosts = 0;
        String query = "SELECT COUNT(*) as count FROM clinic_agent_post " +
                "INNER JOIN clinic ON clinic_agent_post.clinic_name = clinic.name " +
                "WHERE clinic_agent_post.clinic_name = ? AND clinic.hospital_afm = ?;";
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, clinicName);
            preparedStatement.setString(2, hospitalAfm);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                clinicPosts = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            System.err.println("MySQL clinic posts fetching failed");
        }
        return String.valueOf(clinicPosts);
    }

    /**
     * Method that retrieves the number of transfer pending admission tickets from the database.
     * @param hospitalAfm requires the primary key of admission_ticket table in database so as to retrieve the data.
     * @return the number of transfer pending admission tickets.
     */
    public String getTransferPendingAdmissionTickets(String hospitalAfm) {
        int transferPendingAdmissionTickets = 0;
        String query = "SELECT count(*) AS count FROM admission_ticket " +
                       "INNER JOIN patient_file ON admission_ticket.ticket_id = patient_file.file_id " +
                       "WHERE patient_file.hospital = ? AND admission_ticket.stage = \"SENT\";";
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, hospitalAfm);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                transferPendingAdmissionTickets = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            System.err.println("MySQL transfer admission tickets fetching failed");
        }
        return String.valueOf(transferPendingAdmissionTickets);
    }

    /**
     * Method that retrieves the number of transfer pending discharge notes from the database.
     * @param hospitalAfm requires the primary key of discharge_note table in database so as to retrieve the data.
     * @return the number of the number of transfer pending discharge notes.
     */
    public String getTransferPendingDischargeNotes(String hospitalAfm) {
        int transferPendingDischargeNotes = 0;
        String query = "SELECT COUNT(*) AS count FROM discharge_note " +
                       "INNER JOIN patient_file ON discharge_note.note_id = patient_file.file_id " +
                       "WHERE patient_file.hospital = ? " +
                       "AND discharge_note.stage = 1;";
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, hospitalAfm);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                transferPendingDischargeNotes = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            System.err.println("MySQL transfer discharge notes fetching failed");
        }
        return String.valueOf(transferPendingDischargeNotes);
    }

    /**
     * Method that retrieves all the discharge notes to be confirmed from the database.
     * @param hospital requires a key of discharge_note table in database so as to retrieve the data.
     * @return an observable list of data we want to present to our user.
     */
    public ObservableList<DischargeNoteConfirmationScreenTableItem> getDischargeNoteConfirmationScreenTableItems(String hospital) {
        try {
            String query = "SELECT " +
                           "patient.amka AS amka, " +
                           "discharge_note.note_id AS fileId, " +
                           "patient.first_name AS firstName, " +
                           "patient.last_name AS lastName, " +
                           "patient_file.hospital AS hospital, " +
                           "discharge_note.admission_clinic AS clinic, " +
                           "admission_ticket.created_at AS admissionDate, " +
                           "discharge_note.created_at AS dischargeDate, " +
                           "discharge_note.stage AS stage " +
                           "FROM discharge_note " +
                           "INNER JOIN patient_file ON discharge_note.note_id = patient_file.file_id " +
                           "INNER JOIN patient ON patient_file.patient_amka = patient.amka " +
                           "INNER JOIN admission_ticket ON discharge_note.note_id = admission_ticket.ticket_id " +
                           "WHERE patient_file.hospital = ? and discharge_note.stage = 1;";

            ResultSet resultSet;
            DischargeNoteConfirmationScreenTableItem dischargeNoteConfirmationScreenTableItem;
            ObservableList<DischargeNoteConfirmationScreenTableItem> dischargeNoteConfirmationScreenTableItems;

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, hospital);
                resultSet = preparedStatement.executeQuery();
                dischargeNoteConfirmationScreenTableItems = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    dischargeNoteConfirmationScreenTableItem = new DischargeNoteConfirmationScreenTableItem();
                    dischargeNoteConfirmationScreenTableItem.setAmka(resultSet.getString("amka"));
                    dischargeNoteConfirmationScreenTableItem.setFileId(resultSet.getString("fileId"));
                    dischargeNoteConfirmationScreenTableItem.setFirstName(resultSet.getString("firstName"));
                    dischargeNoteConfirmationScreenTableItem.setLastName(resultSet.getString("lastName"));
                    dischargeNoteConfirmationScreenTableItem.setHospital(resultSet.getString("hospital"));
                    dischargeNoteConfirmationScreenTableItem.setClinic(resultSet.getString("clinic"));
                    dischargeNoteConfirmationScreenTableItem.setAdmissionDate(resultSet.getTimestamp("admissionDate"));
                    dischargeNoteConfirmationScreenTableItem.setDischargeDate(resultSet.getTimestamp("dischargeDate"));
                    dischargeNoteConfirmationScreenTableItem.setStage(resultSet.getString("stage"));
                    dischargeNoteConfirmationScreenTableItems.add(dischargeNoteConfirmationScreenTableItem);
                }
            }
            resultSet.close();
            return dischargeNoteConfirmationScreenTableItems;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that retrieves all the posts data from the database.
     * @param postClinic requires a key of clinic_agent_post table in database so as to retrieve the data.
     * @return an observable list of data we want to present to our user.
     */
    public ObservableList<PostListScreenTableItem> getPostListScreenTableItems(String postClinic) {
        try {
            String query = "SELECT " +
                           "clinic_agent_post.post_id AS postId, " +
                           "clinic_agent_post.created_at AS creation, " +
                           "clinic_agent_post.user_name AS author, " +
                           "clinic_agent_post.title AS title " +
                           "FROM clinic_agent_post " +
                           "WHERE clinic_agent_post.clinic_name = ?;";

            ResultSet resultSet;
            PostListScreenTableItem postListScreenTableItem;
            ObservableList<PostListScreenTableItem> postListScreenTableItems;

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, postClinic);
                resultSet = preparedStatement.executeQuery();
                postListScreenTableItems = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    postListScreenTableItem = new PostListScreenTableItem();
                    postListScreenTableItem.setPostDatetime(resultSet.getTimestamp("creation"));
                    postListScreenTableItem.setPostAuthor(resultSet.getString("author"));
                    postListScreenTableItem.setPostTitle(resultSet.getString("title"));
                    postListScreenTableItem.setPostId(resultSet.getString("postId"));
                    postListScreenTableItems.add(postListScreenTableItem);
                }
            }
            resultSet.close();
            return postListScreenTableItems;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that retrieves all patient data from the database so as to present them to the doctors main screen.
     * @param hospital requires a key of patient_file table in database so as to retrieve the data.
     * @param admissionClinic requires a key of admission_ticket table in database so as to retrieve the data.
     * @return an observable list of data we want to present to our user.
     */
    public ObservableList<InitialDoctorScreenListItem> getInitialDoctorScreenListItems(String hospital, String admissionClinic) {
        try {
            String query = "SELECT patient.amka AS amka, patient.first_name AS first_name, " +
                           "patient.last_name AS last_name, admission_ticket.host_clinic AS host_clinic, " +
                           "admission_ticket.patient_chamber AS patient_chamber, " +
                           "patient_file.file_id as file_id FROM patient_file " +
                           "INNER JOIN admission_ticket ON patient_file.file_id = admission_ticket.ticket_id " +
                           "INNER JOIN patient ON patient_file.patient_amka = patient.amka " +
                           "LEFT JOIN discharge_note ON patient_file.file_id = discharge_note.note_id " +
                           "WHERE patient_file.hospital = ? AND admission_ticket.admission_clinic = ? " +
                           "AND (NOT(discharge_note.stage = \"SENT\" OR discharge_note.stage = \"APPROVED\") " +
                           "OR discharge_note.stage IS NULL);";
            ResultSet resultSet;
            InitialDoctorScreenListItem initialDoctorScreenListItem;
            ObservableList<InitialDoctorScreenListItem> initialDoctorScreenListItems;

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)){
                preparedStatement.setString(1,hospital);
                preparedStatement.setString(2,admissionClinic);
                resultSet = preparedStatement.executeQuery();
                initialDoctorScreenListItems = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    initialDoctorScreenListItem = new InitialDoctorScreenListItem();
                    initialDoctorScreenListItem.setAmka(resultSet.getString("amka"));
                    initialDoctorScreenListItem.setFirstName(resultSet.getString("first_name"));
                    initialDoctorScreenListItem.setLastName(resultSet.getString("last_name"));
                    initialDoctorScreenListItem.setHostClinic(resultSet.getString("host_clinic"));
                    initialDoctorScreenListItem.setPatientChamber(resultSet.getString("patient_chamber"));
                    initialDoctorScreenListItem.setFileId(resultSet.getString("file_id"));
                    initialDoctorScreenListItems.add(initialDoctorScreenListItem);
                }
            }
            resultSet.close();
            return initialDoctorScreenListItems;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that retrieves all data from the clinic that the doctor works.
     * @param username requires a key of user table in database so as to retrieve the data.
     * @param doctorClinic requires a key of clinic table in database so as to retrieve the data.
     * @return an observable list of data we want to present to our user.
     */
    public ObservableList<String> getAllClinicNamesOfDoctor(String username, String doctorClinic) {
        try {
            String query = "SELECT clinic.name FROM user " +
                           "INNER JOIN clinic " +
                           "ON clinic.hospital_afm = user.hospital_afm " +
                           "WHERE user.user_name = ? " +
                           "AND clinic.name != ?;";
            ResultSet resultSet;
            Clinic clinic;
            ObservableList<String> clinics;

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)){
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, doctorClinic);
                resultSet = preparedStatement.executeQuery();
                clinics = FXCollections.observableArrayList();
                clinics.add("-");
                while (resultSet.next()) {
                    clinic = new Clinic();
                    clinic.setName(resultSet.getString("name"));
                    clinics.add(clinic.getName());
                }
            }
            resultSet.close();
            return clinics;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that retrieves all data from admission tickets to be confirmed.
     * @param hospitalAfm requires a key of admission_ticket table in database so as to retrieve the data.
     * @return an observable list of data we want to present to our user.
     */
    public ObservableList<AdmissionTicketConfirmationScreenListItem> getAdmissionTicketConfirmationScreenListItem(String hospitalAfm){
        try {
            String query = "SELECT patient.amka AS amka, " +
                           "patient.first_name AS first_name, " +
                           "patient.last_name AS last_name, " +
                           "admission_ticket.admission_clinic AS source_clinic, " +
                           "admission_ticket.host_clinic AS destination_clinic, " +
                           "admission_ticket.stage AS stage, " +
                           "admission_ticket.created_at AS created_at, " +
                           "admission_ticket.ticket_id AS ticket_id " +
                           "FROM admission_ticket " +
                           "INNER JOIN patient_file ON admission_ticket.ticket_id = patient_file.file_id " +
                           "INNER JOIN patient ON patient_file.patient_amka = patient.amka " +
                           "WHERE patient_file.hospital = ? AND admission_ticket.stage = \"SENT\";";
            ResultSet resultSet;
            AdmissionTicketConfirmationScreenListItem admissionTicketConfirmationScreenListItem;
            ObservableList<AdmissionTicketConfirmationScreenListItem> admissionTicketConfirmationScreenListItems;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)){
                preparedStatement.setString(1, hospitalAfm);
                resultSet = preparedStatement.executeQuery();
                admissionTicketConfirmationScreenListItems = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    admissionTicketConfirmationScreenListItem = new AdmissionTicketConfirmationScreenListItem();
                    admissionTicketConfirmationScreenListItem.setAmka(resultSet.getString("amka"));
                    admissionTicketConfirmationScreenListItem.setFirstName(resultSet.getString("first_name"));
                    admissionTicketConfirmationScreenListItem.setLastName(resultSet.getString("last_name"));
                    admissionTicketConfirmationScreenListItem.setSourceClinic(resultSet.getString("source_clinic"));
                    admissionTicketConfirmationScreenListItem.setDestinationClinic(resultSet.getString("destination_clinic"));
                    admissionTicketConfirmationScreenListItem.setStage(resultSet.getString("stage"));
                    admissionTicketConfirmationScreenListItem.setCreatedAt(resultSet.getTimestamp("created_at"));
                    admissionTicketConfirmationScreenListItem.setId(resultSet.getString("ticket_id"));
                    admissionTicketConfirmationScreenListItems.add(admissionTicketConfirmationScreenListItem);
                }
            }
            resultSet.close();

            return admissionTicketConfirmationScreenListItems;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that retrieves all the data from admission tickets.
     * @param amka requires a key of patient table in database so as to retrieve the data.
     * @param ticketId requires a key of admission_ticket table in database so as to retrieve the data.
     * @return an observable list of data we want to present to our user.
     */
    public ObservableList<AdmissionTicketDetailsScreenListItem> getAdmissionTicketDetailsScreenListItems(String amka, String ticketId) {
        String query = "select patient.first_name as first_name, patient.last_name as last_name, " +
                       "patient.birth_date as birth_date, patient.gender as gender, admission_ticket.admission_text as admission_text " +
                       "from patient_file " +
                       "inner join patient on patient.amka = patient_file.patient_amka " +
                       "inner join admission_ticket on patient_file.file_id = admission_ticket.ticket_id " +
                       "where patient.amka = ? " +
                       "and admission_ticket.ticket_id = ?;";
        ResultSet resultSet;
        AdmissionTicketDetailsScreenListItem admissionTicketDetailsScreenListItem;
        ObservableList<AdmissionTicketDetailsScreenListItem> admissionTicketDetailsScreenListItems;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {

            preparedStatement.setString(1, amka);
            preparedStatement.setString(2, ticketId);

            resultSet = preparedStatement.executeQuery();
            admissionTicketDetailsScreenListItems = FXCollections.observableArrayList();

            while (resultSet.next()) {
                admissionTicketDetailsScreenListItem = new AdmissionTicketDetailsScreenListItem();
                admissionTicketDetailsScreenListItem.setFirstName(resultSet.getString("first_name"));
                admissionTicketDetailsScreenListItem.setLastName(resultSet.getString("last_name"));
                admissionTicketDetailsScreenListItem.setBirthDate(resultSet.getDate("birth_date"));
                admissionTicketDetailsScreenListItem.setGender(resultSet.getString("gender"));
                admissionTicketDetailsScreenListItem.setAdmissionText(resultSet.getString("admission_text"));
                admissionTicketDetailsScreenListItems.add(admissionTicketDetailsScreenListItem);
            }
            resultSet.close();
            return admissionTicketDetailsScreenListItems;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method that retrieves all data from pending admission tickets.
     * @param hospitalAfm requires a key of patient_file table in database so as to retrieve the data.
     * @param clinicName requires a key of admission_ticket table in database so as to retrieve the data.
     * @return an observable list of data we want to present to our user.
     */
    public ObservableList<PendingAdmissionTicketsScreenListItem> getPendingAdmissionTicketsScreenListItems(String hospitalAfm, String clinicName) {
        String query = "SELECT patient.amka AS amka, patient.first_name AS first_name, patient.last_name AS last_name, " +
                       "admission_ticket.created_at AS created_at, admission_ticket.ticket_id AS ticket_id FROM patient_file " +
                       "INNER JOIN patient ON patient_file.patient_amka = patient.amka " +
                       "INNER JOIN admission_ticket ON patient_file.file_id = admission_ticket.ticket_id " +
                       "WHERE patient_file.hospital = ? AND (admission_ticket.host_clinic = ? " +
                       "OR admission_ticket.admission_clinic = ?) AND admission_ticket.stage = \"CREATED\";";
        ResultSet resultSet;
        PendingAdmissionTicketsScreenListItem pendingAdmissionTicketsScreenListItem;
        ObservableList<PendingAdmissionTicketsScreenListItem> pendingAdmissionTicketsScreenListItems;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {

            preparedStatement.setString(1, hospitalAfm);
            preparedStatement.setString(2, clinicName);
            preparedStatement.setString(3, clinicName);

            resultSet = preparedStatement.executeQuery();
            pendingAdmissionTicketsScreenListItems = FXCollections.observableArrayList();

            while (resultSet.next()) {
                pendingAdmissionTicketsScreenListItem = new PendingAdmissionTicketsScreenListItem();
                pendingAdmissionTicketsScreenListItem.setAmka(resultSet.getString("amka"));
                pendingAdmissionTicketsScreenListItem.setFirstName(resultSet.getString("first_name"));
                pendingAdmissionTicketsScreenListItem.setLastName(resultSet.getString("last_name"));
                pendingAdmissionTicketsScreenListItem.setCreatedAt(resultSet.getTimestamp("created_at"));
                pendingAdmissionTicketsScreenListItem.setTicketId(resultSet.getString("ticket_id"));
                pendingAdmissionTicketsScreenListItems.add(pendingAdmissionTicketsScreenListItem);
            }
            resultSet.close();
            return pendingAdmissionTicketsScreenListItems;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method that retrieves every possible match from patient table.
     * @param amka requires a key of patient table in database so as to retrieve the data.
     * @param afm requires a key of patient table in database so as to retrieve the data.
     * @param firstName requires a key of patient table in database so as to retrieve the data.
     * @param lastName requires a key of patient table in database so as to retrieve the data.
     * @param gender requires a key of patient table in database so as to retrieve the data.
     * @param fatherFirstName requires a key of patient table in database so as to retrieve the data.
     * @param fatherLastName requires a key of patient table in database so as to retrieve the data.
     * @param motherFirstName requires a key of patient table in database so as to retrieve the data.
     * @param motherLastName requires a key of patient table in database so as to retrieve the data.
     * @param birthDate requires a key of patient table in database so as to retrieve the data.
     * @return an observable list of data we want to present to our user.
     */
    public ObservableList<PossibleMatchesScreenListItem> getPossibleMatchesScreenListItems(
            String amka, String afm, String firstName, String lastName, String gender, String fatherFirstName, String fatherLastName,
            String motherFirstName, String motherLastName, String birthDate) {

        String query = "select amka, afm, first_name, last_name, gender, father_first_name, mother_first_name, birth_date from patient " +
                       "where (amka like ? or amka is null) " +
                       "and (afm like ? or afm is null) " +
                       "and (first_name like ? or first_name is null) " +
                       "and (last_name like ? or last_name is null) " +
                       "and (gender like ? or gender is null)" +
                       "and (father_first_name like ? or father_first_name is null) " +
                       "and (father_last_name like ? or father_last_name is null) " +
                       "and (mother_first_name like ? or mother_first_name is null) " +
                       "and (mother_last_name like ? or mother_last_name is null) " +
                       "and (birth_date like ? or birth_date is null);";
        ResultSet resultSet;
        PossibleMatchesScreenListItem possibleMatchesScreenListItem;
        ObservableList<PossibleMatchesScreenListItem> possibleMatchesScreenListItems;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            if (!amka.equals("")) {
                preparedStatement.setString(1, amka);
            } else {
                preparedStatement.setString(1, "%");
            }
            if (!afm.equals("")) {
                preparedStatement.setString(2, afm);
            } else {
                preparedStatement.setString(2, "%");
            }
            if (!firstName.equals("")) {
                preparedStatement.setString(3, firstName);
            } else {
                preparedStatement.setString(3, "%");
            }
            if (!lastName.equals("")) {
                preparedStatement.setString(4, lastName);
            } else {
                preparedStatement.setString(4, "%");
            }
            if (!gender.equals("")) {
                preparedStatement.setString(5, gender);
            } else {
                preparedStatement.setString(5, "%");
            }
            if (!fatherFirstName.equals("")) {
                preparedStatement.setString(6, fatherFirstName);
            } else {
                preparedStatement.setString(6, "%");
            }
            if (!fatherLastName.equals("")) {
                preparedStatement.setString(7, fatherLastName);
            } else {
                preparedStatement.setString(7, "%");
            }
            if (!motherFirstName.equals("")) {
                preparedStatement.setString(8, motherFirstName);
            } else {
                preparedStatement.setString(8, "%");
            }
            if (!motherLastName.equals("")) {
                preparedStatement.setString(9, motherLastName);
            } else {
                preparedStatement.setString(9, "%");
            }
            if (!birthDate.equals("")) {
                preparedStatement.setString(10, birthDate);
            } else {
                preparedStatement.setString(10, "%");
            }
            System.out.println(preparedStatement);

            resultSet = preparedStatement.executeQuery();
            possibleMatchesScreenListItems = FXCollections.observableArrayList();

            while (resultSet.next()) {
                possibleMatchesScreenListItem = new PossibleMatchesScreenListItem();
                possibleMatchesScreenListItem.setFirstName(resultSet.getString("first_name"));
                possibleMatchesScreenListItem.setLastName(resultSet.getString("last_name"));
                possibleMatchesScreenListItem.setAmka(resultSet.getString("amka"));
                possibleMatchesScreenListItem.setAfm(resultSet.getString("afm"));
                possibleMatchesScreenListItem.setBirthDate(resultSet.getString("birth_date"));
                possibleMatchesScreenListItem.setGender(resultSet.getString("gender"));
                possibleMatchesScreenListItem.setFatherFirstName(resultSet.getString("father_first_name"));
                possibleMatchesScreenListItem.setMotherFirstName(resultSet.getString("mother_first_name"));
                possibleMatchesScreenListItems.add(possibleMatchesScreenListItem);
            }
            resultSet.close();
            return possibleMatchesScreenListItems;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method that retrieves all chambers with free beds from the database.
     * @param clinic requires a key of chamber table in database so as to retrieve the data.
     * @param hospital requires a key of chamber table in database so as to retrieve the data.
     * @return an observable list of data we want to present to our user.
     */
    public ObservableList<String> getChambersWithFreeBeds(String clinic, String hospital) {
        String query = "select chamber.id as id " +
                       "from bed " +
                       "inner join chamber " +
                       "on bed.chamber_id = chamber.id " +
                       "where chamber.clinic_name = ? " +
                       "and chamber.clinic_hospital = ? " +
                       "and bed.is_free = '0' " +
                       "group by chamber.id;";
        ResultSet resultSet;
        ObservableList<String> chambersWithFreeBeds;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {

            preparedStatement.setString(1, clinic);
            preparedStatement.setString(2, hospital);

            resultSet = preparedStatement.executeQuery();
            chambersWithFreeBeds = FXCollections.observableArrayList();

            while (resultSet.next()) {
                chambersWithFreeBeds.add(resultSet.getString("id"));
            }
            resultSet.close();
            return chambersWithFreeBeds;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method that retrieves all free beds of a chamber from database.
     * @param clinic requires a key of chamber table in database so as to retrieve the data.
     * @param hospital requires a key of chamber table in database so as to retrieve the data.
     * @param chamber requires a key of chamber table in database so as to retrieve the data.
     * @return an observable list of data we want to present to our user.
     */
    public ObservableList<String> getFreeBedsOfChamber(String clinic, String hospital, String chamber) {
        try {
            String query = "select bed.number as number " +
                           "from bed " +
                           "inner join chamber " +
                           "on bed.chamber_id = chamber.id " +
                           "where chamber.id = ? " +
                           "and chamber.clinic_name = ? " +
                           "and chamber.clinic_hospital = ? " +
                           "and bed.is_free = '0';";
            ResultSet resultSet;
            ObservableList<String> freeBeds;

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)){

                preparedStatement.setString(1, chamber);
                preparedStatement.setString(2, clinic);
                preparedStatement.setString(3, hospital);

                resultSet = preparedStatement.executeQuery();
                freeBeds = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    freeBeds.add(resultSet.getString("number"));
                }
            }
            resultSet.close();
            return freeBeds;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that allocates the bed.is_free value to 1 in the database.
     * @param number requires a key of bed table in database so as to retrieve the data.
     */
    public void allocateBed(String number) {
        String query = "update bed set is_free = 1 where bed.number = ?;";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that updates admission_ticket.stage to SENT in the database.
     * @param ticketId requires a key of chamber table in database so as to retrieve the data.
     * @param chamber requires a key of bed table in database so as to retrieve the data.
     * @param bed requires a key of admission_ticket table in database so as to retrieve the data.
     */
    public void updateTicket(String ticketId, String chamber, String bed) {
        String query = "update admission_ticket set patient_chamber = ?, patient_bed = ?, stage = 2 where ticket_id = ?;";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, chamber);
            preparedStatement.setString(2, bed);
            preparedStatement.setString(3, ticketId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that finally confirms the temporary admission ticket.
     * @param id requires a key of admission_ticket table in database so as to retrieve the data.
     */
    public void finalConfirmationOfTemporaryAdmissionTicket(String id){
        try {
            String query = "UPDATE admission_ticket SET admission_ticket.stage = \"APPROVED\" WHERE admission_ticket.ticket_id = ?;";

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ignore) {
        }
    }

    /**
     * Method that updates the diagnosis in patient_file table of database.
     * @param diagnosis requires a key of patient_file table in database so as to retrieve the data.
     * @param amka requires a key of patient_file table in database so as to retrieve the data.
     */
    public void saveNewDiagnosis(String diagnosis, String amka) {
        try {
            String query = "UPDATE patient_file SET patient_file.diagnosis = ? WHERE patient_file.patient_amka = ?;";

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, diagnosis);
                preparedStatement.setString(2, amka);
                preparedStatement.executeUpdate();
            }
        }catch (SQLException ignore){
        }
    }

    /**
     * Method that updates the treatment in patient_file table of database.
     * @param treatment requires a key of patient_file table in database so as to retrieve the data.
     * @param amka requires a key of chamber patient_file in database so as to retrieve the data.
     */
    public void saveNewTreatment(String treatment, String amka) {
        try {
            String query = "UPDATE patient_file SET patient_file.treatment = ? WHERE patient_file.patient_amka = ?;";

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, treatment);
                preparedStatement.setString(2, amka);
                preparedStatement.executeUpdate();
            }
        }catch (SQLException ignore){
        }
    }

    /**
     * Method that inserts into the clinic_agent_post table a new post.
     * @param clinicName requires a value of clinic_name to insert into the table clinic_agent_post.
     * @param userName requires a value of user_name to insert into the table clinic_agent_post.
     * @param date requires a value of date to insert into the table clinic_agent_post.
     * @param title requires a value of title to insert into the table clinic_agent_post.
     * @param post requires a value of post to insert into the table clinic_agent_post.
     * @return the number of insertions (Good = 1).
     */
    public int savePost(String clinicName, String userName, String date, String title, String post) {
        int resultSet = 1;
        String constSep = "', '";
        String closureParenthesis = "');";
        StringBuilder query = new StringBuilder("INSERT INTO clinic_agent_post (post_id, clinic_name, user_name, created_at, title, post_text) VALUES ('");
        String postId = random(19);
        query.append(postId).append(constSep).append(clinicName).append(constSep).append(
                userName).append(constSep).append(date).append(constSep).append(title).append(
                constSep).append(post.replace("\n", " ").replace("\r", " ")).append(closureParenthesis);
        String uploadPost = query.toString();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(uploadPost)) {
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * Method that inserts into the discharge_note table a new discharge note.
     * @param note_id requires a value of note_id to insert into the table discharge_note.
     * @param discharge_text requires a value of discharge_text to insert into the table discharge_note.
     * @param clinic requires a value of clinic to insert into the table discharge_note.
     */
    public void insertDischargeNote(String note_id, String discharge_text, String clinic) {
        try {
            String query = "INSERT INTO discharge_note (note_id, created_at, discharge_text, admission_clinic, stage) " +
                           "VALUES (?, NOW(), ?, ?, \"SENT\");";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1,note_id);
                preparedStatement.setString(2,discharge_text);
                preparedStatement.setString(3,clinic);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ignore) {
        }
    }

    /**
     * Method that inserts into the admission_ticket table a new ticket.
     * @param ticketId requires a value of ticket_id to insert into the table admission_ticket.
     * @param admissionClinic requires a value of admission_clinic to insert into the table admission_ticket.
     * @param hostClinic requires a value of host_clinic to insert into the table admission_ticket.
     * @param admissionText requires a value of admission_text to insert into the table admission_ticket.
     */
    public void insertAdmissionTicket(String ticketId, String admissionClinic, String hostClinic, String admissionText){
        try {
            String query = "INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, admission_text, stage) " +
                           "VALUES (?, NOW(), ?, ?, ?, \"CREATED\");";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1,ticketId);
                preparedStatement.setString(2,admissionClinic);
                preparedStatement.setString(3,hostClinic);
                preparedStatement.setString(4,admissionText);
                int x = preparedStatement.executeUpdate();
                System.out.println("admInsert " + x);
            }
        } catch (SQLException ignore) {
        }
    }

    /**
     * Method that inserts into the patient_file table a new patient file.
     * @param amka requires a value of amka to insert into the table patient_file.
     * @param hospitalAfm requires a value of hospital_afm to insert into the table patient_file.
     * @param username requires a value of user_name to insert into the table patient_file.
     */
    public void insertPatientFile(String amka, String hospitalAfm, String username) {
        String rand = random(19);
        try {
            String query = "INSERT INTO patient_file (patient_amka, file_id, hospital, doctor) " +
                           "VALUES (?, ?, ?, ?);";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1,amka);
                preparedStatement.setString(2,rand);
                preparedStatement.setString(3,hospitalAfm);
                preparedStatement.setString(4,username);
                int x = preparedStatement.executeUpdate();
                System.out.println("patFileInsert " + x);
            }
        } catch (SQLException ignore) {
        }
    }

    /**
     * Method that inserts into the billing table a new billing.
     * @param fileId requires a value of file_id to insert into the table billing.
     * @param generatedFloat requires a value of generatedFloat to insert into the table billing as price.
     */
    public void insertBilling(String fileId, float generatedFloat) {
        try {
            String query = "INSERT INTO billing (billing_id, created_at, price) " +
                    "VALUES (?, NOW(), ?);";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, fileId);
                preparedStatement.setString(2, String.valueOf(generatedFloat));
                int x = preparedStatement.executeUpdate();
                System.out.println("insBill " + x);
            }
        } catch (SQLException ignore) {
        }
    }

    /**
     * Method that retrieves all patient_file from amka and hospital.
     * @param amka requires a value of amka to retrieve the data.
     * @param hospitalAfm requires a value of hospital_afm to insert into the table patient_file.
     * @return the values to model.PatientFile.
     */
    public PatientFile getFileIdFromAmkaAndHospital(String amka, String hospitalAfm) {
        try {
            String query = "SELECT file_id FROM patient_file " +
                           "WHERE patient_amka = ? " +
                           "AND hospital = ?;";

            ResultSet resultSet;
            PatientFile patientFile;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, amka);
                preparedStatement.setString(2,hospitalAfm);
                resultSet = preparedStatement.executeQuery();
                patientFile = null;
                if (resultSet.next()) {
                    patientFile = new PatientFile();
                    patientFile.setFileId(resultSet.getString("file_id"));
                    patientFile.setHospital(hospitalAfm);
                }
            }
            resultSet.close();
            return patientFile;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that initializes all characters from 0-9, a-z and A-Z.
     * @return a table of chars of these characters.
     */
    public static char[] alphanumericAlphabet() {
        return IntStream.concat(
                IntStream.concat(
                        IntStream.rangeClosed('0', '9'),
                        IntStream.rangeClosed('A', 'Z')
                ),
                IntStream.rangeClosed('a', 'z')
        ).mapToObj(c -> (char) c+"").collect(Collectors.joining()).toCharArray();
    }

    /**
     * Method that produces a random string of characters of the alphanumericAlphabet() method.
     * @param numChars argument with the maximum number of characters.
     * @return the string of random characters.
     */
    public static String random(final int numChars) {
        Random r = new Random();
        String alpha = new String(alphanumericAlphabet());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numChars; i++) {
            sb.append(alpha.charAt(r.nextInt(alpha.length())));
        }
        return sb.toString();
    }

    /**
     * Method that gets connection with the database server.
     * @return connection
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * Method that sets connection with the database server.
     * @param connection populates with DriverManager.getConnection(url_property, user_property, password_property).
     */
    public void setConnection(Connection connection) {
        ICRUDImpl.connection = connection;
    }

    /**
     * Method that initializes and opens the connection with the database server.
     * Fill your connection properties in the connection.properties file in MySQL folder.
     */
    public void openConnection() {
        try {
            System.out.println("Setting up connection.");
            Properties connection_properties = new Properties();
            connection_properties.load(new FileInputStream("MySQL/connection.properties"));
            String url_property = connection_properties.getProperty("url");
            String user_property = connection_properties.getProperty("user");
            String password_property = connection_properties.getProperty("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            setConnection(DriverManager.getConnection(url_property, user_property, password_property));
            System.out.println("Connection established successfully with the database server.");
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
