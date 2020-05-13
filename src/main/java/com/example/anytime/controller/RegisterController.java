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
public class RegisterController {

    @Autowired
    private UserService userService;
    private User user;

    @GetMapping("/test1")
    public List<User> usernameCheck(@RequestBody User user) {
        return (List<User>) userService.findByUsername(user.getUsername());
    }

    @PostMapping("/register")
    //password and username check
    public ResponseEntity<?> notBlank(@RequestBody User user) {
        if (!usernameCheck(user).isEmpty()){
            return new ResponseEntity<Message>(new Message("username already taken"), HttpStatus.BAD_REQUEST);}
        if (user.getUsername().equals("") || user.getPassword().equals("")) {
            return new ResponseEntity<Message>(new Message("not saved, no valid entries"), HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        }
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/register/{iduser}")
    public void delete(@PathVariable int iduser) {
        userService.deleteById(iduser);
    }

    @GetMapping("/register")
    public List<User> findAll() {
        return (List<User>) userService.findAllOrderedById(user);
    }

    @GetMapping("/register/{id}")
    public Optional<User> userById(@PathVariable  int iduser) {
        return userService.findById(iduser);
    }




}
