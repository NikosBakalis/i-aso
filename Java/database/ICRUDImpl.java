package database;

import com.mysql.cj.jdbc.JdbcConnection;

import model.Doctor;
import model.Hospital;
import model.User;

import java.sql.*;


public class ICRUDImpl implements ICRUD {

    private JdbcConnection connection;

    public User getUser(String username) {
        return null;
    }

    public Doctor getDoctor(String sector, String profile, String clinic) {
        return null;
    }

    public Hospital getHospital(String afm) {
        try {
            String query = "SELECT * FROM hospital WHERE hospital.hospital_afm = '" + afm + "'";

            ResultSet resultSet;
            Hospital hospital;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                hospital = null;
                if(resultSet.next()) {
                    hospital = new Hospital();
                    hospital.getAfm(resultSet.getString("hospital_afm"));
                    hospital.getName(resultSet.getString("hospital_name"));
                    hospital.getFirst_street_name(resultSet.getString("first_street_name"));
                    hospital.getFirst_street_number(resultSet.getString("first_street_number"));
                    hospital.getPrimary_phone_number(resultSet.getString("primary_phone_number"));
                    hospital.getEmergency_phone_number(resultSet.getString("emergency_phone_number"));
                    hospital.getEmail_address(resultSet.getString("email_address"));
                    hospital.getSecond_street_name(resultSet.getString("second_street_name"));
                    hospital.getSecond_street_number(resultSet.getString("second_street_number"));
                }
            }
            resultSet.close();
            return hospital;
        } catch (SQLException e) {
            return null;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = (JdbcConnection) connection;
    }

}
