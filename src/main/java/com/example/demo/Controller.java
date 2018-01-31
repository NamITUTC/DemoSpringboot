package com.example.demo;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    PathologicalService pathologicalService;

    @Autowired
    DiseaseService diseaseService;

    @RequestMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/pathological")
    public String getAll() {
        List<Pathological> list = pathologicalService.getAll();
        Gson gson = new Gson();
        return gson.toJson(list);
    }
/*
    @GetMapping("/name")
    public String getAllID() {
        Iterable<String> list = pathologicalService.getAll2();
        Gson gson=new Gson();
        return gson.toJson(list);
    }*/


    @GetMapping("/disease")
    public String getDisease() {
        Iterable<Disease> list = diseaseService.findAll();
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
