package database;

import model.Doctor;
import model.Hospital;
import model.User;

import java.sql.*;


public class ICRUDImpl implements ICRUD {

    private static Connection connection;


    public User getUser(String username) {
        return null;
    }

    public Doctor getDoctor(String sector, String profile, String clinic) {
        return null;
    }

    public Hospital getHospital(String afm) {
        try {
            openConnection();
            String query = "SELECT * FROM hospital WHERE hospital.hospital_afm = '" + afm + "'";

            ResultSet resultSet;
            Hospital hospital;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
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

    void openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/iaso_hospital_db_v06", "root", "password"));
            System.out.println("Connection established successfully with the database server.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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
