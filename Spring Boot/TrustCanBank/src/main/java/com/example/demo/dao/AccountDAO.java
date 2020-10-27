package com.example.demo.dao;

import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;

import java.util.List;

public interface AccountDAO {

    List<Account> findAll();
    List<Account> findAllAccountsByUser(int id);
    Account findById(int id);
    void createAccount(Account newAccount);
    void deleteAccountById(int id);
	void changeAccountBalance(double amount, int id);
}
