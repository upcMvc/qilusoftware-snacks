package com.upcmvc.qilu2016.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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
    private String url;

    private String creattime;
    private String updatetime;
    private boolean isdelete = false;


    public Goods(int shopid, int number, double price, String name, String url, String creattime, String updatetime) {
        this.shopid = shopid;
        this.number = number;
        this.price = price;
        this.name = name;
        this.url = url;
        this.creattime = creattime;
        this.updatetime = updatetime;
    }

    public Goods(int number, double price, String name, String creattime, String updatetime) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public boolean isdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void delete(){
        this.isdelete = true;
        this.updatetime = new Date().toString();
    }

    public void update(int number,double price){


    }

}
