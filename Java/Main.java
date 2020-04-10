import database.ICRUDImpl;

public class Main {
    public static void main(String[] args) {
        ICRUDImpl obj = new ICRUDImpl();
        obj.getHospital("123456");
    }
}
