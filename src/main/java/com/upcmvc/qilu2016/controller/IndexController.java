package com.upcmvc.qilu2016.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upcmvc.qilu2016.dao.ShopDao;
import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.Shop;
import com.upcmvc.qilu2016.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lenovo on 2016/5/30.
 * 主页
 */
@RestController
@RequestMapping("/shop")
public class IndexController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private UserDao userDao;


    /*
    根据 userid 查找用户信息
     */
    @RequestMapping("/show")
    @JsonIgnore
    public Object showGoods(@RequestParam(value = "userid", defaultValue = "0") int userid) {
        // User user = (User)(httpSession.getAttribute("user"));
        return shopDao.findByUserid(userid);
    }

    /*
    注册开店接口
    */
    @RequestMapping("/create")
    public Object createGoods(String master, String title, String detail, String qq) {
        User user = (User) (httpSession.getAttribute("user"));
        int userid = user.getId();
        String phone = user.getPhone();
        String imgurl = user.getImgurl();
        String email = user.getMail();
        Shop shop = new Shop(userid, master, title, detail, imgurl, phone, email, qq);
        shopDao.save(shop);
        return new JsonMes(1, "创建店铺成功");
    }

    @RequestMapping("/updata")
    @JsonIgnore
    public Object update(@RequestParam(value = "id", defaultValue = "0") int id, String master, String title, String detail) {
        Shop shop = shopDao.findOne(id);
        shop.update(master, title, detail);
        return new JsonMes(1, "更新店铺成功");
    }

}