package com.upcmvc.qilu2016.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
/**
 * 订购商品清单
 * Created by lenovo on 2016/5/30.
 */
@Entity
@JsonIgnoreProperties(value = {"creattime" ,"updatetime","isdelete"})
@Table(name = "goodlist")
public class GoodList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int goodsid;
    private int orderid;
    private int num;

    private String creattime;
    private String updatetime;
    private boolean isdelete = false;

    public GoodList(int goodsid, int orderid, int num) {
        this.goodsid = goodsid;
        this.orderid = orderid;
        this.num = num;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public void delete(){
        this.isdelete = true;
        this.updatetime = new Date().toString();
    }
    public  void update(int num) {
        this.num = num;
        this.updatetime = new Date().toString();
    }
}

