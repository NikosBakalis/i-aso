package model;

public class Doctor extends User{
    private static String username, sector;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        Doctor.username = username;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        Doctor.sector = sector;
    }
}
