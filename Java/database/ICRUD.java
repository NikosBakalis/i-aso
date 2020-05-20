package database;

import model.*;

public interface ICRUD {
    User getUser(String username);
    Doctor getDoctor(String username);
    Hospital getHospital(String afm);
    Lab getLab(String hospital_afm, String name);
    ClinicAgent getClinicAgent(String username);
}
