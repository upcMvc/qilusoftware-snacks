package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.config.Config;
import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.dto.QQClientInfo;
import com.upcmvc.qilu2016.service.LoginService;
import com.upcmvc.qilu2016.service.QQOauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


/**
 * Created by Jaxlying on 2016/7/14.
 */
@RestController
public class LoginController {

    @Autowired
    private Config config;

    @Autowired
    private QQOauthService qqOauthService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/",method = RequestMethod.GET,params = {"code","state=qq"})
    public Object dealOauth(String code) throws IOException {
        String token = qqOauthService.getToken(qqOauthService.getTokenAndRefresh(code));
        String idstr = qqOauthService.getOpenId(token);
        QQClientInfo qqClientInfo = qqOauthService.getQQclientinfo(idstr);
        if(loginService.isOurUser(qqClientInfo.openid) == true)
            return userDao.findByQqopenid(qqClientInfo.openid);
        else
            return qqOauthService.getQQInfor(token,qqClientInfo.openid);
    }

}

