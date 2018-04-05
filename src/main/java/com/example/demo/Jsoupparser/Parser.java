package com.example.demo.Jsoupparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private String link;
    private Document document;

    public Parser(String l) {
        this.link = l;
        try {
            document = Jsoup.connect(l).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Drug> getData1() {
        ArrayList<Drug> drugs = new ArrayList<>();
        Elements elementColor = document.select("h2.color-red");
        Elements elementsNew = document.select("div.des-news");
        for (int i = 0; i < elementColor.size(); i++) {
            String title = elementColor.get(i).select("a").text();
            String link="https://www.dieutri.vn" +elementColor.get(i).select("a").attr("href");
            String content = elementsNew.get(i).text();
            Drug drug = new Drug(title, content,link);
            drugs.add(drug);
        }
        return drugs;
    }

    public ArrayList<Drug> getData2() {
        ArrayList<Drug> drugs = new ArrayList<>();
        Elements elementItemNew = document.select("div.item-news");
        Elements elementColor = document.select("h2.color-red");
        for (int i = 0; i < elementItemNew.size(); i++) {
            Element element = elementItemNew.get(i);
           String link = "https://www.dieutri.vn" + elementColor.get(i).select("a").attr("href");
            String title=elementColor.get(i).select("a").text();
            String content = element.select("p").text();
            Drug drug = new Drug(title, content,link);
            drugs.add(drug);
        }
        return drugs;
    }
    public  ArrayList<HealthTip> getHealthy(){
        ArrayList<HealthTip> healthTips=new ArrayList<>();
        Elements elementsBox=document.select("div.bp-entry");
        for (int i=0;i<elementsBox.size();i++){
            Element element=elementsBox.get(i);
            String title=element.select("a").get(0).text();
            String linkDetail=element.select("a").get(0).attr("href");
            String image=element.select("img").attr("src");
            String content=element.select("p").text();
            HealthTip healthTip=new HealthTip(title,content,image,linkDetail);
            healthTips.add(healthTip);
        }
        return healthTips;
    }
}
