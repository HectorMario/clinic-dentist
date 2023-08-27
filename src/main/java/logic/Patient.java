package logic;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient extends Person {

    private String typeBlood;
    @OneToOne
    private Responsible responsible;
    @OneToMany(mappedBy = "patient")
    private List<Turn> turns;

    public Patient (int id, String name, String surName, Date dateOfBirth, String address, String typeBlood, Responsible responsible, List<Turn> turns) {
        super(id, name, surName, dateOfBirth, address);
        this.typeBlood = typeBlood;
        this.responsible = responsible;
        this.turns = turns;
    }
    public Patient() {
    }


    public String getTypeBlood() {
        return typeBlood;
    }

    public void setTypeBlood(String typeBlood) {
        this.typeBlood = typeBlood;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }
}