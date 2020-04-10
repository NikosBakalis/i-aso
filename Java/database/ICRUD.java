package database;

import model.Doctor;
import model.Hospital;
import model.User;

public interface ICRUD {
    User getUser(String username);
    Doctor getDoctor(String sector, String profile, String clinic);
    Hospital getHospital(String afm);
}
