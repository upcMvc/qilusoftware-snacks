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
    private boolean status;
    private int sellerid;
    private String url;

    private String creattime;
    private String updatetime;
    private boolean isdelete = false;


    public User(String username, String password, boolean status, int sellerid, String url, String creattime, String updatetime) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.sellerid = sellerid;
        this.url = url;
        this.creattime = creattime;
        this.updatetime = updatetime;
    }

    public User() {
    } //空的构造函数

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

    public boolean isdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
