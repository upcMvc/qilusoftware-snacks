package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by 陈子枫 on 2016/7/5.
 */

public class LoginController {


    @Autowired
    LoginService loginService;
    @Autowired
    HttpSession httpSession;
   @Value("${myconfig.adminUsername}")
    private static String adminUsername;
    @Value("${myconfig.adminPassword}")
    private static String adminPassword;

   @RequestMapping("/")
    public Object login (String admin,String password){
       if(admin.equals(adminUsername)&&password.equals(adminPassword))
       {httpSession.setAttribute("admin",true);
       return new JsonMes(1,"登陆成功");
       }
       return new JsonMes(0,"用户名或密码错误");
   }
}