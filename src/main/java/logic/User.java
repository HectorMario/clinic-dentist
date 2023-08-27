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
    @OneToOne
    private Secretary secretary;
    @OneToOne
    private Dentist dentist;

    public User() {

    }

    public User(int id_user, String username, String password, String rol, Secretary secretary, Dentist dentist) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.secretary = secretary;
        this.dentist = dentist;
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

    public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
}