package com.upcmvc.qilu2016.dto;

/**
 * Created by Jaxlying on 2016/7/15.
 */
public class QQInfo extends QQBasicinfo {
    public String openid;
    public QQInfo(QQBasicinfo qqBasicinfo,String openid){
        this.openid = openid;
        this.ret = qqBasicinfo.ret;
        this.msg = qqBasicinfo.msg;
        this.is_lost = qqBasicinfo.is_lost;
        this.nickname = qqBasicinfo.nickname;
        this.gender = qqBasicinfo.gender;
        this.province = qqBasicinfo.province;
        this.city = qqBasicinfo.city;
        this.year = qqBasicinfo.year;
        this.figureurl = qqBasicinfo.figureurl;
        this.figureurl_1 = qqBasicinfo.figureurl_1;
        this.figureurl_2 = qqBasicinfo.figureurl_2;
        this.figureurl_qq_1 = qqBasicinfo.figureurl_qq_1;
        this.figureurl_qq_2 = qqBasicinfo.figureurl_qq_2;
        this.is_yellow_vip = qqBasicinfo.is_yellow_vip;
        this.vip = qqBasicinfo.vip;
        this.yellow_vip_level = qqBasicinfo.yellow_vip_level;
        this.level = qqBasicinfo.level;
        this.is_yellow_year_vip = qqBasicinfo.is_yellow_year_vip;

    }
}
