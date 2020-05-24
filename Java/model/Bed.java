package model;

public class Bed {
    private static String number, chamberId;
    private static Boolean isFree;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        Bed.number = number;
    }

    public String getChamberId() {
        return chamberId;
    }

    public void setChamberId(String chamberId) {
        Bed.chamberId = chamberId;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        Bed.isFree = isFree;
    }
}
