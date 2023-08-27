package logic;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "responsibles")
public class Responsible extends Person {
    private String typeResponsible;
    @OneToOne
    private Patient patient;

    public Responsible() {
    }

    public Responsible(int id, String name, String surName, Date dateOfBirth, String address, String typeResponsible, Patient patient) {
        super(id, name, surName, dateOfBirth, address);
        this.typeResponsible = typeResponsible;
        this.patient = patient;
    }

    public String getTypeResponsible() {
        return typeResponsible;
    }

    public void setTypeResponsible(String typeResponsible) {
        this.typeResponsible = typeResponsible;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}