package com.sengg4.job_portal.controller;

import java.util.List;

import com.sengg4.job_portal.model.User;

import com.sengg4.job_portal.service.UserService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }
    
    //Create user
    @PostMapping(consumes={"application/json"})
    public ResponseEntity<User> saveUser(@RequestBody User user){
        System.out.println(user.getUsername());
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    //Retreive all users
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //retreive users by id
    // @GetMapping("{id}")
    // public ResponseEntity<User> getUserById(@PathVariable("id") long userId){
    //     return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
    // }

    @PostMapping(value = "/{username}")
	public User getByUsername( @PathVariable("username") String username, @RequestBody User user) {
        System.out.println("Username :" + username);
		return userService.findByUsername(user.getUsername());
	}

    //update user
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") long userId){
        return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.OK);
    }

    //delete user
    @DeleteMapping({"id"})
    public ResponseEntity<String> deleteUser(@PathVariable("id") long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<String>("User deleted successfully.!", HttpStatus.OK);
    }

}
