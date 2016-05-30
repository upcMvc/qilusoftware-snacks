package com.upcmvc.qilu2016.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by lenovo on 2016/5/30.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int id;

    private String username;
    private String password;
    private String creattime;
    private boolean status;
    private int sellerid;

    public User(String password, String username, String creattime, boolean status, int sellerid) {
        this.password = password;
        this.username = username;
        this.creattime = creattime;
        this.status = status;
        this.sellerid = sellerid;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCreattime() {
        return creattime;
    }

    public boolean isStatus() {
        return status;
    }

    public int getSellerid() {
        return sellerid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }
}
