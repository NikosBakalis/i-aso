package database;

import model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class ICRUDImpl implements ICRUD {

    private static Connection connection;

    public Hospital getHospital(String afm) {
        try {
            String query = "SELECT * FROM hospital WHERE hospital.hospital_afm = ?";

            ResultSet resultSet;
            Hospital hospital;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, afm);
                resultSet = preparedStatement.executeQuery();
                hospital = null;
                if(resultSet.next()) {
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

    @Override
    public Clinic getClinic(String name, String hospital_afm) {
        try {
            String query = "SELECT * FROM clinic WHERE clinic.name = ? AND clinic.hospital_afm = ?";

            ResultSet resultSet;
            Clinic clinic;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, hospital_afm);
                resultSet = preparedStatement.executeQuery();
                clinic = null;
                if(resultSet.next()) {
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

    @Override
    public Patient getPatient(String amka) {
        try {
            String query = "SELECT * FROM patient WHERE patient.amka = ?";

            ResultSet resultSet;
            Patient patient;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, amka);
                resultSet = preparedStatement.executeQuery();
                patient = null;
                if(resultSet.next()) {
                    patient = new Patient();
                    patient.setAmka(resultSet.getString("amka"));
                    patient.setAfm(resultSet.getString("afm"));
                    patient.setFirstName(resultSet.getString("first_name"));
                    patient.setLastName(resultSet.getString("last_name"));
                    patient.setBirthDate(resultSet.getDate("birth_date"));
                    patient.setNationality(resultSet.getString("nationality"));
                    patient.setReligion(resultSet.getString("religion"));
                    patient.setGender(resultSet.getString("gender"));
                    patient.setInsurance(resultSet.getString("insurance"));
                    patient.setFatherFirstName(resultSet.getString("father_first_name"));
                    patient.setFatherLastName(resultSet.getString("father_last_name"));
                    patient.setMotherFirstName(resultSet.getString("mother_first_name"));
                    patient.setMotherLastName(resultSet.getString("mother_last_name"));
                    patient.setFirstStreetName(resultSet.getString("first_street_name"));
                    patient.setFirstStreetNumber(resultSet.getString("first_street_number"));
                    patient.setPrimaryPhoneNumber(resultSet.getString("primary_phone_number"));
                    patient.setEmergencePhoneNumber(resultSet.getString("emergency_phone_number"));
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

    @Override
    public PatientFolder getPatientFolder(String patient_amka) {
        try {
            String query = "SELECT * FROM patient_folder WHERE patient_folder.patient_amka = ?";
            ResultSet resultSet;
            PatientFolder patientFolder;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, patient_amka);
                resultSet = preparedStatement.executeQuery();
                patientFolder = null;
                if(resultSet.next()) {
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

    @Override
    public PatientFile getPatientFile(String file_id) {
        try {
            String query = "SELECT * FROM patient_file WHERE patient_file.file_id = ?";
            ResultSet resultSet;
            PatientFile patientFile;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, file_id);
                resultSet = preparedStatement.executeQuery();
                patientFile = null;
                if(resultSet.next()) {
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

    @Override
    public Chamber getChamber(String id) {
        try {
            String query = "SELECT * FROM chamber WHERE chamber.id = ?";
            ResultSet resultSet;
            Chamber chamber;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, id);
                resultSet = preparedStatement.executeQuery();
                chamber = null;
                if(resultSet.next()) {
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

    @Override
    public Bed getBed(String number) {
        try {
            String query = "SELECT * FROM bed WHERE bed.number = ?";
            ResultSet resultSet;
            Bed bed;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, number);
                resultSet = preparedStatement.executeQuery();
                bed = null;
                if(resultSet.next()) {
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

    @Override
    public AdmissionTicket getAdmissionTicket(String ticket_id) {
        try {
            String query = "SELECT * FROM admission_ticket WHERE admission_ticket.ticket_id = ?";
            ResultSet resultSet;
            AdmissionTicket admissionTicket;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, ticket_id);
                resultSet = preparedStatement.executeQuery();
                admissionTicket = null;
                if(resultSet.next()) {
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

    @Override
    public DischargeNote getDischargeNote(String note_id) {
        try {
            String query = "SELECT * FROM discharge_note WHERE discharge_note.note_id = ?";
            ResultSet resultSet;
            DischargeNote dischargeNote;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, note_id);
                resultSet = preparedStatement.executeQuery();
                dischargeNote = null;
                if(resultSet.next()) {
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

    @Override
    public Billing getBilling(String billing_id) {
        try {
            String query = "SELECT * FROM billing WHERE billing.billing_id = ?";
            ResultSet resultSet;
            Billing billing;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, billing_id);
                resultSet = preparedStatement.executeQuery();
                billing = null;
                if(resultSet.next()) {
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

    public User getUser(String username) {
        try {
            String query = "SELECT * FROM user WHERE user.user_name = ?";
            ResultSet resultSet;
            User user;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                user = null;
                if(resultSet.next()) {
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

    public Doctor getDoctor(String username) {
        try {
            String query = "SELECT * FROM doctor WHERE doctor.user_name = ?";

            ResultSet resultSet;
            Doctor doctor;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                doctor = null;
                if(resultSet.next()) {
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

    @Override
    public Transfer getTransfer(Date id, String patient_amka) {
        try {
            String query = "SELECT * FROM transfer WHERE transfer.id = ? AND transfer.patient_amka = ?";

            ResultSet resultSet;
            Transfer transfer;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setDate(1, id);
                preparedStatement.setString(2, patient_amka);
                resultSet = preparedStatement.executeQuery();
                transfer = null;
                if(resultSet.next()) {
                    transfer = new Transfer();
                    transfer.setId(resultSet.getDate("id"));
                    transfer.setAuthorizedBy(resultSet.getString("authorized_by"));
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

    @Override
    public Lab getLab(String name, String hospital_afm) {
        try {
            String query = "SELECT * FROM lab WHERE lab.name = ? AND lab.hospital_afm = ?";

            ResultSet resultSet;
            Lab lab;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, hospital_afm);
                resultSet = preparedStatement.executeQuery();
                lab = null;
                if(resultSet.next()) {
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

    @Override
    public ClinicAgent getClinicAgent(String username) {
        try {
            String query = "SELECT * FROM clinic_agent WHERE clinic_agent.user_name = ?";

            ResultSet resultSet;
            ClinicAgent clinicAgent;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                clinicAgent = null;
                if(resultSet.next()) {
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

    public static Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        ICRUDImpl.connection = connection;
    }
}
