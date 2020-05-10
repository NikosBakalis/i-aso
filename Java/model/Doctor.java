package model;

public class Doctor extends User{
    private static String username, sector;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Doctor.username = username;
    }

    public static String getSector() {
        return sector;
    }

    public static void setSector(String sector) {
        Doctor.sector = sector;
    }
}
