package controller;


import logic.Dentist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

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

    public void createDentist(Dentist dentist){
        EntityManager em = null;
        try{
            em = getEntity();
            em.getTransaction();
            em.persist(dentist);
            em.getTransaction().commit();
        } finally {
            if (em != null){
                em.close();
            }
        }
    }
}
