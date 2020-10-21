package com.example.demo.dao;

import com.example.demo.entity.User;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("FROM Trustcanbank");
        return query.getResultList();
    }

    @Override
    @Transactional
    public User findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        User myUser = session.get(User.class, id);
        return myUser;
    }

    @Override
    @Transactional
    public List<User> findByName(String username) {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("FROM trustcanbank WHERE username=:username");
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    @Transactional
    public void createUser(User newUser) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(newUser);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("DELETE FROM Trustcanbank WHERE userid=:ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }
}
