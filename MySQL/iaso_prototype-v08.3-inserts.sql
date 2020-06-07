USE iaso_hospital_db_v08;

INSERT INTO hospital (afm) VALUES ('0123456789');

INSERT INTO clinic (name, hospital_afm, vacant_beds) VALUES ('ΝΕΥΡΟΛΟΓΙΚΗ', '0123456789', 4);
INSERT INTO clinic (name, hospital_afm, vacant_beds) VALUES ('ΚΑΡΔΙΟΛΟΓΙΚΗ', '0123456789', 3);

#patients already in hospital
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('88374920', '37298563', 'ΦΩΤΗΣ', 'ΤΣΙΓΔΕΜΟΓΛΟΥ', '1968-05-23', 'GR', 1, 'ΕΟΠΥΥ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('86727365', '27273664', 'ΑΝΔΡΕΑΣ', 'ΚΑΡΑΤΖΑΣ', '1964-03-22', 'GR', 1, 'ΓΕΝ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('23456763', '57348335', 'ΠΑΝΑΓΙΩΤΗΣ', 'ΤΣΑΚΑΣ', '1978-06-12', 'GR', 1, 'ΕΟΠΥΥ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('35723453', '75345634', 'ΜΑΚΗΣ', 'ΚΟΤΣΑΜΠΑΣΗΣ', '1989-05-13', 'GR', 1, 'ΕΟΠΥΥ');
#patients not in hospital
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('38294679', '25236633', 'ΝΙΚΟΣ', 'ΜΠΑΚΑΛΗΣ', '1987-10-03', 'GR', 1, 'ΤΕΒΕ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('72364859', '94337923', 'ΑΝΝΑ', 'ΜΑΓΙΑΚΗ', '1997-11-03', 'GR', 2, 'ΕΦΚΑ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('84563453', '23462484', 'ΔΙΟΝΥΣΗΣ', 'ΜΑΥΡΟΤΣΟΥΚΑΛΟΣ', '1989-09-04', 'GR', 1, 'ΕΟΠΥΥ');

INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('88374920', 'Όλα εγώ πρέπει να τα κάνω σε αυτό το μαγαζί', 'Αφεντικό', 'Ευτυχώς καμία', 7, 1, 1);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('86727365', 'Του αρέσουν τα Ubuntu και για έναν περίεργο λόγο γράφει τα πάντα με LaTeX', 'Microsoft', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 1, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('23456763', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 'LaTeX και Linux', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 1, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('35723453', 'Μπύρες, Συνεργείο, Τίγρεις', 'Εργασία και δουλειά γενικότερα', 'Allien x234', 5, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('38294679', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 'CEID', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 2, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('72364859', 'Τίποτα, είναι ο πιο καλοσυνάτος άνθρωπος που έχω γνωρίσει', 'Τίποτα', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 2, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('84563453', 'Έχει ένα παλιοκαναπέ', 'Βάζελους', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 2, 2, 2);

#doctor users
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('doctor1', '0123456789', 'ALATOLY', 'KARPOV', '1976-10-05', 'doctor1', 1);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('doctor2', '0123456789', 'JOSE', 'CAPABLANCA', '1988-01-23', 'doctor2', 1);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('doctor3', '0123456789', 'MIKHAIL', 'TAL', '1992-10-19', 'doctor3', 1);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('doctor4', '0123456789', 'HIKARU', 'NAKAMURA', '1992-08-06', 'doctor4', 1);
#clinic agent (nurse) users
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('nurse1', '0123456789', 'BOBBY', 'FISCHER', '1996-02-23', 'nurse1', 3);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('nurse2', '0123456789', 'VLADIMIR', 'KRAMNIK', '1990-04-05', 'nurse2', 3);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('nurse3', '0123456789', 'VESELIN', 'TOPALOV', '1965-03-28', 'nurse3', 3);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('nurse4', '0123456789', 'LEVON', 'ARONIAN', '1977-10-11', 'nurse4', 3);
#transfer office agent users
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('agent1', '0123456789', 'MAGNUS', 'CARLSEN', '1987-10-03', 'agent1', 4);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('agent2', '0123456789', 'PAUL', 'MORPHY', '1976-12-15', 'agent2', 4);

INSERT INTO doctor (user_name, sector, clinic) VALUES ('doctor1', 'ΟΓΚΟΛΟΓΙΑ', 'ΝΕΥΡΟΛΟΓΙΚΗ');
INSERT INTO doctor (user_name, sector, clinic) VALUES ('doctor2', 'ΝΕΥΡΟΧΕΙΡΟΥΡΓΙΚΗ', 'ΝΕΥΡΟΛΟΓΙΚΗ');
INSERT INTO doctor (user_name, sector, clinic) VALUES ('doctor3', 'ΠΑΘΟΛΟΓΙΑ', 'ΚΑΡΔΙΟΛΟΓΙΚΗ');
INSERT INTO doctor (user_name, sector, clinic) VALUES ('doctor4', 'ΚΑΡΔΙΟΧΕΙΡΟΥΡΓΙΚΗ', 'ΚΑΡΔΙΟΛΟΓΙΚΗ');

INSERT INTO patient_transfer_office (number, hospital_afm) VALUES ('67768433', '0123456789');

INSERT INTO transfer_office_agent (user_name, office_number) VALUES ('agent1', '67768433');
INSERT INTO transfer_office_agent (user_name, office_number) VALUES ('agent2', '67768433');

INSERT INTO clinic_agent (user_name, clinic_name) VALUES ('nurse1', 'ΝΕΥΡΟΛΟΓΙΚΗ');
INSERT INTO clinic_agent (user_name, clinic_name) VALUES ('nurse2', 'ΝΕΥΡΟΛΟΓΙΚΗ');
INSERT INTO clinic_agent (user_name, clinic_name) VALUES ('nurse3', 'ΚΑΡΔΙΟΛΟΓΙΚΗ');
INSERT INTO clinic_agent (user_name, clinic_name) VALUES ('nurse4', 'ΚΑΡΔΙΟΛΟΓΙΚΗ');

INSERT INTO clinic_agent_post (post_id, clinic_name, user_name, created_at, post_text) VALUES ('67896534565', 'ΝΕΥΡΟΛΟΓΙΚΗ', 'nurse1', NOW(), 'Μη ξεχάσετε να κλείσετε το θερμοσίφωνα !');
INSERT INTO clinic_agent_post (post_id, clinic_name, user_name, created_at, post_text) VALUES ('67896534546', 'ΝΕΥΡΟΛΟΓΙΚΗ', 'nurse2', NOW(), 'Ναι γεια σας, μια παραγγελία θα ήθελα να κάνω ... ');
INSERT INTO clinic_agent_post (post_id, clinic_name, user_name, created_at, title, post_text) VALUES ('65875657786', 'ΚΑΡΔΙΟΛΟΓΙΚΗ', 'nurse3', NOW(), 'ΟΓΚΟΥΝΣΟΤΟ', 'ΠΩΣ ΓΚΕΝΕΝ ΑΤΟ;');
INSERT INTO clinic_agent_post (post_id, clinic_name, user_name, created_at, title, post_text) VALUES ('89346787455', 'ΚΑΡΔΙΟΛΟΓΙΚΗ', 'nurse4', NOW(), 'CEID', 'Τα βιβλία τα έχετε πάρει;');

#patient files of patients already in hospital
INSERT INTO patient_file (patient_amka, file_id, hospital, doctor, diagnosis, treatment, lab_tests) VALUES ('88374920', '5627092159', '0123456789', 'doctor1', 'Πρώτο μπόι', 'Χρόνια βαρεμάρα', 'Η βλακεία δε γιατρεύεται');
INSERT INTO patient_file (patient_amka, file_id, hospital, doctor, diagnosis, treatment, lab_tests) VALUES ('86727365', '2346234633', '0123456789', 'doctor1', 'COVID-1', 'Θα μας μείνει στα χέρια', 'Καμία σωτηρία');
INSERT INTO patient_file (patient_amka, file_id, hospital, doctor, diagnosis, treatment, lab_tests) VALUES ('23456763', '2346234456', '0123456789', 'doctor2', 'COVID-19', 'Ίσως τη γλιτώσει', '2 προσευχές τη μέρα');
INSERT INTO patient_file (patient_amka, file_id, hospital, doctor, diagnosis, treatment, lab_tests) VALUES ('35723453', '8943678443', '0123456789', 'doctor3', 'Μπυροκοιλιά', 'Συνεργείο ο Μάκης και οι Παίδαροι', '99% Ολυμπιακός 1% Βάζελος');

#INSERT INTO patient_file (patient_amka, file_id, hospital, doctor) VALUES ('38294679', '5627457859', '0123456789', 'doctor1');
#INSERT INTO patient_file (patient_amka, file_id, hospital, doctor) VALUES ('72364859', '5634522158', '0123456789', 'doctor1');
#INSERT INTO patient_file (patient_amka, file_id, hospital, doctor) VALUES ('84563453', '5656882163', '0123456789', 'doctor1');

INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('1000', 'ΝΕΥΡΟΛΟΓΙΚΗ', '0123456789');
INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('2000', 'ΝΕΥΡΟΛΟΓΙΚΗ', '0123456789');
INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('3000', 'ΚΑΡΔΙΟΛΟΓΙΚΗ', '0123456789');
INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('4000', 'ΚΑΡΔΙΟΛΟΓΙΚΗ', '0123456789');

INSERT INTO bed (number, chamber_id, is_free) VALUES ('1001', '1000', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('1002', '1000', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('1003', '1000', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('2001', '2000', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('2002', '2000', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('2003', '2000', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('3001', '3000', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('3002', '3000', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('3003', '3000', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('4001', '4000', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('4002', '4000', FALSE);

#admision tickets for patients already in hospital
INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, admission_text, stage) VALUES ('5627092159', '2020-03-20', 'ΝΕΥΡΟΛΟΓΙΚΗ', 'ΝΕΥΡΟΛΟΓΙΚΗ', 'Καλησπέρα σας', 1);
INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, patient_chamber, patient_bed, admission_text, stage) VALUES ('2346234633', '2020-03-04', 'ΝΕΥΡΟΛΟΓΙΚΗ', 'ΚΑΡΔΙΟΛΟΓΙΚΗ', '1000', '1001', 'Καλή χρονιά', 2);
INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, admission_text, stage) VALUES ('2346234456', '2020-04-06', 'ΚΑΡΔΙΟΛΟΓΙΚΗ', 'ΚΑΡΔΙΟΛΟΓΙΚΗ', 'Χρόνια πολλά', 1);
INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, patient_chamber, patient_bed, admission_text, stage) VALUES ('8943678443', '2020-02-13', 'ΚΑΡΔΙΟΛΟΓΙΚΗ', 'ΚΑΡΔΙΟΛΟΓΙΚΗ', '3000', '3001', 'Με χμι χμι χμι', 3);
