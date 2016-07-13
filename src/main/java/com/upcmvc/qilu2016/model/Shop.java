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

    private String master;//店主
    private String title;//店名
    private int sellnumber;
    private String connect;//详细介绍

    private String creattime;
    private String updatetime;
    private boolean isdelete = false;


    public Shop(String master, String creattime, String title, int sellnumber, String connect, String updatetime) {
        this.master = master;
        this.creattime = creattime;
        this.title = title;
        this.sellnumber = sellnumber;
        this.connect = connect;
        this.updatetime = updatetime;
    }
    public Shop(){}//空的构造函数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSellnumber() {
        return sellnumber;
    }

    public void setSellnumber(int sellnumber) {
        this.sellnumber = sellnumber;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public boolean isdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public void update(int sellnumber,String connect)
    {
        this.sellnumber = sellnumber;
        this.updatetime = new Date().toString();
        this.connect = connect;
    }
    public void delete(){
        this.updatetime = new Date().toString();
        this.isdelete = true;
    }
}
