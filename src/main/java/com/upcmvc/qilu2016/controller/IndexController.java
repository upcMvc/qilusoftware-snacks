package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.dao.ShopDao;
import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.Shop;
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
@RequestMapping("/123")
public class IndexController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private UserDao userDao;


    /*
    根据 id 查找
     */
    @RequestMapping("/")
    public Object showGoods(int userid) {
        return shopDao.findByUserid(userid);
    }


    @RequestMapping("/213")
    public Object createGoods(int userid, String master, String title, String detail, String imgurl) {

        Shop shop = new Shop(userid,master,title,detail,imgurl);
        shopDao.save(shop);
        return new JsonMes(1, "创建店铺成功");
    }

    @RequestMapping("/das")
    public Object update(int id,String master,String title,String detail) {
        Shop shop = shopDao.findOne(id);
        shop.update(master,title,detail);
        return new JsonMes(1, "更新店铺成功");
    }

}