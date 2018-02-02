package com.example.demo.Jsoupparser;

public class Drug {
    private String title;
    private String content;
    private String link;

    public Drug(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Drug(String title, String content, String link) {
        this.title = title;
        this.content = content;
        this.link = link;
    }

    public Drug() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
