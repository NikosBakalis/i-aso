package model;

public class ClinicAgent extends User{
    private static String username, clinic;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        ClinicAgent.username = username;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        ClinicAgent.clinic = clinic;
    }
}
