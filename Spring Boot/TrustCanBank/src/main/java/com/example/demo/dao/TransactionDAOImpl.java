package com.example.demo.dao;
import com.example.demo.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO{

    private EntityManager entityManager;

    @Autowired
    public TransactionDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Transaction> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Transaction> query = session.createQuery("FROM Account_transaction");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Transaction> findAllTransactionsByAccount(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Transaction> query = session.createQuery("FROM Account_transaction WHERE account_id=:ID");
        query.setParameter("ID", id);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Transaction findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Transaction theTransaction = session.get(Transaction.class, id);
        return theTransaction;
    }

    @Override
    @Transactional
    public void createTransaction(Transaction newTransaction) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(newTransaction);
    }

    @Override
    @Transactional
    public void deleteTransactionById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Transaction> query = session.createQuery("DELETE FROM account_transaction WHERE account_id=:ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }
}
