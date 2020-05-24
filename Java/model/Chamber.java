package model;

public class Chamber {
    private static String id, clinicName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        Chamber.id = id;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        Chamber.clinicName = clinicName;
    }
}
