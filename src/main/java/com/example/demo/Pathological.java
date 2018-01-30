package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Pathological")
@Table(name = "pathological")
public class Pathological implements Serializable{

    @Id
    @Column(name = "id")

    private int id;
    @Column(name = "title")
    private String title;
    @Column(name="detail")
    private String detail;

    public Pathological(int id, String title, String detail) {
        this.id = id;
        this.title = title;
        this.detail = detail;
    }

    public Pathological() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
