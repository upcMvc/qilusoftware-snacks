package com.upcmvc.qilu2016.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upcmvc.qilu2016.dao.GoodListDao;
import com.upcmvc.qilu2016.dao.GoodsDao;
import com.upcmvc.qilu2016.dao.ShopDao;
import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.dto.MailDTo;
import com.upcmvc.qilu2016.model.GoodList;
import com.upcmvc.qilu2016.model.Goods;
import com.upcmvc.qilu2016.model.Shop;
import com.upcmvc.qilu2016.model.User;
import com.upcmvc.qilu2016.util.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @JsonIgnore
    public Object show() {
        User user = (User) httpSession.getAttribute("user");
        int orderid;
        if (user == null) {

            return new JsonMes(0, "用户尚未登录");
        } else {
            orderid = user.getId();
            System.out.println("orderid is: " + orderid);
        }
        return goodListDao.findByOrderidAndIspay(orderid, false);
    }

    @RequestMapping("/putorder")
    public Object putOrder(String address) {
        int id = 0;
        int goodid = 0;
        String good = "您的商品为：";
        Iterator<GoodList> goodLists = (goodListDao.findByIspay(false)).iterator();
        System.out.println("pay");
        List<MailDTo> list = new ArrayList<>();
        // User user = (User) httpSession.getAttribute("user");
        //String phone = user.getPhone();
        while (goodLists.hasNext()) {
            GoodList goodList = goodLists.next();
            System.out.println("has next");
            if (goodList == null) break;
            System.out.println(" good list is not null");

            int goodsid = goodList.getGoodsid();
            int num = goodList.getnum();
            String name = goodList.getName();

            Goods goods = goodsDao.findOne(goodsid);
            System.out.println("good id:" + goodsid);
            int shopid = goods.getShopid();
            System.out.println("shop id:" + shopid);

            Shop shop = shopDao.findOne(shopid);
            String email = shop.getEmail();
            System.out.println("mail:" + email);
            MailDTo mailDTo = new MailDTo(name, num, email, shopid);
            list.add(mailDTo);
        }
        Collections.sort(list);
        Iterator<MailDTo> li = list.iterator();
        boolean flag = false;
        while (li.hasNext()) {

            MailDTo maildto = li.next();
            if (id == 0) {
                id = maildto.shopid;
                System.out.println("循环开始");
            } else if (maildto.shopid == id && li.hasNext() == true) {
                good = good + maildto.name + " " + maildto.number + " ";
                System.out.println("good:" + good);
            } else {
                String temgood = "";
                id = maildto.shopid;
                Iterable<GoodList> goodListes = goodListDao.findByIspay(false);
                int count = 0;
                for (GoodList goodlist : goodListes
                        ) {
                    goodlist.setIspay(true);
                    goodListDao.save(goodlist);
                    if (goodlist.getGoodsid() == goodid) {
                        count++;
//                    }else if(goodid ==0){
//                        System.out.println("开始遍历商品");
//                        goodid = goodlist.getGoodsid();
                    } else {
                        temgood = temgood + " " + goodlist.getName() + "数量为：" + goodlist.getnum()+ " ";
//                        temgood = temgood +maildto.name + " " + maildto.number + " ";
                        System.out.println("temgood: " + temgood);
                        System.out.println(count);
                        count = 0;
                    }
                }
                if (flag == false) {
                    good = "名字: " + temgood;
                    System.out.println(good);
                    flag = true;
                }
                MailUtils mail = new MailUtils();
                System.out.println("最终发送为：" + good);
                mail.send(maildto.email, good + "地址是：" + address);
                good = "您的商品为：";

            }
        }
        return new JsonMes(1, "提交成功");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @JsonIgnore
    public Object createGoodList(@RequestParam(value = "goodsid", defaultValue = "0") int goodsid, @RequestParam(value = "num", defaultValue = "0") int num
            , String name, float price) {
        User user = (User) httpSession.getAttribute("user");
        int orderid;
        if (user == null)
            return new JsonMes(-1, "您还未登录录");
        else orderid = user.getId();

        GoodList goodList = new GoodList(goodsid, orderid, num, name, price);
        goodListDao.save(goodList);
        return new JsonMes(1, "创建成功");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @JsonIgnore
    public Object delete(@RequestParam(value = "id", defaultValue = "0") int id) {
        System.out.println(id);
        GoodList goodList = goodListDao.findOne(id);
        goodList.delete();
        goodListDao.save(goodList);
        System.out.println(goodList.isdelete());
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

        return new JsonMes(1, "商品已经付款");

    }

    @RequestMapping("/test")
    public Object test() {

        for (int i = 1; i < 20; i++) {
            int goodsid;
            if (i % 2 == 0)
                goodsid = 1;
            else
                goodsid = i;
            int orderid = i;
            int num = i + 5;
            boolean ispay;
            if (i % 2 == 0)
                ispay = false;
            else
                ispay = true;
            String name = "latiao";
            float price = 3 + i;
            GoodList goodList = new GoodList(goodsid, orderid, num, name, price, ispay);
            goodListDao.save(goodList);
        }
        return new JsonMes(1, "OK");
    }
}
