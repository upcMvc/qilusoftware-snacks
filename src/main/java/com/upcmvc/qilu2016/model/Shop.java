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
}
