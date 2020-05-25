USE iaso_hospital_db_v08;

INSERT INTO hospital (afm) VALUES ('0123456789');
INSERT INTO hospital (afm, name) VALUES ('1234567890', 'Γ.Ν. ΑΘΗΝΩΝ ΓΕΝΝΗΜΑΤΑΣ');
INSERT INTO hospital (afm, name, first_street_name, first_street_number, primary_phone_number, email_address) VALUES ('2345678901', 'Γ.Ν. ΠΑΤΡΩΝ', 'ΚΑΛΑΒΡΥΤΩΝ', 37, '2613601000', 'gryppoliti@agandreashosp.gr');
	
INSERT INTO clinic (name, hospital_afm, vacant_beds) VALUES ('ΜΕΘ', '0123456789', 1);
INSERT INTO clinic (name, hospital_afm, vacant_beds) VALUES ('ΑΙΜΑΤΟΛΟΓΙΚΗ ΚΛΙΝΙΚΗ', '0123456789', 0);
INSERT INTO clinic (name, hospital_afm, vacant_beds) VALUES ('ΜΕΘ', '1234567890', 1);
INSERT INTO clinic (name, hospital_afm, vacant_beds) VALUES ('Α ΠΑΘΟΛΟΓΙΚΗ', '1234567890', 2);
INSERT INTO clinic (name, hospital_afm, vacant_beds) VALUES ('Β ΠΑΘΟΛΟΓΙΚΗ', '1234567890', 2);
INSERT INTO clinic (name, hospital_afm, vacant_beds) VALUES ('ΜΕΘ', '2345678901', 2);
INSERT INTO clinic (name, hospital_afm, vacant_beds) VALUES ('ΑΙΜΑΤΟΛΟΓΙΚΗ ΚΛΙΝΙΚΗ', '2345678901', 1);
INSERT INTO clinic (name, hospital_afm, vacant_beds) VALUES ('ΧΕΙΡΟΥΡΓΙΚΗ', '2345678901', 0);
INSERT INTO clinic (name, hospital_afm, vacant_beds) VALUES ('ΟΡΘΟΠΑΙΔΙΚΗ', '2345678901', 0);

