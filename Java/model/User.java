package model;

import java.sql.Date;

public class User {
    private static String username, hospital_afm, first_name, last_name, password, kind, encryption_key;
    private static Date birth_date;

    public String getUsername() { return username; }

    public void setUsername(String username) { User.username = username; }

    public String getHospital_afm() { return hospital_afm; }

    public void setHospital_afm(String hospital_afm) { User.hospital_afm = hospital_afm; }

    public String getFirst_name() { return first_name; }

    public void setFirst_name(String first_name) { User.first_name = first_name; }

    public String getLast_name() { return last_name; }

    public void setLast_name(String last_name) { User.last_name = last_name; }

    public Date getBirth_date() { return birth_date; }

    public void setBirth_date(Date birth_date) { User.birth_date = birth_date; }

    public String getPassword() { return password; }

    public void setPassword(String password) { User.password = password; }

    public String getEncryption_key() { return encryption_key; }

    public void setEncryption_key(String encryption_key) { User.encryption_key = encryption_key; }

    public String getKind() { return kind; }

    public void setKind(String kind) { User.kind = kind; }
}
