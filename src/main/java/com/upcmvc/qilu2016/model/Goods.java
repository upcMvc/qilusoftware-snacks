package com.upcmvc.qilu2016.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by lenovo on 2016/5/30.
 */
@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int shopid;
    private int number;
    private String price;
    private String name;
    private String imgurl;
    private String describe;

    private String creattime;
    private String updatetime;
    private boolean isdelete = false;


    public void delete(){
        this.isdelete = true;
        this.updatetime = new Date().toString();
    }

    public void update(int number, String price, String describe,String imgurl){

    }

}
