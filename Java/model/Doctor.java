package model;

public class Doctor extends User{
    private static String username, sector, clinic;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        Doctor.username = username;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        Doctor.sector = sector;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        Doctor.clinic = clinic;
    }
}
