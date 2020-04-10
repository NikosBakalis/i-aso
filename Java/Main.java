import database.ICRUDImpl;

public class Main {
    public static void main(String[] args) {
        ICRUDImpl icrudimpl = new ICRUDImpl();
        icrudimpl.openConnection();
        icrudimpl.getUser("name");
        icrudimpl.getDoctor("name");
        icrudimpl.getHospital("123456");
    }
}
