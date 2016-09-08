package com.upcmvc.qilu2016.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.upcmvc.qilu2016.util.MailUtils;

import javax.persistence.*;
import java.util.Date;
/**
 * 订购商品清单
 * Created by lenovo on 2016/5/30.
 */
@Entity
@JsonIgnoreProperties(value = {"creattime" ,"updatetime","delete"})
@Table(name = "goodlist")
public class GoodList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int goodsid;
    private int orderid;
    private int num;
    private String name;
    private float price;
    private boolean ispay = false;

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

    public GoodList(int goodsid, int orderid, int num, String name, float price) {
        this.goodsid = goodsid;
        this.orderid = orderid;
        this.num = num;
        this.name = name;
        this.price = price;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();
    }
    public GoodList(int goodsid, int orderid, int num, String name, float price,boolean ispay){
        this.goodsid = goodsid;
        this.orderid = orderid;
        this.num = num;
        this.name = name;
        this.price = price;
        this.ispay = ispay;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();
    }
    public GoodList(int goodsid,int orderid,int num,String name ,boolean ispay){
        this.goodsid = goodsid;
        this.orderid = orderid;
        this.num = num;
        this.name = name;
        this.ispay = ispay;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();
    }

    public GoodList(){}
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean ispay() {
        return ispay;
    }

    public void setIspay(boolean ispay) {
        this.ispay = ispay;
    }

    public void delete(){
        this.isdelete = true;
        this.updatetime = new Date().toString();
    }
    public  void update(int num) {
        this.num = num;
        this.updatetime = new Date().toString();
    }

    public  void update(int num,String name,float price){
        this.num = num;
        this.name = name;
        this.price = price;
        this.updatetime = new Date().toString();
    }

    public boolean ispay(boolean ispay){
        ispay = true;
        return ispay;
    }

    public void sendmail(String email,String good){
        MailUtils mailUtils = new MailUtils();
        mailUtils.send(email,good);
    }
}

