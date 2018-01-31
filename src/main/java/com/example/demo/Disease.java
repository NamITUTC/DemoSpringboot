package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "disease")
public class Disease implements Serializable{
    @Id
    @Column(name = "id")
    private  int idD;
    private String name;
    private String infor;
    private String idp;


    public Disease(int id, String name, String infor, String idp) {
        this.idD = id;
        this.name = name;
        this.infor = infor;
        this.idp = idp;
    }

    public Disease() {
    }

    public int getId() {
        return idD;
    }

    public void setId(int id) {
        this.idD = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public String getIdp() {
        return idp;
    }

    public void setIdp(String idp) {
        this.idp = idp;
    }
}
