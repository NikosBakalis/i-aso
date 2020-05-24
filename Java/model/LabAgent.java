package model;

public class LabAgent {
    private static String username, labName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        LabAgent.username = username;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        LabAgent.labName = labName;
    }
}
