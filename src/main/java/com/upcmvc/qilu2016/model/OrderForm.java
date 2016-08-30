package com.upcmvc.qilu2016.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.Exported;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 订单
 * Created by lenovo on 2016/5/30.
 */
@Entity
@JsonIgnoreProperties(value = {"creattime" ,"updatetime","delete"})
public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int customerid;

    private String creattime;
    private String updatetime;
    private boolean isdelete = false;

    public OrderForm(int customerid) {
        this.customerid = customerid;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();
    }

    public OrderForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
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

    public void delete() {
        this.isdelete = true;
        this.updatetime = new Date().toString();
    }
}
