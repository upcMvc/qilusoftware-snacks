package com.upcmvc.qilu2016.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by lenovo on 2016/5/30.
 */
//店主的类
@Entity
public class ShopKeeper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String creattime;
    private String name;
    private int shopid;

    public ShopKeeper(String creattime, String name, int shopid) {
        this.creattime = creattime;
        this.name = name;
        this.shopid = shopid;
    }

    public ShopKeeper() {
    }
}
