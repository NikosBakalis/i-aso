package database;

import model.Doctor;
import model.Hospital;
import model.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class ICRUDImpl implements ICRUD {

    private static Connection connection;

    public User getUser(String username) {
        try {
            String query = "SELECT * FROM user WHERE user.user_name = ?";
            ResultSet resultSet;
            User user;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                user = null;
                if(resultSet.next()) {
                    user = new User();
                    user.setUsername(resultSet.getString("user_name"));
                    user.setHospital_afm(resultSet.getString("hospital_afm"));
                    user.setFirst_name(resultSet.getString("user_first_name"));
                    user.setLast_name(resultSet.getString("user_last_name"));
                    user.setBirth_date(resultSet.getDate("user_birth_date"));
                    user.setPassword(resultSet.getString("user_password"));
                    user.setEncryption_key(resultSet.getString("user_encryption_key"));
                    user.setKind(resultSet.getString("kind"));
                }
            }
            resultSet.close();
            return user;
        } catch (SQLException e) {
            return null;
        }
    }

    public Doctor getDoctor(String username) {
        try {
            String query = "SELECT * FROM doctor WHERE doctor.user_name = ?";

            ResultSet resultSet;
            Doctor doctor;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                doctor = null;
                if(resultSet.next()) {
                    doctor = new Doctor();
                    doctor.setUsername(resultSet.getString("user_name"));
                    doctor.setSector(resultSet.getString("doctor_sector"));
                }
            }
            resultSet.close();
            return doctor;
        } catch (SQLException e) {
            return null;
        }
    }

    public Hospital getHospital(String afm) {
        try {
            String query = "SELECT * FROM hospital WHERE hospital.hospital_afm = ?";

            ResultSet resultSet;
            Hospital hospital;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, afm);
                resultSet = preparedStatement.executeQuery();
                hospital = null;
                if(resultSet.next()) {
                    hospital = new Hospital();
                    hospital.setAfm(resultSet.getString("hospital_afm"));
                    hospital.setName(resultSet.getString("hospital_name"));
                    hospital.setFirst_street_name(resultSet.getString("first_street_name"));
                    hospital.setFirst_street_number(resultSet.getInt("first_street_number"));
                    hospital.setPrimary_phone_number(resultSet.getInt("primary_phone_number"));
                    hospital.setEmergency_phone_number(resultSet.getInt("emergency_phone_number"));
                    hospital.setEmail_address(resultSet.getString("email_address"));
                    hospital.setSecond_street_name(resultSet.getString("second_street_name"));
                    hospital.setSecond_street_number(resultSet.getInt("second_street_number"));
                }
            }
            resultSet.close();
            return hospital;
        } catch (SQLException e) {
            return null;
        }
    }

    public void openConnection() {
        try {
            System.out.println("Setting up connection.");
            Properties connection_properties = new Properties();
            connection_properties.load(new FileInputStream("MySQL/connection.properties"));
            String url_property = connection_properties.getProperty("url");
            String user_property = connection_properties.getProperty("user");
            String password_property = connection_properties.getProperty("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            setConnection(DriverManager.getConnection(url_property, user_property, password_property));
            System.out.println("Connection established successfully with the database server.");
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        ICRUDImpl.connection = connection;
    }
}
