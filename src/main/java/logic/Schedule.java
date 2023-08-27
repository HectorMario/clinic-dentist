package logic;

import javax.persistence.*;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_schedule;
    private String hourStart;
    private String hourEnd;
    @OneToOne
    private Dentist dentist;

    public Schedule() {
    }

    public Schedule(int id_schedule, String hourStart, String hourEnd, Dentist dentist) {
        this.id_schedule = id_schedule;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
        this.dentist = dentist;
    }

    public int getId_schedule() {
        return id_schedule;
    }

    public void setId_schedule(int id_schedule) {
        this.id_schedule = id_schedule;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
}