package com.upcmvc.qilu2016.dto;

/**
 * Created by 陈子枫 on 2016/9/8.
 */
public class MailDTo implements Comparable<MailDTo>{

    public String name;
    public int number;
    public String email;
    public int shopid;

    public MailDTo(String name, int number, String email, int shopid) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.shopid = shopid;
    }
    public MailDTo(){}

    @Override
    public int compareTo(MailDTo o) {
        return this.shopid - o.shopid;
    }
}
