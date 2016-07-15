package com.upcmvc.qilu2016.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jaxlying on 2016/7/15.
 */
@RestController
public class RegistController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/regist",params = "state=qq")
    @JsonIgnore
    public Object regist(String nickname,String figureurl_qq_1,String openid,String phone){
        User user = new User(openid,nickname,phone,figureurl_qq_1);
        userDao.save(user);
        return userDao.findTopByOrderByCreattimeDesc();
    }
}
