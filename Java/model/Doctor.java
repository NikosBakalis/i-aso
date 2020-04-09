package model;

public class Doctor extends User{
    private static String sector;
    private static String profile;
    private static String clinic;


    public static String getSector() {
        return sector;
    }

    public static void setSector(String sector) {
        Doctor.sector = sector;
    }

    public static String getProfile() {
        return profile;
    }

    public static void setProfile(String profile) {
        Doctor.profile = profile;
    }

    public static String getClinic() {
        return clinic;
    }

    public static void setClinic(String clinic) {
        Doctor.clinic = clinic;
    }
}
