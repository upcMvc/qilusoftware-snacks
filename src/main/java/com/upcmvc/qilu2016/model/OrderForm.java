package com.upcmvc.qilu2016.model;

import jdk.Exported;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 订单
 * Created by lenovo on 2016/5/30.
 */
@Entity
public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int customerid;
    private String creattime;
    private String updatetime;
    private boolean isdelete = false;

    public OrderForm(int customerid, String creattime, String updatetime) {
        this.customerid = customerid;
        this.creattime = creattime;
        this.updatetime = updatetime;
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
}
