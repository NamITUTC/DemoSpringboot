package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PathologicalResponsitory extends CrudRepository<Pathological, Integer> {

/*
    @Query("select p.id from Pathological p")
    Iterable<Integer> findByCategory();
*/


  /*  @Query("select d.name from Pathological p join p.disease d  on p.id=d.idp")
    Iterable<String> find();*/

}
