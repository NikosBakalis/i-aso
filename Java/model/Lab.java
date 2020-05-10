package model;

public class Lab {
    private static String hospital_afm, name;

    public static String getHospital_afm() {
        return hospital_afm;
    }

    public static void setHospital_afm(String hospital_afm) {
        Lab.hospital_afm = hospital_afm;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Lab.name = name;
    }
}
