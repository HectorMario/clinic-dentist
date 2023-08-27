package controller;

import logic.Secretary;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public class SecretaryController implements Serializable {

    private EntityManagerFactory emf;

    public SecretaryController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public SecretaryController() {
        this.emf = Persistence.createEntityManagerFactory("clinic");
    }

    public EntityManager getEntity() {
        return emf.createEntityManager();
    }

    public void createSecretary(Secretary secretary) {
        EntityManager em = null;
        try {
            em = getEntity();
            em.getTransaction().begin();
            em.persist(secretary);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void updateSecretary(Secretary secretary) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            em.merge(secretary);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Secretary readSecretary(int id) {
        EntityManager em = getEntity();
        try {
            return em.find(Secretary.class, id);
        } finally {
            em.close();
        }
    }

    public List<Secretary> readAllSecretaries() {
        EntityManager em = getEntity();
        try {
            return em.createQuery("SELECT s FROM Secretary s", Secretary.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void deleteSecretary(int id) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            Secretary secretary = em.find(Secretary.class, id);
            if (secretary != null) {
                em.remove(secretary);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
