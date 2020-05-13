package com.example.anytime.model;

import javax.persistence.*;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int iduser;

    String username;
    String password;

    public User() {}

    public User(int iduser, String username, String password) {
        this.iduser = iduser;
        this.username = username;
        this.password = password;
    }


    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "[id: " + iduser + "username: "+ username + "password: " + password + "]";
    }
}

