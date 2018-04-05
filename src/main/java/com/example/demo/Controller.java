package com.example.demo;

import com.example.demo.Jsoupparser.Drug;
import com.example.demo.Jsoupparser.HealthTip;
import com.example.demo.Jsoupparser.Parser;
import com.google.gson.Gson;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller implements InitializingBean {

    @Autowired
    PathologicalService pathologicalService;
    ArrayList<Drug> drugs = new ArrayList<>();
    ArrayList<Drug> drugs2 = new ArrayList<>();
    ArrayList<HealthTip> healthTips = new ArrayList<>();

  /*  @Autowired
    DiseaseService diseaseService;*/

    @RequestMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/get")
    public String getAll() {
        List<Pathological> list = pathologicalService.getAll();

        Gson gson = new Gson();
        System.out.println(gson.toJson(list));
        return gson.toJson(list);
    }

    /*@PostMapping("/post")
    public String getData2(@RequestParam("j") int id, @RequestParam("i") int title) {
        Gson gson = new Gson();
        return gson.toJson(pathologicalService.getDataFromId(id));
    }
*/

    @PostMapping("/post")
    public String addData(@RequestBody Pathological pathological) {
        System.out.println("DATA POST : (" + pathological.getId() + "," + pathological.getTitle() + "," + pathological.getDetail() + ")");
        Gson gson = new Gson();
        System.out.println(pathologicalService.addPathological(pathological));
        return gson.toJson(pathologicalService.addPathological(pathological));
    }

    @PutMapping("/put/{id}")
    public String update(@PathVariable("id") int id, @RequestBody Pathological pathological) {
        System.out.println("ID PUT : " + id + "");
        Gson gson = new Gson();
        System.out.println(pathologicalService.updatePathological(id, pathological));
        return gson.toJson(pathologicalService.updatePathological(id, pathological));
    }

    @DeleteMapping("/delete/{id}")
    public String deletePathological(@PathVariable("id") int id) {
        System.out.println("ID DELETE : " + id + "");
        System.out.println(pathologicalService.deletePathological(id));
        return pathologicalService.deletePathological(id);
    }

    @RequestMapping("/drugs")
    public String getAllDrugs() {
        Gson gson = new Gson();
        return gson.toJson(drugs);
    }

    @PostMapping("/drug2")
    public String getDrug2(@RequestParam("link") String link) {
        Parser pathologicalParser2 = new Parser(link);
        drugs2 = pathologicalParser2.getData2();
        Gson gson = new Gson();
        return gson.toJson(drugs2);
    }

    @GetMapping("/healthTips")
    public String getHealthTips() {
        System.out.println(healthTips.size());
        Gson gson = new Gson();
        return gson.toJson(healthTips);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Parser pathologicalParser = new Parser("https://www.dieutri.vn/benhly");
        drugs = pathologicalParser.getData1();

        Parser healthTipParser = new Parser("https://ameovat.com/cate/suc-khoe-doi-song");
        healthTips = healthTipParser.getHealthy();
    }

}
