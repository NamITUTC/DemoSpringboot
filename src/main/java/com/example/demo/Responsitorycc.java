package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface Responsitorycc extends CrudRepository<Pathological, Integer> {

    @Query( "select p.id from Pathological p")
    List<Integer> findByCategory();
    
    @Query("select p.id from Pathological p join Disease d")
    Iterable<Integer> find();
}
