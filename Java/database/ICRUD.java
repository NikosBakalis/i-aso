package database;

import model.*;

public interface ICRUD {
    User getUser(String username);
    Doctor getDoctor(String username);
    Hospital getHospital(String afm);
    Lab getLab(String hospital_afm, String name);
    Clinic getClinic(String name, String hospital_afm);
    ClinicAgent getClinicAgent(String username);
}
