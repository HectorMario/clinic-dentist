package controller;

import logic.Turn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public class TurnController implements Serializable {

    private EntityManagerFactory emf;

    public TurnController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public TurnController() {
        this.emf = Persistence.createEntityManagerFactory("clinic");
    }

    public EntityManager getEntity() {
        return emf.createEntityManager();
    }

    public void createTurn(Turn turn) {
        EntityManager em = null;
        try {
            em = getEntity();
            em.getTransaction().begin();
            em.persist(turn);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void updateTurn(Turn turn) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            em.merge(turn);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Turn readTurn(int id) {
        EntityManager em = getEntity();
        try {
            return em.find(Turn.class, id);
        } finally {
            em.close();
        }
    }

    public List<Turn> readAllTurns() {
        EntityManager em = getEntity();
        try {
            return em.createQuery("SELECT t FROM Turn t", Turn.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void deleteTurn(int id) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            Turn turn = em.find(Turn.class, id);
            if (turn != null) {
                em.remove(turn);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}

