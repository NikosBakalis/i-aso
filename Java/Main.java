import database.ICRUDImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        openConnection();
        ICRUDImpl obj = new ICRUDImpl();
        obj.getHospital("123456");
    }

    static void openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iaso_hospital_db_v06", "root", "password");
            System.out.println("Connection established successfully with the database server.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
    }
}
