package logic;

import javax.persistence.*;

@Entity
@Table(name = "clinic_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    private String username;
    private String password;
    private String rol;
    public User() {

    }

    public User(int id_user, String username, String password, String rol) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


}