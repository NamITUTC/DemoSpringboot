package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PathologicalService {
    private Responsitorycc responsitory;

    public PathologicalService(Responsitorycc responsitory) {
        this.responsitory = responsitory;
    }

    public List<Pathological> getAll(){
        List<Pathological> pathologicals=new ArrayList<>();
        for(Pathological pathological:responsitory.findAll()){
        pathologicals.add(pathological);
        }
        return pathologicals;
    }

    public Iterable<Integer> getAll2(){
        return responsitory.findByCategory();
    }
}
