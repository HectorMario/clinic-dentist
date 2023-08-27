package controller;

import logic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public class UserController implements Serializable {

    private EntityManagerFactory emf;

    public UserController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public UserController() {
        this.emf = Persistence.createEntityManagerFactory("clinic");
    }

    public EntityManager getEntity() {
        return emf.createEntityManager();
    }

    public void createUser(User user) {
        EntityManager em = null;
        try {
            em = getEntity();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void updateUser(User user) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public User readUser(int id) {
        EntityManager em = getEntity();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    public List<User> readAllUsers() {
        EntityManager em = getEntity();
        try {
            return em.createQuery("SELECT u FROM User u", User.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void deleteUser(int id) {
        EntityManager em = getEntity();
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}