package com.upcmvc.qilu2016.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by lenovo on 2016/5/30.
 */
@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int shopid;
    private int number;
    private double price;
    private String name;
    private String creattime;

    public Goods(int shopid, int number, double price, String name, String creattime) {
        this.shopid = shopid;
        this.number = number;
        this.price = price;
        this.name = name;
        this.creattime = creattime;
    }

    public Goods() {
    }
}
