package com.upcmvc.qilu2016.service;

import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jaxlying on 2016/7/14.
 */
@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    /**
     * 已经注册显示信息
     * 未注册提示
     */
    public Object qqlogin(String openid){
        User user = userDao.findByQqopenid(openid);
        if(user == null){
            return new JsonMes(-1,"未注册用户");
        }else{
            return user;
        }
    }

    public boolean isOurUser(String openid){
        User user = userDao.findByQqopenid(openid);
        if(user == null){
            return false;
        }else{
            return true;
        }
    }
}
