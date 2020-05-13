package com.example.anytime.service;

import com.example.anytime.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserService extends CrudRepository<User, Integer> {

        @Query("SELECT u FROM User u ORDER BY iduser")
        List<User> findAllOrderedById(User user);

        //search by username and password
        @Query("select u from User u where u.username = :username and u.password= :password")
        Iterable<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

        //search by username
        @Query("select u from User u where u.username = :username")
        Iterable<User> findByUsername(@Param("username") String username);

}
