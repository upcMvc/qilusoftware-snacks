package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.dao.ShopDao;
import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.Shop;
import com.upcmvc.qilu2016.oauth.qq.QQOauth;
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
 */
@RestController
public class IndexController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private UserDao userDao;


    /*
    根据 title 和 maste 查找
     */
    @RequestMapping("/")
    public Object showGoods(int id) {
        return shopDao.findOne(id);
    }


//    @RequestMapping("/213/214")
//    public Object createGoods(String creattime, String title, int sellnumber, String connect, String updatetime, String master) {
//        int id =
//
//        Shop shop = new Shop(id,master, creattime, title, sellnumber, connect, updatetime);
//        shopDao.save(shop);
//        return new JsonMes(1, "创建成功");
//    }

    @RequestMapping("/hkh/ghj")
    public Object deleteGoods(@RequestParam(value = "id", defaultValue = "0") int id) {

        Shop shop = shopDao.findOne(id);
        shop.delete();
        shopDao.save(shop);
        return new JsonMes(1, "删除成功");
    }

    @RequestMapping("/das/das")
    public Object update(int id, int sellnumber, String connect) {
        Shop shop = shopDao.findById(id);
        shop.update(sellnumber, connect);
        return new JsonMes(1, "更新成功");
    }

}