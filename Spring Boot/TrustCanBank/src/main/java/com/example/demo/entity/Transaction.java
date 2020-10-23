package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="account_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private int transactionId;

    @Column(name="transaction_date")
    private String transactionDate;

    @Column(name="transaction_type")
    private String transactionType;

    @Column(name="transaction_amount")
    private double transactionAmount;

    @Column(name="account_id")
    private int accountId;

    public Transaction() {
        this.transactionId = 0;
        this.transactionDate = "";
        this.transactionType = "";
        this.transactionAmount = 0.0;
        this.accountId = 0;
    }

    public Transaction(int transactionId, String transactionDate, String transactionType, double transactionAmount, int accountId) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.accountId = accountId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionDate='" + transactionDate + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", accountId=" + accountId +
                '}';
    }
}