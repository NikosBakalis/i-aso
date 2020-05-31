DROP DATABASE IF EXISTS iaso_hospital_db_v08;
CREATE DATABASE IF NOT EXISTS iaso_hospital_db_v08 CHARACTER SET utf8mb4;
USE iaso_hospital_db_v08;

CREATE TABLE IF NOT EXISTS hospital (
	afm VARCHAR(20) PRIMARY KEY,
    name VARCHAR(30),
	first_street_name VARCHAR(30),
    first_street_number VARCHAR(4),
    primary_phone_number VARCHAR(10),
    email_address VARCHAR(30),
    second_street_name VARCHAR(30),
    second_street_number VARCHAR(4)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS clinic (
	name VARCHAR(30) NOT NULL,
    hospital_afm VARCHAR(20) NOT NULL,
    vacant_beds INTEGER NOT NULL,
    PRIMARY KEY (name, hospital_afm),
    CONSTRAINT hospital_clinic FOREIGN KEY (hospital_afm) REFERENCES hospital(afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS patient (
	amka VARCHAR(20) PRIMARY KEY,
	afm VARCHAR(20),
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    birth_date DATE,
    nationality VARCHAR(2),
    gender ENUM('ΑΝΔΡΑΣ', 'ΓΥΝΑΙΚΑ', 'ΑΛΛΟ'),
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

CREATE TABLE IF NOT EXISTS chamber (
    id VARCHAR(4) PRIMARY KEY,
    clinic_name VARCHAR(30) NOT NULL,
    clinic_hospital VARCHAR(30) NOT NULL,
    INDEX (clinic_name, clinic_hospital),
    FOREIGN KEY (clinic_name, clinic_hospital) REFERENCES clinic(name, hospital_afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS bed (
	number VARCHAR(4) PRIMARY KEY,
    chamber_id VARCHAR(4) NOT NULL,
    is_free BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT chamber_bed FOREIGN KEY (chamber_id) REFERENCES chamber(id) ON UPDATE CASCADE ON DELETE CASCADE
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

CREATE TABLE IF NOT EXISTS doctor (
	user_name VARCHAR(20) PRIMARY KEY,
    sector VARCHAR(20) NOT NULL,
    clinic VARCHAR(30) NOT NULL,
    CONSTRAINT user_doctor FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT doctor_clinic FOREIGN KEY (clinic) REFERENCES clinic(name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS patient_file (
	patient_amka VARCHAR(20) NOT NULL,
	file_id VARCHAR(20) PRIMARY KEY,
    hospital VARCHAR(20) NOT NULL,
    doctor VARCHAR(20) NOT NULL,
    diagnosis TEXT,
    treatment TEXT,
    lab_tests TEXT,
    CONSTRAINT patient_file_doctor FOREIGN KEY (doctor) REFERENCES doctor(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT patient_file_amka FOREIGN KEY (patient_amka) REFERENCES patient(amka) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT patient_file_hospital FOREIGN KEY (hospital) REFERENCES hospital(afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS admission_ticket (
    ticket_id VARCHAR(20) PRIMARY KEY,
    created_at DATETIME DEFAULT NOW(),
    admission_clinic VARCHAR(30),
    host_clinic VARCHAR(30),
    patient_chamber VARCHAR(4),
    patient_bed VARCHAR(4),
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

CREATE TABLE IF NOT EXISTS transfer (
	id DATETIME DEFAULT NOW() NOT NULL,
    authorised_by VARCHAR(20) NOT NULL,
	patient_amka VARCHAR(20) NOT NULL,
    source_clinic VARCHAR(30),
    hospital_afm VARCHAR(20),
    destination_clinic VARCHAR(30),
    stage ENUM('SENT', 'APPROVED') NOT NULL DEFAULT 'SENT',
    PRIMARY KEY (id, patient_amka),
    INDEX (source_clinic, hospital_afm),
    FOREIGN KEY (source_clinic, hospital_afm) REFERENCES clinic(name, hospital_afm) ON UPDATE CASCADE ON DELETE CASCADE,
    INDEX (destination_clinic, hospital_afm),
    FOREIGN KEY (destination_clinic, hospital_afm) REFERENCES clinic(name, hospital_afm) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT user_doctor_transfer FOREIGN KEY (authorised_by) REFERENCES doctor(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT transfer_patient FOREIGN KEY (patient_amka) REFERENCES patient(amka) ON UPDATE CASCADE ON DELETE CASCADE
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
	name VARCHAR(30) NOT NULL,
	hospital_afm VARCHAR(20) NOT NULL,
	PRIMARY KEY (name, hospital_afm),
    CONSTRAINT hospital_lab FOREIGN KEY (hospital_afm) REFERENCES hospital(afm) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS lab_agent (
    user_name VARCHAR(20) PRIMARY KEY,
    lab_name VARCHAR(20) NOT NULL,
    CONSTRAINT user_lab FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT name_lab FOREIGN KEY (lab_name) REFERENCES lab(name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS clinic_agent (
    user_name VARCHAR(20) PRIMARY KEY,
    clinic_name VARCHAR(30) NOT NULL,
    CONSTRAINT clinic_nurse FOREIGN KEY (user_name) REFERENCES user(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT agent_clinic FOREIGN KEY (clinic_name) REFERENCES clinic(name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS clinic_agent_post (
	post_id VARCHAR(20) PRIMARY KEY,
    clinic_name VARCHAR(30) NOT NULL,
    user_name VARCHAR(20) NOT NULL,
    created_at DATETIME DEFAULT NOW(),
    title VARCHAR(20),
    post_text TEXT NOT NULL,
    CONSTRAINT clinic_name_post FOREIGN KEY (clinic_name) REFERENCES clinic(name) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;
