package com.upcmvc.qilu2016.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Jaxlying on 2016/7/12.
 */

@Component
public class Config {

    @Value("${qqoauth.appid}")
    public String appid ;

    @Value("${qqoauth.appkey}")
    public String appkey;

    @Value("${qqoauth.redirect}")
    public String redirect_url;

    @Value("${qqoauth.state}")
    public String state ;

}
