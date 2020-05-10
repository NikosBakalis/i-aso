package database;

import model.Doctor;
import model.Hospital;
import model.Lab;
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
                    User.setUsername(resultSet.getString("user_name"));
                    User.setHospital_afm(resultSet.getString("hospital_afm"));
                    User.setFirst_name(resultSet.getString("user_first_name"));
                    User.setLast_name(resultSet.getString("user_last_name"));
                    User.setBirth_date(resultSet.getDate("user_birth_date"));
                    User.setPassword(resultSet.getString("user_password"));
                    User.setSpecification(resultSet.getString("specification"));
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
                    Doctor.setUsername(resultSet.getString("user_name"));
                    Doctor.setSector(resultSet.getString("doctor_sector"));
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
                    Hospital.setAfm(resultSet.getString("hospital_afm"));
                    Hospital.setName(resultSet.getString("hospital_name"));
                    Hospital.setFirst_street_name(resultSet.getString("first_street_name"));
                    Hospital.setFirst_street_number(resultSet.getInt("first_street_number"));
                    Hospital.setPrimary_phone_number(resultSet.getInt("primary_phone_number"));
                    Hospital.setEmergency_phone_number(resultSet.getInt("emergency_phone_number"));
                    Hospital.setEmail_address(resultSet.getString("email_address"));
                    Hospital.setSecond_street_name(resultSet.getString("second_street_name"));
                    Hospital.setSecond_street_number(resultSet.getInt("second_street_number"));
                }
            }
            resultSet.close();
            return hospital;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Lab getLab(String hospital_afm, String name) {
        try {
            String query = "SELECT * FROM lab WHERE lab.hospital_afm = ? AND lab.lab_name = ?";

            ResultSet resultSet;
            Lab lab;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, hospital_afm);
                preparedStatement.setString(2, name);
                resultSet = preparedStatement.executeQuery();
                lab = null;
                if(resultSet.next()) {
                    lab = new Lab();
                    Lab.setHospital_afm(resultSet.getString("hospital_afm"));
                    Lab.setName(resultSet.getString("lab_name"));
                }
            }
            resultSet.close();
            return lab;
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
