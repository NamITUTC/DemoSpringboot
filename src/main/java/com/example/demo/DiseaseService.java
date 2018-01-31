package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class DiseaseService {

    private DiseaseResponsitory diseaseResponsitory;

    public DiseaseService(DiseaseResponsitory diseaseResponsitory) {
        this.diseaseResponsitory = diseaseResponsitory;
    }

    public Iterable<Disease> findAll() {
        return diseaseResponsitory.findAll();
    }
}
