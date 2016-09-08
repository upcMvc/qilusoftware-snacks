package com.upcmvc.qilu2016.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upcmvc.qilu2016.dao.GoodListDao;
import com.upcmvc.qilu2016.dao.GoodsDao;
import com.upcmvc.qilu2016.dao.ShopDao;
import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.GoodList;
import com.upcmvc.qilu2016.model.Goods;
import com.upcmvc.qilu2016.model.Shop;
import com.upcmvc.qilu2016.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Iterator;

/**
 * Created by 陈子枫 on 2016/7/13.
 * 购物车
 */
@RestController
@RequestMapping("/goodlist")
public class GoodListController {

    @Autowired
    private GoodListDao goodListDao;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private UserDao userDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private ShopDao shopDao;

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @JsonIgnore
    public Object show(String address) {
//        int goodsid = 0;
//        int orderid = 0;
//        int num =0;
//        String name = null;
//        boolean ispay = false;
//        GoodList goodList = new GoodList(goodsid,orderid,num,nge,ispay);
        Iterator<GoodList> goodLists = ((Iterable<GoodList>)goodListDao.findByIspay(false)).iterator();
        System.out.println("pay");
        while(goodLists.hasNext())
        {
            GoodList goodList = goodLists.next();
            System.out.println("has next");
            if(goodList == null) break;
            System.out.println(" good list is not null");
            int goodsid =goodList.getGoodsid();
            int num = goodList.getNum();
            String name = goodList.getName();
            Goods goods = (Goods)goodsDao.findOne(goodsid);
            System.out.println("good id:" + goodsid);
            int shopid =goods.getShopid();
            System.out.println("shop id:" + shopid);
            Shop shop =(Shop)shopDao.findOne(shopid);
            String email = shop.getEmail();
            System.out.println("mail:" + email);
            String good = name +" " + num + " " + address;
            goodList.sendmail("704734862@qq.com",good);
        }

        return goodListDao.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @JsonIgnore
    public Object createGoodList(@RequestParam(value = "goodsid", defaultValue = "0") int goodsid, @RequestParam(value = "num", defaultValue = "0") int num
            , String name, float price) {
        User user = (User) httpSession.getAttribute("user");
        int orderid = user.getId();
        GoodList goodList = new GoodList(goodsid, orderid, num, name, price);
        goodListDao.save(goodList);
        return new JsonMes(1, "创建成功");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @JsonIgnore
    public Object delete(@RequestParam(value = "id", defaultValue = "0") int id) {
        GoodList goodList = goodListDao.findOne(id);
        goodList.delete();
        goodListDao.save(goodList);
        return new JsonMes(1, "删除成功");
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @JsonIgnore
    public Object update(@RequestParam(value = "id", defaultValue = "0") int id, @RequestParam(value = "num", defaultValue = "0") int num, String name, float price) {
        GoodList goodList = goodListDao.findOne(id);
        goodList.update(num, name, price);
        goodListDao.save(goodList);
        return new JsonMes(1, "更新成功");
    }

    @RequestMapping("/ispay")
    public Object ispay() {
           GoodList goodList =(GoodList) goodListDao.findByIspay(false);
            goodList.ispay();
            goodListDao.save(goodList);
            return new JsonMes(1, "商品已经付款");

    }

    @RequestMapping("/test")
    public Object test() {

        for (int i = 1; i < 10; i++) {
            int goodsid = i;
            int orderid = i;
            int num = i + 5;
            boolean ispay;
            if(i%2 ==0)
              ispay = false;
            else
                 ispay = true;
            String name = "latiao";
            float price = 3;
            GoodList goodList = new GoodList(goodsid, orderid, num, name, price,ispay);
            goodListDao.save(goodList);
        }
        return new JsonMes(1, "OK");
    }
}
