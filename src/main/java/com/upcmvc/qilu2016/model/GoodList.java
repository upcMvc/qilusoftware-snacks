package com.upcmvc.qilu2016.model;

import javax.persistence.*;
import java.util.Date;
/**
 * 订购商品清单
 * Created by lenovo on 2016/5/30.
 */
@Entity
@Table(name = "goodlist")
public class GoodList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int goodsid;
    private int orderid;
    private int num;

    private String createtime;
    private String updatetime;
    private boolean isdelete = false;



}

