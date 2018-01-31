package com.example.demo;

import com.google.gson.Gson;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    PathologicalService pathologicalService;

  /*  @Autowired
    DiseaseService diseaseService;*/

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
    @GetMapping("/id")
    //localhost:asdf/id?id=1
    public String getData(@RequestParam("id") int id){
        Gson gson=new Gson();
        return gson.toJson(pathologicalService.getDataFromId(id));
    }
    @PostMapping("/id2")
    public  String getData2(@RequestParam("j") int id,@RequestParam("i") int title){
        Gson gson=new Gson();
        return gson.toJson(pathologicalService.getDataFromId(id));
    }
    @PutMapping("/{id3}")
    public  String get(@PathVariable("id3") int id){
//        int a=Integer.parseInt(id);
        Gson gson=new Gson();
        return gson.toJson(pathologicalService.getDataFromId(id));
    }
  /*  @GetMapping("/name")
    public String getAllID() {
        Iterable<String> list = pathologicalService.getAll2();
        Gson gson=new Gson();
        return gson.toJson(list);
    }*/

/*
    @GetMapping("/disease")
    public String getDisease() {
        Iterable<Disease> list = diseaseService.findAll();
        Gson gson = new Gson();
        return gson.toJson(list);
    }*/
}
