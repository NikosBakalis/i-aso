package model;

public class Hospital {
    private static String afm, name, first_street_name, email_address, second_street_name;
    private static int first_street_number, primary_phone_number, emergency_phone_number, second_street_number;


    public String getAfm(String hospital_afm) {
        return afm;
    }

    public void setAfm(String afm) {
        Hospital.afm = afm;
    }

    public String getName(String hospital_name) {
        return name;
    }

    public void setName(String name) {
        Hospital.name = name;
    }

    public String getFirst_street_name(String first_street_name) {
        return Hospital.first_street_name;
    }

    public void setFirst_street_name(String first_street_name) {
        Hospital.first_street_name = first_street_name;
    }

    public String getEmail_address(String email_address) {
        return Hospital.email_address;
    }

    public void setEmail_address(String email_address) {
        Hospital.email_address = email_address;
    }

    public String getSecond_street_name(String second_street_name) {
        return Hospital.second_street_name;
    }

    public void setSecond_street_name(String second_street_name) {
        Hospital.second_street_name = second_street_name;
    }

    public int getFirst_street_number(String first_street_number) {
        return Hospital.first_street_number;
    }

    public void setFirst_street_number(int first_street_number) {
        Hospital.first_street_number = first_street_number;
    }

    public int getPrimary_phone_number(String primary_phone_number) {
        return Hospital.primary_phone_number;
    }

    public void setPrimary_phone_number(int primary_phone_number) {
        Hospital.primary_phone_number = primary_phone_number;
    }

    public int getEmergency_phone_number(String emergency_phone_number) {
        return Hospital.emergency_phone_number;
    }

    public void setEmergency_phone_number(int emergency_phone_number) {
        Hospital.emergency_phone_number = emergency_phone_number;
    }

    public int getSecond_street_number(String second_street_number) {
        return Hospital.second_street_number;
    }

    public void setSecond_street_number(int second_street_number) {
        Hospital.second_street_number = second_street_number;
    }
}
