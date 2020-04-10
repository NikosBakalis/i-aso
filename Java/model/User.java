package model;

import java.sql.Date;

public class User {
    private static String username, first_name, last_name, password, kind;
    private static Date birth_date;

    public static String getUsername() { return username; }

    public static void setUsername(String username) { User.username = username; }

    public static String getFirst_name() { return first_name; }

    public static void setFirst_name(String first_name) { User.first_name = first_name; }

    public static String getLast_name() { return last_name; }

    public static void setLast_name(String last_name) { User.last_name = last_name; }

    public static String getPassword() { return password; }

    public static void setPassword(String password) { User.password = password; }

    public static String getKind() { return kind; }

    public static void setKind(String kind) { User.kind = kind; }

    public static Date getBirth_date() { return birth_date; }

    public static void setBirth_date(Date birth_date) { User.birth_date = birth_date; }
}
