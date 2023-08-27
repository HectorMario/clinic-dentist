package controller;

import logic.Responsible;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public class ResponsibleController implements Serializable {

    private EntityManagerFactory emf;

    public ResponsibleController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ResponsibleController() {
        this.emf = Persistence.createEntityManagerFactory("clinic");
    }

    public EntityManager getEntity() {
        return emf.createEntityManager();
    }

    public void createResponsible(Responsible responsible) {
        EntityManager em = null;
        try {
            em = getEntity();
            em.getTransaction().begin();
            em.persist(responsible);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void updateResponsible(Responsible responsible) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            em.merge(responsible);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Responsible readResponsible(int id) {
        EntityManager em = getEntity();
        try {
            return em.find(Responsible.class, id);
        } finally {
            em.close();
        }
    }

    public List<Responsible> readAllResponsibles() {
        EntityManager em = getEntity();
        try {
            return em.createQuery("SELECT r FROM Responsible r", Responsible.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void deleteResponsible(int id) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            Responsible responsible = em.find(Responsible.class, id);
            if (responsible != null) {
                em.remove(responsible);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}

