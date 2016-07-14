package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.dao.ShopDao;
import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.Shop;
import com.upcmvc.qilu2016.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
    根据 id 查找
     */
    @RequestMapping("/")
    public Object showGoods(int id) {
        return shopDao.findOne(id);
    }


    @RequestMapping("/213/214")
    public Object createGoods(int userid,String creattime, String title, int sellnumber, String connect, String updatetime, String master) {

        Shop shop = new Shop( userid,master,title,sellnumber,connect,creattime,updatetime);
        shopDao.save(shop);
        return new JsonMes(1, "创建店铺成功");
    }

    @RequestMapping("/hkh/ghj")
    public Object deleteGoods(@RequestParam(value = "id", defaultValue = "0") int id) {

        Shop shop = shopDao.findOne(id);
        shop.delete();
        shopDao.save(shop);
        return new JsonMes(1, "删除店铺成功");
    }

    @RequestMapping("/das/das")
    public Object update(int id, int sellnumber, String connect) {
        Shop shop = shopDao.findOne(id);
        shop.update(sellnumber, connect);
        return new JsonMes(1, "更新店铺成功");
    }

}