package com.example.demo.rest;


import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entity.User;
import com.example.demo.entity.UserLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"}) // For angular
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserDAOImpl userDAOImpl;

    @Autowired
    public UserController(UserDAOImpl userDAOImpl){
        this.userDAOImpl = userDAOImpl;
    }

    @GetMapping("users/list")
    public ResponseEntity<List<User>> findAll(){
    	return new ResponseEntity<List<User>>(userDAOImpl.findAll(),HttpStatus.OK);
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
    public ResponseEntity<User> createUser(@RequestBody User newUser){
        newUser.setUserId(0);
        userDAOImpl.createUser(newUser);
        return new ResponseEntity<User>(newUser,HttpStatus.OK);
    }

    @DeleteMapping("users/delete/{id}")
    public void deleteUserById(@PathVariable int id){
        User theUser = userDAOImpl.findById(id);
        if(theUser == null)
            throw new RuntimeException("User is not found - " + id);
        userDAOImpl.deleteUserById(id);
    }
    
    @PostMapping(path="/users/login")
	public ResponseEntity<User> login(@RequestBody UserLogin user){
		System.out.println("user: " + user.getUsername() + ", " + user.getPassword());
		User userResult = userDAOImpl.findByLogin(user);
		//User userResult = userRepo.findUserByLogin(user.getUsername(), user.getPassword());
		//System.out.println("result: " + userResult.getUserName() + ", " + userResult.getPassWord());
		
		if(userResult!=null) {
			return new ResponseEntity<User>(userResult,HttpStatus.OK);
		}else {
			return new ResponseEntity<User>(userResult,HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
