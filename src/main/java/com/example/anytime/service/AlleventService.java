package com.example.anytime.service;

import com.example.anytime.model.Allevent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlleventService extends CrudRepository<Allevent, Integer> {


    @Query("SELECT a FROM Allevent a ORDER BY eventdate")
    List<Allevent> findAllOrderedByDate(Allevent allevent);

    @Query("select a from Allevent a where a.eventname = :eventname")
    Iterable<Allevent> findByEventname(@Param("eventname") String eventname);

}
