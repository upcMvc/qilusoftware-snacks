package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.config.Config;
import com.upcmvc.qilu2016.dto.QQInfo;
import com.upcmvc.qilu2016.oauth.qq.QQOauth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Jaxlying on 2016/7/14.
 */
@RestController
public class LoginController {

    @Autowired
    private Config config;

    @Autowired
    private QQOauth qqOauth;

    private static final String gettokenurl = "https://graph.qq.com/oauth2.0/token";

    @RequestMapping(value = "/",method = RequestMethod.GET,params = "code")
    public String dealOauth(String code) throws IOException {
        String token = qqOauth.getToken(qqOauth.getTokenAndRefresh(code));
        String idstr = qqOauth.getOpenId(token);
        QQInfo qqInfo = qqOauth.getQQinfo(idstr);
        return "success";
    }

}

