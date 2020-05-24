package model;

public class PatientFolder {
    private static String patientAmka, chronicDisease, patientAllergies, patientSurgeries, bloodType, HBV, HBC;

    public String getPatientAmka() {
        return patientAmka;
    }

    public void setPatientAmka(String patientAmka) {
        PatientFolder.patientAmka = patientAmka;
    }

    public String getChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(String chronicDisease) {
        PatientFolder.chronicDisease = chronicDisease;
    }

    public String getPatientAllergies() {
        return patientAllergies;
    }

    public void setPatientAllergies(String patientAllergies) {
        PatientFolder.patientAllergies = patientAllergies;
    }

    public String getPatientSurgeries() {
        return patientSurgeries;
    }

    public void setPatientSurgeries(String patientSurgeries) {
        PatientFolder.patientSurgeries = patientSurgeries;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        PatientFolder.bloodType = bloodType;
    }

    public String getHBV() {
        return HBV;
    }

    public void setHBV(String HBV) {
        PatientFolder.HBV = HBV;
    }

    public String getHBC() {
        return HBC;
    }

    public void setHBC(String HBC) {
        PatientFolder.HBC = HBC;
    }
}
