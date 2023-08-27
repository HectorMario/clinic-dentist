package controller;

import logic.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public class PatientsController implements Serializable {

    private EntityManagerFactory emf;

    public PatientsController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PatientsController() {
        this.emf = Persistence.createEntityManagerFactory("clinic");
    }

    public EntityManager getEntity() {
        return emf.createEntityManager();
    }

    public void createPatient(Patient patient) {
        EntityManager em = null;
        try {
            em = getEntity();
            em.getTransaction().begin();
            em.persist(patient);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void updatePatient(Patient patient) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            em.merge(patient);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Patient readPatient(int id) {
        EntityManager em = getEntity();
        try {
            return em.find(Patient.class, id);
        } finally {
            em.close();
        }
    }

    public List<Patient> readAllPatients() {
        EntityManager em = getEntity();
        try {
            return em.createQuery("SELECT p FROM Patient p", Patient.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void deletePatient(int id) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            Patient patient = em.find(Patient.class, id);
            if (patient != null) {
                em.remove(patient);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}

