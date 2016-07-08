package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 陈子枫 on 2016/7/5.
 */
public class LoginController {


    @Autowired
    LoginService loginService;

    @RequestMapping("/yibanauth")
    public ModelAndView auth{return loginService.toYibanAuth();}

}
