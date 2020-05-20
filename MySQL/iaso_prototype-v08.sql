DROP DATABASE IF EXISTS iaso_hospital_db_v08;
CREATE DATABASE IF NOT EXISTS iaso_hospital_db_v08 CHARACTER SET utf8mb4;
USE iaso_hospital_db_v08;

CREATE TABLE IF NOT EXISTS hospital (
	afm VARCHAR(20) PRIMARY KEY,
    name VARCHAR(30),
	first_street_name VARCHAR(30),
    first_street_number VARCHAR(4),
    primary_phone_number VARCHAR(10),
    emergency_phone_number VARCHAR(10),
    email_address VARCHAR(30),
    second_street_name VARCHAR(30),
    second_street_number VARCHAR(4)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS clinic (
	name VARCHAR(30) PRIMARY KEY,
    hospital_afm VARCHAR(20) NOT NULL,
    CONSTRAINT hospital_clinic FOREIGN KEY (hospital_afm) REFERENCES hospital(afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS patient (
	amka VARCHAR(20) PRIMARY KEY,
	afm VARCHAR(20),
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    birth_date DATETIME,
    nationality VARCHAR(2),
    religion VARCHAR(20),
    gender ENUM('Male', 'Female', 'Other'),
    insurance VARCHAR(20),
    father_first_name VARCHAR(20),
    father_last_name VARCHAR(20),
    mother_first_name VARCHAR(20),
    mother_last_name VARCHAR(20),
    first_street_name VARCHAR(30),
    first_street_number VARCHAR(4),
    primary_phone_number VARCHAR(10),
    emergency_phone_number VARCHAR(10),
    email_address VARCHAR(30),
    second_street_name VARCHAR(30),
    second_street_number VARCHAR(4)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS patient_folder (
	patient_amka VARCHAR(20) PRIMARY KEY,
    chronic_disease TEXT,
    patient_allergies TEXT,
    patient_surgeries TEXT,
    blood_type ENUM('A+','A-','B+','B-','O+','O-','AB+','AB-'),
    HBV ENUM ('YES', 'NO'),
    HBC ENUM ('YES', 'NO'),
    CONSTRAINT patient_folder_amka FOREIGN KEY (patient_amka) REFERENCES patient(amka) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS patient_file (
	patient_amka VARCHAR(20) NOT NULL,
	file_id VARCHAR(20) PRIMARY KEY,
    hospital VARCHAR(20) NOT NULL,
	# created_at TIMESTAMP DEFAULT NOW() NOT NULL,
    diagnosis TEXT,
    treatment TEXT,
    lab_tests TEXT,
    CONSTRAINT patient_file_amka FOREIGN KEY (patient_amka) REFERENCES patient(amka) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT patient_file_hospital FOREIGN KEY (hospital) REFERENCES hospital(afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS chamber (
    id VARCHAR(4) PRIMARY KEY,
    clinic_name VARCHAR(30) NOT NULL,
    CONSTRAINT clinic_chamber FOREIGN KEY (clinic_name) REFERENCES clinic(name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS bed (
	number VARCHAR(4) PRIMARY KEY,
    chamber_id VARCHAR(4) NOT NULL,
    is_free BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT chamber_bed FOREIGN KEY (chamber_id) REFERENCES chamber(id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS admission_ticket (
    ticket_id VARCHAR(20) PRIMARY KEY,
    created_at DATETIME DEFAULT NOW() NOT NULL,
    admission_clinic VARCHAR(30) NOT NULL,
    host_clinic VARCHAR(30) NOT NULL,
    patient_chamber VARCHAR(4) NOT NULL,
    patient_bed VARCHAR(4) NOT NULL,
    admission_text TEXT,
    stage ENUM("CREATED", "SENT", "APPROVED") NOT NULL DEFAULT "CREATED",
    CONSTRAINT admission_ticket_file FOREIGN KEY (ticket_id) REFERENCES patient_file(file_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT ticket_admission_clinic FOREIGN KEY (admission_clinic) REFERENCES clinic(name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT ticket_host_clinic FOREIGN KEY (host_clinic) REFERENCES clinic(name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT ticket_chamber FOREIGN KEY (patient_chamber) REFERENCES chamber(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT ticket_bed FOREIGN KEY (patient_bed) REFERENCES bed(number) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS discharge_note (
	note_id VARCHAR(20) PRIMARY KEY,
    created_at DATETIME DEFAULT NOW() NOT NULL,
	discharge_text TEXT,
    admission_clinic VARCHAR(30) NOT NULL,
    stage ENUM('SENT','APPROVED') NOT NULL DEFAULT 'SENT',
    CONSTRAINT discharge_note_file FOREIGN KEY (note_id) REFERENCES patient_file(file_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT note_admission_clinic FOREIGN KEY (admission_clinic) REFERENCES clinic(name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS billing (
    billing_id VARCHAR(20) PRIMARY KEY,
    created_at DATETIME DEFAULT NOW() NOT NULL,
	price FLOAT,
    CONSTRAINT billing_file FOREIGN KEY (billing_id) REFERENCES patient_file(file_id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS user (
	user_name VARCHAR(20) PRIMARY KEY,
    hospital_afm VARCHAR(20) NOT NULL,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    birth_date DATETIME,
    password VARCHAR(20) NOT NULL,
    specification ENUM('Doctor','Lab_Agent','Clinic_Agent','Transfer_Office_Agent') NOT NULL,
    CONSTRAINT hospital_user FOREIGN KEY (hospital_afm) REFERENCES hospital(afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

#CREATE TABLE IF NOT EXISTS patient_admission_request (
#	created_at TIMESTAMP DEFAULT NOW() NOT NULL,
#    patient_id BIGINT UNSIGNED NOT NULL,
#    authorized_by VARCHAR(20) NOT NULL,
#    request_stage ENUM('SENT', 'RECEIVED', 'ACKNOWLEDGED', 'COMPLETE') NOT NULL DEFAULT 'SENT',
#    chamber TINYINT,
#    bed TINYINT,
#    PRIMARY KEY (patient_id, created_at),
#    CONSTRAINT patient_admission_id FOREIGN KEY (patient_id) REFERENCES patient_folder(patient_id) ON UPDATE CASCADE ON DELETE CASCADE,
#    CONSTRAINT admission_request_author FOREIGN KEY (authorized_by) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE
#)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS doctor (
	user_name VARCHAR(20) PRIMARY KEY,
    sector VARCHAR(20) NOT NULL,
    clinic VARCHAR(30) NOT NULL,
    CONSTRAINT user_doctor FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT doctor_clinic FOREIGN KEY (clinic) REFERENCES clinic(name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

#CREATE TABLE IF NOT EXISTS doctor_profile (
#	user_name VARCHAR(20) NOT NULL,
#    degrees VARCHAR(20) NOT NULL,
#    PRIMARY KEY (user_name, degrees),
#	CONSTRAINT user_name_profile FOREIGN KEY (user_name) REFERENCES doctor(user_name) ON UPDATE CASCADE ON DELETE CASCADE
#)ENGINE=INNODB;

#CREATE TABLE IF NOT EXISTS doctor_patient_association (
#	doctor_name VARCHAR(20) NOT NULL,
#	patient_id BIGINT UNSIGNED NOT NULL,
#    created_at TIMESTAMP NOT NULL,
#	PRIMARY KEY (patient_id, created_at, doctor_name),
#    INDEX (patient_id, created_at),
#    FOREIGN KEY (patient_id, created_at) REFERENCES patient_file(patient_id, created_at) ON UPDATE CASCADE ON DELETE CASCADE,
#    CONSTRAINT doctor_association FOREIGN KEY (doctor_name) REFERENCES doctor(user_name) ON UPDATE CASCADE ON DELETE CASCADE
#)ENGINE=INNODB;

#CREATE TABLE IF NOT EXISTS doctor_hours (
#	user_name  VARCHAR(20) NOT NULL,
#    office_day ENUM('MON', 'TUE', 'WED', 'THU',' FRI', 'SAT', 'SUN') NOT NULL,
#	office_hours_start TIME NOT NULL,
#    office_hours_end TIME NOT NULL,
#    PRIMARY KEY (user_name, office_day, office_hours_start, office_hours_end),
#    CONSTRAINT doctor_name_hours FOREIGN KEY (user_name) REFERENCES doctor(user_name) ON UPDATE CASCADE ON DELETE CASCADE
#)ENGINE=INNODB;

#CREATE TABLE IF NOT EXISTS contact (
#	first_street_name VARCHAR(30) NOT NULL,
#    first_street_number SMALLINT NOT NULL,
#    primary_phone_number BIGINT UNSIGNED NOT NULL,
#    emergency_phone_number BIGINT UNSIGNED,
#    email_address VARCHAR(30),
#    second_street_name VARCHAR(30),
#    second_street_number SMALLINT UNSIGNED,
#    user_name VARCHAR(20),
#    PRIMARY KEY (first_street_name, first_street_number, primary_phone_number),
#	CONSTRAINT user_contact FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE
#)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS transfer(
	id DATETIME DEFAULT NOW() NOT NULL,
    authorised_by VARCHAR(20) NOT NULL,
	patient_amka VARCHAR(20) NOT NULL,
    source_clinic VARCHAR(30),
    destination_clinic VARCHAR(30),
    stage ENUM('SENT', 'APPROVED') NOT NULL DEFAULT 'SENT',
    PRIMARY KEY (id, patient_amka),
    CONSTRAINT user_doctor_transfer FOREIGN KEY (authorised_by) REFERENCES doctor(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT trasfer_patient FOREIGN KEY (patient_amka) REFERENCES patient(amka) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT source_clinic FOREIGN KEY (source_clinic) REFERENCES clinic(name) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT destination_clinic FOREIGN KEY (destination_clinic) REFERENCES clinic(name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS patient_transfer_office (
	number VARCHAR(10) PRIMARY KEY,
    hospital_afm VARCHAR(20) NOT NULL,
    CONSTRAINT hospital_office FOREIGN KEY (hospital_afm) REFERENCES hospital(afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS transfer_office_agent (
    user_name VARCHAR(20) PRIMARY KEY,
    office_number VARCHAR(10) NOT NULL,
    CONSTRAINT user_transfer FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT number_transfer FOREIGN KEY (office_number) REFERENCES patient_transfer_office(number) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS lab (
	name VARCHAR(20) PRIMARY KEY,
	hospital_afm VARCHAR(20) NOT NULL,
    CONSTRAINT hospital_lab FOREIGN KEY (hospital_afm) REFERENCES hospital(afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS lab_agent (
    user_name VARCHAR(20) PRIMARY KEY,
    lab_name VARCHAR(20) NOT NULL,
    CONSTRAINT user_lab FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT name_lab FOREIGN KEY (lab_name) REFERENCES lab(name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

#CREATE TABLE IF NOT EXISTS test_request (
#	test_request_id INT PRIMARY KEY,
#    patient_id BIGINT UNSIGNED NOT NULL,
#    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
#    user_name VARCHAR(20),
#    CONSTRAINT test_requested_by FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
#    test_stage ENUM('SENT', 'RECEIVED', 'ACKNOWLEDGED', 'PENDING RESULTS', 'TEST COMPLETE') NOT NULL DEFAULT 'SENT',
#    CONSTRAINT patient_test_request FOREIGN KEY (patient_id) REFERENCES patient_folder(patient_id) ON UPDATE CASCADE ON DELETE CASCADE
#)ENGINE=INNODB;

#CREATE TABLE IF NOT EXISTS test (
#	test_request_id INT PRIMARY KEY,
#	patient_id BIGINT UNSIGNED NOT NULL,
#    test_name ENUM('BLOOD TEST','LIVER ENZYMS','LIPID PROFILE','METABOLOMIC PROFILE','DRUG LEVELS',
#    'IMMUNOGLOBULINS','HEPATITIS ANALYSIS','VIRUS LABS','THYROID FUNCTION TESTS',
#    'CANCER MARKERS','URINALYSIS','URINE CULTURE','CT','MRI','fMRI','PET','PET-SCAN','EEG','MEG','X') NOT NULL UNIQUE,
#    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
#    root_test_name ENUM('ALT','AST','ALP','GGT','LD','PT','Albumin','Total protein','Bilrubin',
#    'TC','HDL-C','LDL-C','TGs','VLDL','ApoA1-ApoB','Lp(a)','MH(NON)HDL-C','HOMA-IR','TC/HDL-C','ApoB/ApoA1',
#    'Adiponectin','BMI','C-Reaxtive Protein','Creatinine','Cystasin','Glucose','Glycomark','Insulin','Leptin(ratio)','Leptin',
#    'Amikacin','Aminophylline','Amitriptyline','Carbamazepine','Chloramphenicol','Desipramine','Digoxin','Disopyramide','Ethosuximide','Flecainide',
#    'Gentamicin','Imipramine','Kanamycin','Lidocaine','Lithium','Methotrexate','Nortriptyline','Phenobarbital','Phenytoin','Primidone',
#    'Procainamide','Propranolol','Quinidine','Salicylate','Theophylline','Tobramycin','Valproic acid',
#    'IgA','IgG','IgE','IgD',
#    'tsh','T4','T3','FREE T3','REVERSE T3',
#    'AFP','B2M','Beta-hGG','CA 15-3','CA 14-9','Calcitonin','CEA','CgA','HE4','NSE','Nuclear matrix protein 22','Thyroglobulin') UNIQUE,
#    test_results TEXT,
#    CONSTRAINT patient_lab_test FOREIGN KEY (patient_id) REFERENCES test_request(patient_id) ON UPDATE CASCADE ON DELETE CASCADE,
#    CONSTRAINT patient_lab_test_id FOREIGN KEY (test_request_id) REFERENCES test_request(test_request_id) ON UPDATE CASCADE ON DELETE CASCADE,
#    CONSTRAINT test_predecessor FOREIGN KEY (root_test_name) REFERENCES test(test_name) ON UPDATE CASCADE ON DELETE CASCADE
#)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS clinic_agent (
    user_name VARCHAR(20) PRIMARY KEY,
    clinic_name VARCHAR(30) NOT NULL,
    CONSTRAINT clinic_nurse FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT agent_clinic FOREIGN KEY (clinic_name) REFERENCES clinic(name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;