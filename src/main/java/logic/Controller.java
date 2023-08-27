package logic;

import controller.PersistenceController;

public class Controller {

    PersistenceController persistenceController = new PersistenceController();

    public void CreateUser (int id, String username, String password, String rol){
        User newUser = new User(id,username,password,rol);
        persistenceController.CreateUser(newUser);
    }
}
