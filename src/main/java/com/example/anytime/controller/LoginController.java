package com.example.anytime.controller;

import com.example.anytime.model.Message;
import com.example.anytime.model.User;
import com.example.anytime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

    @Autowired  private UserService userService;
    User user;

    @GetMapping("/test")
    public List<User> Login(@RequestBody User user) {
        return (List<User>) userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<?> validationMethod(@RequestBody User user) {
        List<User> currentUser = Login(user);
        if (currentUser.isEmpty()){
            return new ResponseEntity<Message>(new Message("not valid"), HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<User>(currentUser.get(0), HttpStatus.OK);
        }
    }


    @GetMapping("/login/{id}")
    public Optional<User> userById(@PathVariable  int id) {
        return null;
    }



}

