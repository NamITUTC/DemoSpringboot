package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PathologicalService {
    private PathologicalResponsitory responsitory;

    public PathologicalService(PathologicalResponsitory responsitory) {
        this.responsitory = responsitory;
    }

    public List<Pathological> getAll() {
        List<Pathological> pathologicals = new ArrayList<>();
        for (Pathological pathological : responsitory.findAll()) {
            pathologicals.add(pathological);
        }
        return pathologicals;
    }


    /* public Iterable<String> getAll2() {
         return responsitory.find();

     }*/
    public Pathological getDataFromId(int id) {
        return responsitory.findOne(id);

    }

}
