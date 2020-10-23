package com.example.demo.dao;

import com.example.demo.entity.Transaction;

import java.util.List;

public interface TransactionDAO {

    List<Transaction> findAll();
    List<Transaction> findAllTransactionsByAccount(int id);
    Transaction findById(int id);
    void createTransaction(Transaction newTransaction);
    void deleteTransactionById(int id);
}