INSERT INTO patient (amka) VALUES ('88374920');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('86727365', '27273664', 'ΑΝΔΡΕΑΣ', 'ΚΑΡΑΤΖΑΣ', NOW(), 'GR', 1, 'ΓΕΝ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('23456763', '57348335', 'ΠΑΝΑΓΙΩΤΗΣ', 'ΤΣΑΚΑΣ', NOW(), 'GR', 1, 'ΕΟΠΥΥ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('35723453', '75345634', 'ΜΑΚΗΣ', 'ΚΟΤΣΑΜΠΑΣΗΣ', NOW(), 'GR', 1, 'ΕΟΠΥΥ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('38294679', '25236633', 'ΝΙΚΟΣ', 'ΜΠΑΚΑΛΗΣ', NOW(), 'GR', 1, 'ΤΕΒΕ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('72364859', '94337923', 'ΑΝΝΑ', 'ΜΑΓΙΑΚΗ', NOW(), 'GR', 1, 'ΕΦΚΑ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('84563453', '23462484', 'ΔΙΟΝΥΣΗΣ', 'ΜΑΥΡΟΤΣΟΥΚΑΛΟΣ', NOW(), 'GR', 1, 'ΕΟΠΥΥ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('67765234', '94415732', 'ΤΑΚΗΣ', 'ΤΣΟΥΚΑΛΑΣ', NOW(), 'GR', 1, 'ΕΟΠΥΥ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('98734782', '13245983', 'ΣΤΕΦΑΝΟΣ', 'ΧΙΟΣ', NOW(), 'GR', 1, 'ΕΟΠΥΥ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('56857634', '86763487', 'ΚΩΣΤΗΣ', 'ΡΑΠΤΟΠΟΥΛΟΣ', NOW(), 'GR', 1, 'ΤΕΒΕ');
INSERT INTO patient (amka, afm, first_name, last_name, birth_date, nationality, gender, insurance) VALUES ('90876241', '67638432', 'ΣΩΤΗΡΗΣ', 'ΓΕΩΡΓΟΥΝΤΖΟΣ', NOW(), 'GR', 1, 'ΕΟΠΥΥ');

INSERT INTO patient_folder (patient_amka) VALUES ('88374920');
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('86727365', 'Του αρέσουν τα Ubuntu και για έναν περίεργο λόγο γράφει τα πάντα με LaTeX', 'Microsoft', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 1, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('23456763', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 'LaTeX και Linux', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 1, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('35723453', 'Μπύρες, Συνεργείο, Τίγρεις', 'Εργασία και δουλειά γενικότερα', 'Allien x234', 5, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('38294679', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 'CEID', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 2, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('72364859', 'Τίποτα, είναι ο πιο καλοσυνάτος άνθρωπος που έχω γνωρίσει', 'Τίποτα', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 2, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('84563453', 'Έχει ένα παλιοκαναπέ', 'Βάζελους', 'ΔΕ ΞΕΡΩ ΔΕΝ ΑΠΑΝΤΩ', 2, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, patient_surgeries, blood_type, HBV, HBC) VALUES ('67765234', 'Ολυμπιακός', 'Βάζελους', 'Άντε γεια', 1, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, blood_type, HBV, HBC) VALUES ('98734782', 'Μακελιό', 'Πολιτικούς', 1, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, blood_type, HBV, HBC) VALUES ('56857634', 'Μέλι', 'Παπαγεωργόπουλος', 1, 2, 2);
INSERT INTO patient_folder (patient_amka, chronic_disease, patient_allergies, blood_type, HBV, HBC) VALUES ('90876241', 'Μάυρη θύελλα', 'Μπιστικέας', 1, 2, 2);

INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('56798024', '0123456789', 'ALATOLY', 'KARPOV', NOW(), 'pa$$word', 1);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('04272840', '0123456789', 'GARRY', 'KASPAROV', NOW(), 'pa$$w0rd', 2);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('37464012', '0123456789', 'BOBBY', 'FISCHER', NOW(), 'pA$$word', 3);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('79830825', '0123456789', 'MAGNUS', 'CARLSEN', NOW(), 'passw0rd', 4);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('64980190', '1234567890', 'JOSE', 'CAPABLANCA', NOW(), 'Password', 1);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('90987322', '1234567890', 'VISWANATHAN', 'ANAND', NOW(), 'password', 2);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('65273929', '1234567890', 'VLADIMIR', 'KRAMNIK', NOW(), 'PASSWORD', 3);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('64502343', '1234567890', 'PAUL', 'MORPHY', NOW(), 'PaSsWoRD', 4);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('28488905', '1234567890', 'MIKHAIL', 'TAL', NOW(), 'pAsSwOrD', 1);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('93724572', '2345678901', 'BORIS', 'SPASKY', NOW(), 'passWORD', 2);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('75403203', '2345678901', 'VESELIN', 'TOPALOV', NOW(), 'PASSword', 3);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('13284502', '2345678901', 'FABIANO', 'CARUANA', NOW(), 'PA$$word', 4);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('65748033', '2345678901', 'HIKARU', 'NAKAMURA', NOW(), 'PA$$word', 1);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('94878429', '2345678901', 'SERGEY', 'KARJAKIN', NOW(), 'passW0rd', 2);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('47938047', '2345678901', 'LEVON', 'ARONIAN', NOW(), 'p@ssword', 3);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('29589333', '2345678901', 'DING', 'LIREN', NOW(), 'p@$$word', 4);
INSERT INTO user (user_name, hospital_afm, first_name, last_name, birth_date, password, specification) VALUES ('29805303', '2345678901', 'ANISH', 'GIRI', NOW(), 'pa$$w0RD', 1);

INSERT INTO doctor (user_name, sector, clinic) VALUES ('56798024', 'ΟΔΟΝΤΙΑΤΡΙΚΗ', 'ΜΕΘ');
INSERT INTO doctor (user_name, sector, clinic) VALUES ('64980190', 'ΚΑΡΔΙΟΧΕΙΡΟΥΡΓΙΚΗ', 'ΜΕΘ');
INSERT INTO doctor (user_name, sector, clinic) VALUES ('28488905', 'ΠΑΘΟΛΟΓΙΑ', 'Α ΠΑΘΟΛΟΓΙΚΗ');
INSERT INTO doctor (user_name, sector, clinic) VALUES ('65748033', 'ΟΦΘΑΛΜΟΛΟΓΙΑ', 'ΑΙΜΑΤΟΛΟΓΙΚΗ ΚΛΙΝΙΚΗ');
INSERT INTO doctor (user_name, sector, clinic) VALUES ('29805303', 'ΟΡΘΟΠΑΙΔΙΚΟΣ', 'ΟΡΘΟΠΑΙΔΙΚΗ');

INSERT INTO patient_transfer_office (number, hospital_afm) VALUES ('67768433', '0123456789');
INSERT INTO patient_transfer_office (number, hospital_afm) VALUES ('27867546', '1234567890');
INSERT INTO patient_transfer_office (number, hospital_afm) VALUES ('23457943', '2345678901');
INSERT INTO patient_transfer_office (number, hospital_afm) VALUES ('67887652', '2345678901');

INSERT INTO transfer_office_agent (user_name, office_number) VALUES ('79830825', '67768433');
INSERT INTO transfer_office_agent (user_name, office_number) VALUES ('64502343', '27867546');
INSERT INTO transfer_office_agent (user_name, office_number) VALUES ('13284502', '23457943');
INSERT INTO transfer_office_agent (user_name, office_number) VALUES ('29589333', '67887652');

INSERT INTO lab (name, hospital_afm) VALUES ('ΑΞΟΝΙΚΗ', '0123456789');
INSERT INTO lab (name, hospital_afm) VALUES ('ΜΑΓΝΗΤΙΚΟΣ ΣΥΝΤΟΝΙΣΜΟΣ', '1234567890');
INSERT INTO lab (name, hospital_afm) VALUES ('ΥΠΕΡΗΧΟΙ', '1234567890');
INSERT INTO lab (name, hospital_afm) VALUES ('ΜΑΣΤΟΓΡΑΦΙΑ', '1234567890');
INSERT INTO lab (name, hospital_afm) VALUES ('ΑΙΜΑΤΟΛΟΓΙΚΟ', '2345678901');
INSERT INTO lab (name, hospital_afm) VALUES ('ΤΟΞΙΚΟΛΟΓΙΚΟ', '2345678901');

INSERT INTO lab_agent (user_name, lab_name) VALUES ('04272840', 'ΑΞΟΝΙΚΗ');
INSERT INTO lab_agent (user_name, lab_name) VALUES ('90987322', 'ΥΠΕΡΗΧΟΙ');
INSERT INTO lab_agent (user_name, lab_name) VALUES ('93724572', 'ΑΙΜΑΤΟΛΟΓΙΚΟ');
INSERT INTO lab_agent (user_name, lab_name) VALUES ('94878429', 'ΑΙΜΑΤΟΛΟΓΙΚΟ');

INSERT INTO clinic_agent (user_name, clinic_name) VALUES ('37464012', 'ΜΕΘ');
INSERT INTO clinic_agent (user_name, clinic_name) VALUES ('65273929', 'Α ΠΑΘΟΛΟΓΙΚΗ');
INSERT INTO clinic_agent (user_name, clinic_name) VALUES ('75403203', 'ΑΙΜΑΤΟΛΟΓΙΚΗ ΚΛΙΝΙΚΗ');
INSERT INTO clinic_agent (user_name, clinic_name) VALUES ('47938047', 'ΑΙΜΑΤΟΛΟΓΙΚΗ ΚΛΙΝΙΚΗ');

INSERT INTO clinic_agent_post (post_id, user_name, created_at, post_text) VALUES ('67896534565', '37464012', NOW(), 'Μη ξεχάσετε να κλείσετε το θερμοσίφωνα');
INSERT INTO clinic_agent_post (post_id, user_name, created_at, title, post_text) VALUES ('65875657786', '65273929', NOW(), 'ΟΓΚΟΥΝΣΟΤΟ', 'ΠΩΣ ΓΚΕΝΕΝ ΑΤΟ;');
INSERT INTO clinic_agent_post (post_id, user_name, created_at, title, post_text) VALUES ('89346787455', '75403203', NOW(), 'CEID', 'Τα βιβλία τα έχετε πάρει;');
INSERT INTO clinic_agent_post (post_id, user_name, created_at, title, post_text) VALUES ('12356879867', '75403203', NOW(), 'CEID', 'Και δε μου λέτε για την εξεταστική είπαν κάτι;');
INSERT INTO clinic_agent_post (post_id, user_name, created_at, title, post_text) VALUES ('90876534766', '75403203', NOW(), 'CEID', 'Πάντως θα μπορούσαν να κάνουν σε κάποια μαθήματα τις εργασίας τους απαλλακτικές');
INSERT INTO clinic_agent_post (post_id, user_name, created_at, title, post_text) VALUES ('12398675535', '47938047', NOW(), 'CEID', 'Όχι');
INSERT INTO clinic_agent_post (post_id, user_name, created_at, title, post_text) VALUES ('89765467787', '47938047', NOW(), 'CEID', 'Ούτε κι αυτοί ξέρουν τι είπαν');
INSERT INTO clinic_agent_post (post_id, user_name, created_at, title, post_text) VALUES ('24354678987', '47938047', NOW(), 'CEID', 'Πόρε φίλε τι θες κι εσύ τώρα ... Πήγαινε για καφέ έξω και άστο το τμήμα στην τύχη του. Με αυτά και με αυτά, θα πάθεις καμιά κρίση άγχους και μετά θα πρέπει να έρθω να δουλέψω.');

INSERT INTO patient_file (patient_amka, file_id, hospital, doctor) VALUES ('88374920', '5627092159', '0123456789', '56798024');
INSERT INTO patient_file (patient_amka, file_id, hospital, doctor) VALUES ('86727365', '2354692304', '0123456789', '56798024');
INSERT INTO patient_file (patient_amka, file_id, hospital, doctor, diagnosis, treatment, lab_tests) VALUES ('86727365', '2346234633', '0123456789', '56798024', 'COVID-1', 'ΘΑ ΠΕΘΑΝΕΤΕ', 'ΚΛΑΨΤΕ ΤΟΝ');
INSERT INTO patient_file (patient_amka, file_id, hospital, doctor) VALUES ('86727365', '6787655458', '0123456789', '56798024');
INSERT INTO patient_file (patient_amka, file_id, hospital, doctor) VALUES ('86727365', '4360564468', '0123456789', '56798024');
INSERT INTO patient_file (patient_amka, file_id, hospital, doctor) VALUES ('35723453', '5875645345', '2345678901', '29805303');
INSERT INTO patient_file (patient_amka, file_id, hospital, doctor, diagnosis, treatment, lab_tests) VALUES ('35723453', '8943678443', '2345678901', '29805303', 'Μπυροκοιλιά', 'Συνεργείο ο Μάκης και οι Παίδαροι', '99% Ολυμπιακός 1% Βάζελος');
INSERT INTO patient_file (patient_amka, file_id, hospital, doctor) VALUES ('35723453', '0964352346', '2345678901', '29805303');
INSERT INTO patient_file (patient_amka, file_id, hospital, doctor) VALUES ('35723453', '2596543456', '2345678901', '29805303');

INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('7374', 'ΜΕΘ', '0123456789');
INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('2733', 'ΜΕΘ', '0123456789');
INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('1732', 'ΜΕΘ', '1234567890');
INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('9876', 'Α ΠΑΘΟΛΟΓΙΚΗ', '1234567890');
INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('4532', 'Α ΠΑΘΟΛΟΓΙΚΗ', '1234567890');
INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('7896', 'Α ΠΑΘΟΛΟΓΙΚΗ', '1234567890');
INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('4356', 'ΑΙΜΑΤΟΛΟΓΙΚΗ ΚΛΙΝΙΚΗ', '2345678901');
INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('7234', 'ΧΕΙΡΟΥΡΓΙΚΗ', '2345678901');
INSERT INTO chamber (id, clinic_name, clinic_hospital) VALUES ('1964', 'ΟΡΘΟΠΑΙΔΙΚΗ', '2345678901');

INSERT INTO bed (number, chamber_id, is_free) VALUES ('3423', '7374', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('2345', '7374', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('6735', '7374', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('2546', '2733', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('5325', '2733', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('7098', '2733', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('7652', '1732', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('3456', '1732', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('7880', '1732', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('7654', '9876', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('3253', '9876', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('6760', '9876', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('6545', '4532', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('7868', '4532', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('5746', '4532', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('6543', '7896', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('7869', '7896', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('5747', '7896', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('5263', '4356', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('7569', '4356', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('7867', '4356', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('5643', '4356', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('5123', '4356', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('4546', '4356', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('6757', '4356', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('4524', '4356', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('6708', '4356', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('0987', '4356', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('6544', '4356', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('2346', '4356', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('4656', '4356', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('4536', '4356', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('5876', '4356', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('3520', '4356', TRUE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('4564', '7234', FALSE);
INSERT INTO bed (number, chamber_id, is_free) VALUES ('1256', '7234', TRUE);

INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, patient_chamber, patient_bed, admission_text, stage) VALUES ('5627092159', NOW(), 'ΜΕΘ', 'ΜΕΘ', '7374', '3423', 'Καλησπέρα σας', 2);
INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, patient_chamber, patient_bed, admission_text, stage) VALUES ('2354692304', NOW(), 'Α ΠΑΘΟΛΟΓΙΚΗ', 'ΜΕΘ', '1732', '7652', 'Καλώς ήρθατε', 1);
INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, patient_chamber, patient_bed, admission_text, stage) VALUES ('2346234633', NOW(), 'ΑΙΜΑΤΟΛΟΓΙΚΗ ΚΛΙΝΙΚΗ', 'ΑΙΜΑΤΟΛΟΓΙΚΗ ΚΛΙΝΙΚΗ', '4356', '5263', 'Χρόνια πολλά', 3);
INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, patient_chamber, patient_bed, admission_text, stage) VALUES ('6787655458', NOW(), 'ΧΕΙΡΟΥΡΓΙΚΗ', 'ΧΕΙΡΟΥΡΓΙΚΗ', '7234', '4564', 'Να ευχαριστήσω', 3);
INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, patient_chamber, patient_bed, admission_text, stage) VALUES ('4360564468', NOW(), 'ΧΕΙΡΟΥΡΓΙΚΗ', 'ΧΕΙΡΟΥΡΓΙΚΗ', '7234', '4564', 'Τον πρόεδρο του συλλόγου', 3);
INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, patient_chamber, patient_bed, admission_text, stage) VALUES ('5875645345', NOW(), 'ΧΕΙΡΟΥΡΓΙΚΗ', 'ΧΕΙΡΟΥΡΓΙΚΗ', '7234', '4564', 'Τον πρόεδρο του συλλόγου', 3);
INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, patient_chamber, patient_bed, admission_text, stage) VALUES ('8943678443', NOW(), 'ΧΕΙΡΟΥΡΓΙΚΗ', 'ΧΕΙΡΟΥΡΓΙΚΗ', '7234', '4564', 'Με χμι χμι χμι', 3);
INSERT INTO admission_ticket (ticket_id, created_at, admission_clinic, host_clinic, patient_chamber, patient_bed, admission_text, stage) VALUES ('0964352346', NOW(), 'ΧΕΙΡΟΥΡΓΙΚΗ', 'ΧΕΙΡΟΥΡΓΙΚΗ', '7234', '4564', 'Σ αγαπώ πολύ πολύ', 2);

INSERT INTO discharge_note (note_id, created_at, discharge_text, admission_clinic, stage) VALUES ('5627092159', NOW(), 'Και δεν σου κάνω', 'ΜΕΘ', 1);
INSERT INTO discharge_note (note_id, created_at, discharge_text, admission_clinic, stage) VALUES ('2354692304', NOW(), 'τον άγιο', 'Α ΠΑΘΟΛΟΓΙΚΗ', 1);
INSERT INTO discharge_note (note_id, created_at, discharge_text, admission_clinic, stage) VALUES ('2346234633', NOW(), 'αχ αμάρτησα', 'ΑΙΜΑΤΟΛΟΓΙΚΗ ΚΛΙΝΙΚΗ', 1);
INSERT INTO discharge_note (note_id, created_at, discharge_text, admission_clinic, stage) VALUES ('6787655458', NOW(), 'για μια νύχτα', 'ΧΕΙΡΟΥΡΓΙΚΗ', 1);
INSERT INTO discharge_note (note_id, created_at, discharge_text, admission_clinic, stage) VALUES ('4360564468', NOW(), 'παράνομα', 'ΧΕΙΡΟΥΡΓΙΚΗ', 1);
INSERT INTO discharge_note (note_id, created_at, discharge_text, admission_clinic, stage) VALUES ('5875645345', NOW(), 'αχ ξεστράτησα', 'ΧΕΙΡΟΥΡΓΙΚΗ', 1);
INSERT INTO discharge_note (note_id, created_at, discharge_text, admission_clinic, stage) VALUES ('8943678443', NOW(), 'Γιώργος', 'ΧΕΙΡΟΥΡΓΙΚΗ', 1);
INSERT INTO discharge_note (note_id, created_at, discharge_text, admission_clinic, stage) VALUES ('0964352346', NOW(), 'Τσαλίκης', 'ΧΕΙΡΟΥΡΓΙΚΗ', 2);

INSERT INTO billing (billing_id, created_at, price) VALUES ('5627092159', NOW(), 123.21);
INSERT INTO billing (billing_id, created_at, price) VALUES ('2354692304', NOW(), 6521.23);
INSERT INTO billing (billing_id, created_at, price) VALUES ('2346234633', NOW(), 874.28);
INSERT INTO billing (billing_id, created_at, price) VALUES ('6787655458', NOW(), 9865.34);
INSERT INTO billing (billing_id, created_at, price) VALUES ('4360564468', NOW(), 145.34);
INSERT INTO billing (billing_id, created_at, price) VALUES ('5875645345', NOW(), 876.34);
INSERT INTO billing (billing_id, created_at, price) VALUES ('8943678443', NOW(), 147.98);

INSERT INTO transfer (id, authorised_by, patient_amka, stage) VALUES (NOW(), '56798024', '88374920', 1);
INSERT INTO transfer (id, authorised_by, patient_amka, source_clinic, hospital_afm, destination_clinic, stage) VALUES (NOW(), '64980190', '86727365', 'ΜΕΘ', '1234567890', 'Α ΠΑΘΟΛΟΓΙΚΗ', 2);
INSERT INTO transfer (id, authorised_by, patient_amka, source_clinic, hospital_afm, destination_clinic, stage) VALUES (NOW(), '28488905', '67765234', 'ΧΕΙΡΟΥΡΓΙΚΗ', '2345678901', 'ΑΙΜΑΤΟΛΟΓΙΚΗ ΚΛΙΝΙΚΗ', 1);
INSERT INTO transfer (id, authorised_by, patient_amka, source_clinic, hospital_afm, destination_clinic, stage) VALUES (NOW(), '65748033', '90876241', 'ΟΡΘΟΠΑΙΔΙΚΗ', '2345678901', 'ΑΙΜΑΤΟΛΟΓΙΚΗ ΚΛΙΝΙΚΗ', 1);
