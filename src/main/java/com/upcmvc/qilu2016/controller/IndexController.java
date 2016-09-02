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
    public Object showGoods() {
        // User user = (User)(httpSession.getAttribute("user"));
        return shopDao.findAll();
    }

    /*
    注册开店接口
    */
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public Object createGoods( String title, String phone ,String email, String qq,String detail ) {
        User user = (User) (httpSession.getAttribute("user"));
        if(user==null)
        {
            return new JsonMes(0,"用户尚未登录");
        }
        String master = user.getUsername();
        int userid = user.getId();
        String imgurl = user.getImgurl();
//        String master = "zfl";
//        int userid =5;
//        String imgurl = "dasf";
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

    @RequestMapping("/test")
    public Object test(){
        for(int i =0;i<10;i++)
        {
            int userid =i;
            String master = "casdasd";
            String title = "dasda";
            String detail = "dsadf";
            String imgsrc = "G:/桌面背景/2.jpg";
            String phone = "663264";
            String email = "dwtqeq@qq.com";
            String qq = "4465233232";
            Shop shop = new Shop(userid, master, title, detail, imgsrc, phone, email, qq);
            shopDao.save(shop);
        }

        return new JsonMes(1,"OK");
    }
}