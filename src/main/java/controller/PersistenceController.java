package controller;

import logic.Patient;
import logic.User;

import java.util.List;

public class PersistenceController {
    DentistController dentistController = new DentistController();
    PatientsController patientsController = new PatientsController();
    ResponsibleController responsibleController = new ResponsibleController();
    ScheduleController scheduleController = new ScheduleController();
    SecretaryController secretaryController = new SecretaryController();
    TurnController turnController = new TurnController();
    UserController userController = new UserController();

    public boolean CreateUser (User user){
       return userController.createUser(user);
    }

    public User getUser (String username){
        return  userController.readUser(username);
    }

    public List<Patient> getPatients (){
        return patientsController.readAllPatients();
    }
}
