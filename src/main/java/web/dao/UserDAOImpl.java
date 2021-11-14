package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @PersistenceContext(unitName = "emf")
    public void setEntityManager(EntityManager entityManager) {
        System.out.println("UserDAOImpl - setEntityManager");
        this.entityManager = entityManager;
    }

    public List<User> allUsers() {
        System.out.println("UserDAOImpl - allUsers");
        return entityManager.createQuery("from " + User.class.getName()).getResultList();
    }

    public void add(User user) {
        System.out.println("UserDAOImpl - add");
        entityManager.persist(user);
    }

    public void delete(User user) {
        System.out.println("UserDAOImpl - delete");
        entityManager.remove(entityManager.find(User.class, user.getId()));
    }

    public void edit(User user) {
        System.out.println("UserDAOImpl - edit");
        entityManager.merge(user);
    }

    public User getById(int id) {
        System.out.println("UserDAOImpl - getById");
        return entityManager.find(User.class, id);
    }

    @Override
    public User findByName(String username) {
        System.out.println("UserDAOImpl - findByName");
        User user = null;
        Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.login=:username");
        query.setParameter("username", username);
        try {
            System.out.println("UserDAOImpl - findByName - try");
            user = (User) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("UserDAOImpl - findByName - catch");
            // Handle exception
        }
        return user;
    }
}

