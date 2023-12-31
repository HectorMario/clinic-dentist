package controller;


import logic.Dentist;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public class DentistController implements Serializable {

    private EntityManagerFactory emf;

    public DentistController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public DentistController() {
        this.emf = Persistence.createEntityManagerFactory("clinic");
    }

    public EntityManager getEntity() {
        return emf.createEntityManager();
    }

    public void createDentist(Dentist dentist) {
        EntityManager em = null;
        try {
            em = getEntity();
            em.getTransaction().begin();
            em.persist(dentist);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void updateDentist(Dentist dentist) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            em.merge(dentist);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Dentist readDentist(int id) {
        EntityManager em = getEntity();
        try {
            return em.find(Dentist.class, id);
        } finally {
            em.close();
        }
    }

    public List<Dentist> readAllDentists() {
        EntityManager em = getEntity();
        try {
            return em.createQuery("SELECT d FROM Dentist d", Dentist.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void deleteDentist(int id) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            Dentist dentist = em.find(Dentist.class, id);
            if (dentist != null) {
                em.remove(dentist);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}

