import database.ICRUDImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ICRUDImpl obj = new ICRUDImpl();
        obj.getHospital("123456");
    }
}
