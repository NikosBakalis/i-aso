package model;

public class Doctor extends User{
    private static String username, sector;

    @Override
    public String getUsername() { return username; }

    @Override
    public void setUsername(String username) { Doctor.username = username; }

    public String getSector() { return sector; }

    public void setSector(String sector) { Doctor.sector = sector; }
}
