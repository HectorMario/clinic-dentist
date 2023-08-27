package logic;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "turns")
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_turn;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String hour;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    public Turn() {
    }

    public Turn (int id_turn, Date date, String hour, Patient patient, Dentist dentist) {
        this.id_turn = id_turn;
        this.date = date;
        this.hour = hour;
        this.patient = patient;
        this.dentist = dentist;
    }

    public int getId_turn() {
        return id_turn;
    }

    public void setId_turn(int id_turn) {
        this.id_turn = id_turn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
}