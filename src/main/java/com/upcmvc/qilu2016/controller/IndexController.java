package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lenovo on 2016/5/30.
 */
@Controller
public class IndexController {

    @RequestMapping({"/"})
    public String showIndex(){
        return "reg";
    }
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String regUser(String username, String password) {

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        return "success";

    }
}
