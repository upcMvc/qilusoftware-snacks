package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.Shop;
import com.upcmvc.qilu2016.model.ShopDao;
import com.upcmvc.qilu2016.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2016/5/30.
 */
@RestController
public class IndexController {

    @Autowired
    HttpSession httpSession;

    @Autowired
    ShopDao shopDao;

   /*
   根据 title 和 maste 查找
    */
    @RequestMapping("/")
    public Object showGoods(String title,String master) {

        return shopDao.findByTitleOrMaster(title,master);

    }
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public Object createGoods(String creattime, String title, int sellnumber, String connect,String updatetime,String master) {

        Shop shop = new Shop(creattime,title,sellnumber,connect,updatetime,master);
        shopDao.save(shop);
        return new JsonMes(1,"创建成功");
    }
    @RequestMapping
    public Object deleteGoods(@RequestParam(value = "id",defaultValue = "0")int id ){

        Shop shop = shopDao.findOne(id);
        shop.delete();
        shopDao.save(shop);
        return new JsonMes(1,"删除成功");
    }
    @RequestMapping
    public Object update(String title,String master,int sellnum,String connect){
        Shop shop = (Shop) shopDao.findByTitleOrMaster(title,master);
        shop.update(sellnum,connect);
        return new JsonMes(1,"更新成功");
    }

}
