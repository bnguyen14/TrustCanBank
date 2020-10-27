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
        Query<Account> query = session.createQuery("FROM Account");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Account> findAllAccountsByUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Account> query = session.createQuery("FROM Account WHERE user_id=:ID");
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
    	System.out.println("DAO_createaccount called");
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(newAccount);
    }

    @Override
    @Transactional
    public void deleteAccountById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Account> query = session.createQuery("DELETE FROM Account WHERE account_id=:ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }
    
    @Override
    @Transactional
    public void changeAccountBalance(double amount, int id) {
    	Session session = entityManager.unwrap(Session.class);
    	Account account = findById(id);
    	account.setAccountBalance(account.getAccountBalance()+amount);
    	session.saveOrUpdate(account);
//    	Query<Account> query = session.createQuery("SELECT accountBalance FROM Account WHERE account_id=:ID");
//    	query.setParameter("ID", id);
//    	Query<Account> updateQuery = session.createQuery("UPDATE Account SET accountBalance=:balance WHERE account_id=:ID");
//    	updateQuery.setParameter("ID", id);
//    	updateQuery.setParameter("balance", query.getFirstResult()-amount);
//    	updateQuery.executeUpdate();
    }
}
