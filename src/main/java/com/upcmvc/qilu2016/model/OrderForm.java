package com.upcmvc.qilu2016.model;

import jdk.Exported;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *订单
 * Created by lenovo on 2016/5/30.
 */
@Entity
public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int customerid;
    private String creattime;

    public OrderForm(int customerid, String creattime) {
        this.customerid = customerid;
        this.creattime = creattime;
    }

    public OrderForm() {
    }
}
