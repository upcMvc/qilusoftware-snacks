package com.upcmvc.qilu2016.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lenovo on 2016/5/30.
 */
@Entity
@Table(name = "shopship")
@JsonIgnoreProperties(value = {"creattime" ,"updatetime","delete"})
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int userid;//和user绑定，来确定user的信息
    private String master;//店主
    private String title;//店名
    private String detail;//详细介绍
    private String imgsrc;
    private String phone;
    private String email;
    private String qq;

    private String creattime;
    private String updatetime;
    private boolean isdelete = false;

    public Shop(){
    }

    public Shop(int userid, String master, String title, String detail, String imgsrc, String phone, String email, String qq) {
        this.userid = userid;
        this.master = master;
        this.title = title;
        this.detail = detail;
        this.imgsrc = imgsrc;
        this.email = email;
        this.phone = phone;
        this.qq = qq;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getimgsrc() {
        return imgsrc;
    }

    public void setimgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getqq() {
        return qq;
    }

    public void setqq(String qq) {
        this.qq = qq;
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

    public void update(String master, String title, String detail){
        this.master = master;
        this.title = title;
        this.detail = detail;
        this.updatetime = new Date().toString();
    }
}
