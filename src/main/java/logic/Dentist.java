package logic;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dentists")
public class Dentist extends Person {
    private String specialty;
    @OneToMany(mappedBy = "dentist")
    private List<Turn> turns;
    @OneToOne
    private User user;
    @OneToOne
    private Schedule schedule;

    public Dentist() {
    }

    public Dentist(int id, String name, String surName, Date dateOfBirth, String address, String specialty, List<Turn> turns, User user, Schedule schedule) {
        super(id, name, surName, dateOfBirth, address);
        this.specialty = specialty;
        this.turns = turns;
        this.user = user;
        this.schedule = schedule;
    }

    public Dentist(String name, String surName, Date dateOfBirth, String address, String specialty, List<Turn> turns, User user, Schedule schedule) {

        this.specialty = specialty;
        this.turns = turns;
        this.user = user;
        this.schedule = schedule;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}