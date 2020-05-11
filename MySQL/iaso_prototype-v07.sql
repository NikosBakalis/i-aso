CREATE DATABASE IF NOT EXISTS iaso_hospital_db_v07 CHARACTER SET utf8mb4;
USE iaso_hospital_db_v07;

CREATE TABLE IF NOT EXISTS hospital (	
	hospital_afm BIGINT UNSIGNED PRIMARY KEY,
    hospital_name VARCHAR(30) NOT NULL,
	first_street_name VARCHAR(30) NOT NULL,
    first_street_number SMALLINT NOT NULL,
    primary_phone_number BIGINT UNSIGNED NOT NULL,
    emergency_phone_number BIGINT UNSIGNED,
    email_address VARCHAR(30),
    second_street_name VARCHAR(30),
    second_street_number SMALLINT UNSIGNED
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS patient_folder (
	patient_id BIGINT UNSIGNED PRIMARY KEY,
	patient_first_name VARCHAR(20) NOT NULL,
    patient_last_name VARCHAR(20) NOT NULL,
    patient_birth_date DATETIME NOT NULL,
    patient_nationality VARCHAR(2) NOT NULL,
    patient_religion VARCHAR(20),
    patient_gender TINYINT,
    patient_insurance VARCHAR(20),
    patient_afm BIGINT UNSIGNED,
    chronic_disease TEXT,
    patient_allergies TEXT,
    patient_surgeries TEXT,
    patient_eopy_webpage TEXT,
    patient_father_first_name VARCHAR(20),
    patient_father_last_name VARCHAR(20),
    patient_mother_first_name VARCHAR(20),
    patient_mother_last_name VARCHAR(20),
    first_street_name VARCHAR(30) NOT NULL,
    first_street_number SMALLINT NOT NULL,
    primary_phone_number BIGINT UNSIGNED NOT NULL,
    emergency_phone_number BIGINT UNSIGNED,
    email_address VARCHAR(30),
    second_street_name VARCHAR(30),
    second_street_number SMALLINT UNSIGNED,
    patient_relative BIGINT UNSIGNED,
    surgery_indicator BOOLEAN,
    blood_type ENUM('A+','A-','B+','B-','O+','O-','AB+','AB-'),
    HBV ENUM ('YES', 'NO'),
    HBC ENUM ('YES', 'NO'),
    CONSTRAINT relatives FOREIGN KEY (patient_relative) REFERENCES patient_folder(patient_id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS patient_file (
	patient_id BIGINT UNSIGNED NOT NULL,
    patient_hospital BIGINT UNSIGNED,
    created_at TIMESTAMP DEFAULT NOW() NOT NULL,
    diagnosis TEXT,
    treatment TEXT,
    drugs TINYTEXT,
    PRIMARY KEY (patient_id, created_at),
    CONSTRAINT patient_history FOREIGN KEY (patient_id) REFERENCES patient_folder(patient_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT hospital_patient FOREIGN KEY (patient_hospital) REFERENCES hospital(hospital_afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS admission_ticket (
    patient_id BIGINT UNSIGNED NOT NULL,
    created_at TIMESTAMP NOT NULL,
    patient_bed TINYINT NOT NULL,
    patient_chamber TINYINT NOT NULL,
    patient_clinic VARCHAR(30) NOT NULL,
    admission_clinic VARCHAR(30) NOT NULL,
    cause TEXT NOT NULL,
    PRIMARY KEY (patient_id, created_at),
    INDEX (patient_id, created_at),
    FOREIGN KEY (patient_id, created_at) REFERENCES patient_file(patient_id, created_at) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS discharge_note (
    patient_id BIGINT UNSIGNED NOT NULL,
    created_at TIMESTAMP DEFAULT NOW() NOT NULL,
	discharge_ticket_text TEXT NOT NULL,
    admission_clinic VARCHAR(30) NOT NULL,
    stage ENUM('SENT','APPROVED') NOT NULL DEFAULT 'SENT',
    PRIMARY KEY (patient_id, created_at),
    INDEX (patient_id, created_at),
    FOREIGN KEY (patient_id, created_at) REFERENCES patient_file(patient_id, created_at) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS discharge_billing (
    patient_id BIGINT UNSIGNED NOT NULL,
    created_at TIMESTAMP DEFAULT NOW() NOT NULL,
    billing_id BIGINT UNSIGNED NOT NULL,
	price INT NOT NULL,
    PRIMARY KEY (patient_id, created_at),
    INDEX (patient_id, created_at),
    FOREIGN KEY (patient_id, created_at) REFERENCES discharge_note(patient_id, created_at) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS user (
	user_name VARCHAR(20) PRIMARY KEY,
    hospital_afm BIGINT UNSIGNED NOT NULL,
    user_first_name VARCHAR(20) NOT NULL,
    user_last_name VARCHAR(20) NOT NULL,
    user_birth_date DATETIME NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    specification ENUM('Doctor','Lab_Agent','Clinic_Agent','Transfer_Office_Agent', 'Admin') NOT NULL,
    CONSTRAINT hospital_user FOREIGN KEY (hospital_afm) REFERENCES hospital(hospital_afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS patient_admission_request (
	created_at TIMESTAMP DEFAULT NOW() NOT NULL,
    patient_id BIGINT UNSIGNED NOT NULL,
    authorized_by VARCHAR(20) NOT NULL,
    request_stage ENUM('SENT', 'RECEIVED', 'ACKNOWLEDGED', 'COMPLETE') NOT NULL DEFAULT 'SENT',
    chamber TINYINT,
    bed TINYINT,
    PRIMARY KEY (patient_id, created_at),
    CONSTRAINT patient_admission_id FOREIGN KEY (patient_id) REFERENCES patient_folder(patient_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT admission_request_author FOREIGN KEY (authorized_by) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS doctor (
	user_name VARCHAR(20) PRIMARY KEY,
    doctor_sector VARCHAR(20) NOT NULL,
    CONSTRAINT user_doctor FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS doctor_profile (
	user_name VARCHAR(20) NOT NULL,
    degrees VARCHAR(20) NOT NULL,
    PRIMARY KEY (user_name, degrees),
	CONSTRAINT user_name_profile FOREIGN KEY (user_name) REFERENCES doctor(user_name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS doctor_patient_association (
	doctor_name VARCHAR(20) NOT NULL,
	patient_id BIGINT UNSIGNED NOT NULL,
    created_at TIMESTAMP NOT NULL,
	PRIMARY KEY (patient_id, created_at, doctor_name),
    INDEX (patient_id, created_at),
    FOREIGN KEY (patient_id, created_at) REFERENCES patient_file(patient_id, created_at) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT doctor_association FOREIGN KEY (doctor_name) REFERENCES doctor(user_name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS doctor_hours (
	user_name  VARCHAR(20) NOT NULL,
    office_day ENUM('MON', 'TUE', 'WED', 'THU',' FRI', 'SAT', 'SUN') NOT NULL,
	office_hours_start TIME NOT NULL,
    office_hours_end TIME NOT NULL,
    PRIMARY KEY (user_name, office_day, office_hours_start, office_hours_end),
    CONSTRAINT doctor_name_hours FOREIGN KEY (user_name) REFERENCES doctor(user_name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS contact (
	first_street_name VARCHAR(30) NOT NULL,
    first_street_number SMALLINT NOT NULL,
    primary_phone_number BIGINT UNSIGNED NOT NULL,
    emergency_phone_number BIGINT UNSIGNED,
    email_address VARCHAR(30),
    second_street_name VARCHAR(30),
    second_street_number SMALLINT UNSIGNED,
    user_name VARCHAR(20),
    PRIMARY KEY (first_street_name, first_street_number, primary_phone_number),
	CONSTRAINT user_contact FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS clinic (
	clinic_name VARCHAR(30) NOT NULL,
    hospital_afm BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (clinic_name, hospital_afm),
    CONSTRAINT hospital_clinic FOREIGN KEY (hospital_afm) REFERENCES hospital(hospital_afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS transfer_request (
	transfer_id TIMESTAMP DEFAULT NOW() PRIMARY KEY,
    authorised_by VARCHAR(20) NOT NULL,
	patient_id BIGINT UNSIGNED NOT NULL,
    source_hospital BIGINT UNSIGNED NOT NULL,
    destination_hospital BIGINT UNSIGNED NOT NULL,
    source_clinic_name VARCHAR(30),
    destination_clinic_name VARCHAR(30),
    transfer_request_stage ENUM('SENT', 'RECEIVED', 'ACKNOWLEDGED', 'STARTING TRANSFER',' TRANSFER COMPLETE') NOT NULL DEFAULT 'SENT',
    transfer_schedule_start TIMESTAMP,
    CONSTRAINT present_hospital FOREIGN KEY (destination_hospital) REFERENCES hospital(hospital_afm) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT transfer_request_authority FOREIGN KEY (authorised_by) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT asset FOREIGN KEY (patient_id) REFERENCES patient_folder(patient_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT source_transfer_clinic FOREIGN KEY (source_clinic_name) REFERENCES clinic(clinic_name) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT destination_transfer_clinic FOREIGN KEY (destination_clinic_name) REFERENCES clinic(clinic_name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS patient_transfer_office (
	hospital_afm BIGINT UNSIGNED PRIMARY KEY,
    CONSTRAINT hospital_transfer FOREIGN KEY (hospital_afm) REFERENCES hospital(hospital_afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS transfer_office_agent (
    user_name VARCHAR(20) PRIMARY KEY,
    CONSTRAINT user_transfer FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS lab (
	hospital_afm BIGINT UNSIGNED NOT NULL,
    lab_name VARCHAR(20) NOT NULL,
    PRIMARY KEY(hospital_afm, lab_name),
    CONSTRAINT hospital_lab FOREIGN KEY (hospital_afm) REFERENCES hospital(hospital_afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS lab_agent (
    user_name VARCHAR(20) NOT NULL,
    lab_name VARCHAR(20) NOT NULL,
    hospital_afm BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY(user_name, lab_name, hospital_afm),
    INDEX (hospital_afm, lab_name),
    FOREIGN KEY (hospital_afm, lab_name) REFERENCES lab(hospital_afm, lab_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT user_lab FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS test_request (
	test_request_id INT PRIMARY KEY,
    patient_id BIGINT UNSIGNED NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    user_name VARCHAR(20),
    CONSTRAINT test_requested_by FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    test_stage ENUM('SENT', 'RECEIVED', 'ACKNOWLEDGED', 'PENDING RESULTS', 'TEST COMPLETE') NOT NULL DEFAULT 'SENT',
    CONSTRAINT patient_test_request FOREIGN KEY (patient_id) REFERENCES patient_folder(patient_id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS test (
	test_request_id INT PRIMARY KEY,
	patient_id BIGINT UNSIGNED NOT NULL,
    test_name ENUM('BLOOD TEST','LIVER ENZYMS','LIPID PROFILE','METABOLOMIC PROFILE','DRUG LEVELS',
    'IMMUNOGLOBULINS','HEPATITIS ANALYSIS','VIRUS LABS','THYROID FUNCTION TESTS',
    'CANCER MARKERS','URINALYSIS','URINE CULTURE','CT','MRI','fMRI','PET','PET-SCAN','EEG','MEG','X') NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    root_test_name ENUM('ALT','AST','ALP','GGT','LD','PT','Albumin','Total protein','Bilrubin',
    'TC','HDL-C','LDL-C','TGs','VLDL','ApoA1-ApoB','Lp(a)','MH(NON)HDL-C','HOMA-IR','TC/HDL-C','ApoB/ApoA1',
    'Adiponectin','BMI','C-Reaxtive Protein','Creatinine','Cystasin','Glucose','Glycomark','Insulin','Leptin(ratio)','Leptin',
    'Amikacin','Aminophylline','Amitriptyline','Carbamazepine','Chloramphenicol','Desipramine','Digoxin','Disopyramide','Ethosuximide','Flecainide',
    'Gentamicin','Imipramine','Kanamycin','Lidocaine','Lithium','Methotrexate','Nortriptyline','Phenobarbital','Phenytoin','Primidone',
    'Procainamide','Propranolol','Quinidine','Salicylate','Theophylline','Tobramycin','Valproic acid',
    'IgA','IgG','IgE','IgD',
    'tsh','T4','T3','FREE T3','REVERSE T3',
    'AFP','B2M','Beta-hGG','CA 15-3','CA 14-9','Calcitonin','CEA','CgA','HE4','NSE','Nuclear matrix protein 22','Thyroglobulin') UNIQUE,
    test_results TEXT,
    CONSTRAINT patient_lab_test FOREIGN KEY (patient_id) REFERENCES test_request(patient_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT patient_lab_test_id FOREIGN KEY (test_request_id) REFERENCES test_request(test_request_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT test_predecessor FOREIGN KEY (root_test_name) REFERENCES test(test_name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS chamber (	
    chamber_id TINYINT PRIMARY KEY,
    clinic_name VARCHAR(30) NOT NULL,
    CONSTRAINT clinic_chamber FOREIGN KEY (clinic_name) REFERENCES clinic(clinic_name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS bed (
	bed_number TINYINT PRIMARY KEY,
    chamber_id TINYINT NOT NULL,
    is_free BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT chamber_bed FOREIGN KEY (chamber_id) REFERENCES chamber(chamber_id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS clinic_agent (	
    user_name VARCHAR(20) PRIMARY KEY, 
    clinic_name VARCHAR(30) NOT NULL,
    CONSTRAINT clinic_nurse FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT agent_clinic FOREIGN KEY (clinic_name) REFERENCES clinic(clinic_name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;