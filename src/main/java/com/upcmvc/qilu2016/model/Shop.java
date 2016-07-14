package com.upcmvc.qilu2016.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by lenovo on 2016/5/30.
 */
@Entity
@Table(name = "shopship")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int userid;//和user绑定，来确定user的信息
    private String master;//店主
    private String title;//店名
    private String detail;//详细介绍

    private String creattime;
    private String updatetime;
    private boolean isdelete = false;

    public Shop(){
    }

    public Shop(int userid, String master, String title, String detail) {
        this.userid = userid;
        this.master = master;
        this.title = title;
        this.detail = detail;
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
}
