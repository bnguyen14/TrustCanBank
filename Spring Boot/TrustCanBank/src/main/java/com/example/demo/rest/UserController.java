package com.example.demo.rest;


import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"}) // For angular
@RestController
public class UserController {

    private final UserDAOImpl userDAOImpl;

    @Autowired
    public UserController(UserDAOImpl userDAOImpl){
        this.userDAOImpl = userDAOImpl;
    }

    @GetMapping("users/list")
    public List<User> findAll(){
        return userDAOImpl.findAll();
    }

    @GetMapping("users/{id}")
    public User findById(int id){
        User myUser = userDAOImpl.findById(id);
        return myUser;
    }

    @GetMapping("users/username/{username}")
    public List<User> findByName(@PathVariable("username") String username){
        List<User> users = userDAOImpl.findByName(username);
        return users;
    }

    @PostMapping("users/addUser")
    public User createUser(@RequestBody User newUser){
        newUser.setUserId(0);
        userDAOImpl.createUser(newUser);
        return newUser;
    }

    @DeleteMapping("users/delete/{id}")
    public void deleteUserById(@PathVariable int id){
        User theUser = userDAOImpl.findById(id);
        if(theUser == null)
            throw new RuntimeException("User is not found - " + id);
        userDAOImpl.deleteUserById(id);
    }
}
