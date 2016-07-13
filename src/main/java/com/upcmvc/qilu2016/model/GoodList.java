package com.upcmvc.qilu2016.model;

import javax.persistence.*;
import java.util.Date;
/**
 * 订购商品清单
 * Created by lenovo on 2016/5/30.
 */
@Entity
@Table(name = "goodlist")
public class GoodList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int goodsid;
    private int orderid;
    private double price;
    private int num;
    private String name;

    private String createtime;
    private String updatetime;
    private boolean isdelete = false;


    public GoodList(int goodsid, int orderid, double price, int num, String name, String createtime, String updatetime) {
        this.goodsid = goodsid;
        this.orderid = orderid;
        this.price = price;
        this.num = num;
        this.name = name;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public GoodList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public boolean isdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(int num, double price){
        this.num = num;
        this.price = price;
        this.updatetime = new Date().toString();
    }
    public void delete(){
        this.isdelete =true;
        this.updatetime = new Date().toString();
    }
}

