package com.upcmvc.qilu2016.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by lenovo on 2016/5/30.
 */
@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String creattime;
    private String title;
    private int sellnumber;
    private String connect;

    public Shop(String creattime, String title, int sellnumber, String connect) {
        this.creattime = creattime;
        this.title = title;
        this.sellnumber = sellnumber;
        this.connect = connect;
    }

    public Shop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSellnumber() {
        return sellnumber;
    }

    public void setSellnumber(int sellnumber) {
        this.sellnumber = sellnumber;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }
}
