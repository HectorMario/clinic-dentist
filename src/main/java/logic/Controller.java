package logic;

import controller.PersistenceController;

import java.util.List;

public class Controller {

    PersistenceController persistenceController = new PersistenceController();

    public void CreateUser (int id, String username, String password, String rol){
        User newUser = new User(id,username,password,rol);
        persistenceController.CreateUser(newUser);
    }

    public User getUser (String username){
        return persistenceController.getUser(username);
    }

    public List<Patient> getPatients(){
        return persistenceController.getPatients();
    }
}
