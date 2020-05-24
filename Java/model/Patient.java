package model;

import java.sql.Date;

public class Patient {
    private static String amka, afm, firstName, lastName, nationality, religion, gender, insurance, fatherFirstName, fatherLastName, motherFirstName, motherLastName, firstStreetName, firstStreetNumber, primaryPhoneNumber, emergencePhoneNumber, emainAddress, secondStreetName, secondStreetNumber;
    private static Date birthDate;

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        Patient.amka = amka;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        Patient.afm = afm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        Patient.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        Patient.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        Patient.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        Patient.nationality = nationality;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        Patient.religion = religion;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        Patient.gender = gender;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        Patient.insurance = insurance;
    }

    public String getFatherFirstName() {
        return fatherFirstName;
    }

    public void setFatherFirstName(String fatherFirstName) {
        Patient.fatherFirstName = fatherFirstName;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        Patient.fatherLastName = fatherLastName;
    }

    public String getMotherFirstName() {
        return motherFirstName;
    }

    public void setMotherFirstName(String motherFirstName) {
        Patient.motherFirstName = motherFirstName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        Patient.motherLastName = motherLastName;
    }

    public String getFirstStreetName() {
        return firstStreetName;
    }

    public void setFirstStreetName(String firstStreetName) {
        Patient.firstStreetName = firstStreetName;
    }

    public String getFirstStreetNumber() {
        return firstStreetNumber;
    }

    public void setFirstStreetNumber(String firstStreetNumber) {
        Patient.firstStreetNumber = firstStreetNumber;
    }

    public String getPrimaryPhoneNumber() {
        return primaryPhoneNumber;
    }

    public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
        Patient.primaryPhoneNumber = primaryPhoneNumber;
    }

    public String getEmergencePhoneNumber() {
        return emergencePhoneNumber;
    }

    public void setEmergencePhoneNumber(String emergencePhoneNumber) {
        Patient.emergencePhoneNumber = emergencePhoneNumber;
    }

    public String getEmainAddress() {
        return emainAddress;
    }

    public void setEmainAddress(String emainAddress) {
        Patient.emainAddress = emainAddress;
    }

    public String getSecondStreetName() {
        return secondStreetName;
    }

    public void setSecondStreetName(String secondStreetName) {
        Patient.secondStreetName = secondStreetName;
    }

    public String getSecondStreetNumber() {
        return secondStreetNumber;
    }

    public void setSecondStreetNumber(String secondStreetNumber) {
        Patient.secondStreetNumber = secondStreetNumber;
    }
}
