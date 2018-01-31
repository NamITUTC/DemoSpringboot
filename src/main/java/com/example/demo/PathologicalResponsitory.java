package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface PathologicalResponsitory extends JpaRepository<Pathological, Integer> {

 /*   @Query("select p.id from Pathological p")
    Iterable<Integer> findByCategory();
*/
//, p.disease d where p.id=d.id
   /* @Query("select p.title from Pathological p ")
    Iterable<String> find();*/

}
