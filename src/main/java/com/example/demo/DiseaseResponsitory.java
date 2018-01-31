package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface DiseaseResponsitory extends CrudRepository<Disease,Integer> {
}
