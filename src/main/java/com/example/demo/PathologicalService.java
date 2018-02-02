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

    public Pathological updatePathological(int id, Pathological pathological) {
        Pathological pathological1 = responsitory.findOne(id);
        pathological1.setDetail(pathological.getDetail());
        pathological1.setTitle(pathological.getTitle());
        responsitory.save(pathological1);
        return pathological1;

    }

    public String deletePathological(int id) {
        if(responsitory.findOne(id)!=null){
            responsitory.delete(id);

            return "done";
        }
        return "delete fail";
    }

    public String addPathological(Pathological pathological) {
        responsitory.save(pathological);
        return "done";
    }
}
