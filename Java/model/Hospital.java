package model;

public class Hospital {
    private static String afm, name, first_street_name, email_address, second_street_name;
    private static int first_street_number, primary_phone_number, emergency_phone_number, second_street_number;

    public static String getAfm() {
        return afm;
    }

    public static void setAfm(String afm) {
        Hospital.afm = afm;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Hospital.name = name;
    }

    public static String getFirst_street_name() {
        return first_street_name;
    }

    public static void setFirst_street_name(String first_street_name) {
        Hospital.first_street_name = first_street_name;
    }

    public static String getEmail_address() {
        return email_address;
    }

    public static void setEmail_address(String email_address) {
        Hospital.email_address = email_address;
    }

    public static String getSecond_street_name() {
        return second_street_name;
    }

    public static void setSecond_street_name(String second_street_name) {
        Hospital.second_street_name = second_street_name;
    }

    public static int getFirst_street_number() {
        return first_street_number;
    }

    public static void setFirst_street_number(int first_street_number) {
        Hospital.first_street_number = first_street_number;
    }

    public static int getPrimary_phone_number() {
        return primary_phone_number;
    }

    public static void setPrimary_phone_number(int primary_phone_number) {
        Hospital.primary_phone_number = primary_phone_number;
    }

    public static int getEmergency_phone_number() {
        return emergency_phone_number;
    }

    public static void setEmergency_phone_number(int emergency_phone_number) {
        Hospital.emergency_phone_number = emergency_phone_number;
    }

    public static int getSecond_street_number() {
        return second_street_number;
    }

    public static void setSecond_street_number(int second_street_number) {
        Hospital.second_street_number = second_street_number;
    }
}
