package ru.kata.spring.boot_security.demo.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getList() {
        return entityManager.createQuery("select distinct u from User u left join fetch u.roles ", User.class)
                .getResultList();
    }

    @Override
    public User getUser(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Integer id) {


        entityManager.createQuery(
                "DELETE User WHERE id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public UserDetails getUser(String username) {

        return entityManager.createQuery(
                        "SELECT u FROM User u WHERE u.name = :username", User.class).setParameter("username", username)
                .getSingleResult();
    }
}
