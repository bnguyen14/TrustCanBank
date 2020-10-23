package com.example.demo.rest;
import com.example.demo.dao.AccountDAOImpl;
import com.example.demo.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"}) // For angular
@RestController
@RequestMapping("/api")
public class AccountController {

    private final AccountDAOImpl accountDAOImpl;

    @Autowired
    public AccountController(AccountDAOImpl accountDAOImpl){
        this.accountDAOImpl = accountDAOImpl;
    }

    @GetMapping("accounts/list")
    public List<Account> findAll(){
        return accountDAOImpl.findAll();
    }

    @GetMapping("accounts/listAccountsByUser")
    public List<Account> findAllAccountsByUser(int id){
        return accountDAOImpl.findAllAccountsByUser(id);
    }

    @GetMapping("accounts/{id}")
    public Account findById(int id){
        Account theAccount = accountDAOImpl.findById(id);
        return theAccount;
    }

    @PostMapping("accounts/addAccount")
    public ResponseEntity<Account> createAccount(@RequestBody Account newAccount){
        newAccount.setAccountId(0);
        accountDAOImpl.createAccount(newAccount);
        return new ResponseEntity<Account>(newAccount, HttpStatus.OK);
    }

    @DeleteMapping("accounts/delete/{id}")
    public void deleteAccountById(int id){
        Account theAccount = accountDAOImpl.findById(id);
        if(theAccount == null)
            throw new RuntimeException("Account is not found - " + id);
        accountDAOImpl.deleteAccountById(id);
    }
}