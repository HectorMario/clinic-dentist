package controller;

import logic.Schedule;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public class ScheduleController implements Serializable {

    private EntityManagerFactory emf;

    public ScheduleController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ScheduleController() {
        this.emf = Persistence.createEntityManagerFactory("clinic");
    }

    public EntityManager getEntity() {
        return emf.createEntityManager();
    }

    public void createSchedule(Schedule schedule) {
        EntityManager em = null;
        try {
            em = getEntity();
            em.getTransaction().begin();
            em.persist(schedule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void updateSchedule(Schedule schedule) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            em.merge(schedule);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Schedule readSchedule(int id) {
        EntityManager em = getEntity();
        try {
            return em.find(Schedule.class, id);
        } finally {
            em.close();
        }
    }

    public List<Schedule> readAllSchedules() {
        EntityManager em = getEntity();
        try {
            return em.createQuery("SELECT s FROM Schedule s", Schedule.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void deleteSchedule(int id) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            Schedule schedule = em.find(Schedule.class, id);
            if (schedule != null) {
                em.remove(schedule);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
