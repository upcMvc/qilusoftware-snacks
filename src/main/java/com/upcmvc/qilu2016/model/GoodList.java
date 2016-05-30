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

    public GoodList(int goodsid, int orderid) {
        this.goodsid = goodsid;
        this.orderid = orderid;
    }

    public GoodList() {
    }
}
