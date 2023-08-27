package logic;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "secretaries")
public class Secretary extends Person {
    private String sector;
    @OneToOne
    private User user;

    public Secretary () {
    }

    public Secretary(int id, String name, String surName, Date dateOfBirth, String address, String sector, User user) {
        super(id, name, surName, dateOfBirth, address);
        this.sector = sector;
        this.user = user;
    }

    public Secretary( String name, String surName, Date dateOfBirth, String address, String sector, User user) {
        this.sector = sector;
        this.user = user;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}