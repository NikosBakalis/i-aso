package model;

public class Clinic {
    private static String name, hospitalAfm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Clinic.name = name;
    }

    public String getHospitalAfm() {
        return hospitalAfm;
    }

    public void setHospitalAfm(String hospitalAfm) {
        Clinic.hospitalAfm = hospitalAfm;
    }
}
