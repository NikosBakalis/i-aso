package database;

import model.Doctor;
import model.Hospital;
import model.Lab;
import model.User;

public interface ICRUD {
    User getUser(String username);
    Doctor getDoctor(String username);
    Hospital getHospital(String afm);
    Lab getLab(String hospital_afm, String name);
}
