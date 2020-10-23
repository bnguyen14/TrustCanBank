package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="bank_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_balance")
    private double accountBalance;

    @Column(name = "userId")
    private int userId;

    public Account(){
        this.accountId = 0;
        this.accountType = "";
        this.accountBalance = 0.0;
        this.userId = 0;

    }

    public Account(int accountId, String accountType, double accountBalance, int userId) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountType='" + accountType + '\'' +
                ", accountBalance=" + accountBalance +
                ", userId=" + userId +
                '}';
    }
}