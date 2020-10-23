package com.example.demo.dao;

import com.example.demo.entity.Account;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private EntityManager entityManager;

    @Autowired
    public AccountDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Account> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Account> query = session.createQuery("FROM Bank_account");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Account> findAllAccountsByUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Account> query = session.createQuery("FROM bank_account WHERE userid=:ID");
        query.setParameter("ID", id);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Account findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Account theAccount = session.get(Account.class, id);
        return theAccount;
    }

    @Override
    @Transactional
    public void createAccount(Account newAccount) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(newAccount);
    }

    @Override
    @Transactional
    public void deleteAccountById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Account> query = session.createQuery("DELETE FROM bank_account WHERE account_id=:ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }
}