package com.upcmvc.qilu2016.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lenovo on 2016/5/30.
 */
@Entity
@Table(name = "goods")
@JsonIgnoreProperties(value = {"creattime", "updatetime", "delete"})
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int shopid;
    private int quantity = 1;
    private String price;
    private String name;
    private String imgurl;
    private String detail;
    private String title;


    private String creattime;
    private String updatetime;
    private boolean isdelete = false;


    public Goods(int shopid, int quantity, String price, String name, String imgurl, String detail) {
        this.shopid = shopid;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.imgurl = imgurl;
        this.detail = detail;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();
    }
    public Goods(int shopid, int quantity, String price, String name, String imgurl, String detail, String title){
        this.shopid = shopid;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.imgurl = imgurl;
        this.detail = detail;
        this.title = title;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();
    }
    public Goods(int shopid,String price,String name,String imgurl,String title){
        this.shopid = shopid;
        this.price = price;
        this.imgurl  = imgurl;
        this.name = name;
        this.title = title;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();
    }
    public Goods() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public void delete() {
        this.isdelete = true;
        this.updatetime = new Date().toString();
    }

    public void update(int number, String price, String detail, String imgurl) {
        this.quantity = number;
        this.price = price;
        this.detail = detail;
        this.imgurl = imgurl;
        this.updatetime = new Date().toString();
    }
    public void update(String imgurl){
        this.imgurl = imgurl;
        this.updatetime = new Date().toString();
    }
}
