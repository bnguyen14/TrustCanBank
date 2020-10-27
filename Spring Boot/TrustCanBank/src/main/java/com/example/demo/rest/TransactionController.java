package com.example.demo.rest;
import com.example.demo.dao.TransactionDAOImpl;
import com.example.demo.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"}) // For angular
@RestController
@RequestMapping("/api")
public class TransactionController {

    private final TransactionDAOImpl transactionDAOImpl;

    @Autowired
    public TransactionController(TransactionDAOImpl transactionDAOImpl){
        this.transactionDAOImpl = transactionDAOImpl;
    }

    @GetMapping("transactions/list")
    public List<Transaction> findAll(){
        return transactionDAOImpl.findAll();
    }

    @GetMapping("transactions/listByTransaction/{id}")
    public ResponseEntity<List<Transaction>> findAllTransactionsByAccount(@PathVariable int id){
    	
        return new ResponseEntity<List<Transaction>>(transactionDAOImpl.findAllTransactionsByAccount(id), HttpStatus.OK);
    }

    @GetMapping("transactions/{id}")
    public Transaction findById(int id){
        Transaction theTransaction = transactionDAOImpl.findById(id);
        return theTransaction;
    }

    @PostMapping("transactions/addTransaction")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction newTransaction){
        newTransaction.setTransactionId(0);
        System.out.println(newTransaction.toString());
        transactionDAOImpl.createTransaction(newTransaction);
        return new ResponseEntity<Transaction>(newTransaction, HttpStatus.OK);
    }

    @DeleteMapping("transactions/delete/{id}")
    public void deleteTransactionById(int id){
        Transaction theTransaction = transactionDAOImpl.findById(id);
        if(theTransaction == null)
            throw new RuntimeException("Transaction is not found - " + id);
        transactionDAOImpl.deleteTransactionById(id);
    }
}