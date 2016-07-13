package com.upcmvc.qilu2016.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 订购商品清单
 * Created by lenovo on 2016/5/30.
 */
@Entity
public class GoodList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int goodsid;
    private int orderid;

    private String createtime;
    private String updatetime;
    private boolean isdelete = false;


    public GoodList(int goodsid, int orderid,String createtime,String updatetime) {
        this.goodsid = goodsid;
        this.orderid = orderid;
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
}
