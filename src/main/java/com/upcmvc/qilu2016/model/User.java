package com.upcmvc.qilu2016.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Random;

/**
 * Created by lenovo on 2016/5/30.
 */
@Entity
@JsonIgnoreProperties(value = {"password","creattime","updatetime","delete"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String qqopenid;

    private String username;
    private String password;
    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    private int status = 0;//是否为激活状态

    private boolean ismaster;
    private int sellerid;
    private String phone;
    private String imgurl;

    private String creattime;
    private String updatetime;
    private boolean isdelete = false;

    public User() {
    } //空的构造函数

    public User(String username,String mail,String password){
        this.imgurl = "http://mvc.y1code.cn:8080/file/" + (int) ( 10 * Math.random());;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();
    }

    public User(String username,String mail,String phone,String flag,String password){
        Random random = new Random();
        this.imgurl = "http://mvc.y1code.cn:8080/file/" + random.nextInt(9);
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();
    }

    public User(String qqopenid, String username, String phone, String imgurl) {
        this.qqopenid = qqopenid;
        this.username = username;
        this.phone = phone;
        this.imgurl = imgurl;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQqopenid() {
        return qqopenid;
    }

    public void setQqopenid(String qqopenid) {
        this.qqopenid = qqopenid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean ismaster() {
        return ismaster;
    }

    public void setIsmaster(boolean ismaster) {
        this.ismaster = ismaster;
    }

    public int getSellerid() {
        return sellerid;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean getIsmaster(){return this.ismaster;}

}

