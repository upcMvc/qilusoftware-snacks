package com.upcmvc.qilu2016.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upcmvc.qilu2016.dao.ShopDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.Goods;
import com.upcmvc.qilu2016.dao.GoodsDao;
import com.upcmvc.qilu2016.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by 陈子枫 on 2016/7/11.
 * 个人商店
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private ShopDao shopDao;


    @RequestMapping("/create")
    public Object createGood(String price, String name, String imgurl, String detail, @RequestParam(value = "shopid", defaultValue = "0") int shopid, @RequestParam(value = "number", defaultValue = "0") int number) {
        //  System.out.println(price + imgurl + shopid);
        Goods goods = new Goods(shopid, number, price, name, imgurl, detail);
        goodsDao.save(goods);
        return new JsonMes(1, "创建成功");
    }

    @RequestMapping("/delete")
    public Object deleteGood(@RequestParam(value = "id", defaultValue = "0") int id) {
        Goods goods = goodsDao.findOne(id);
        goods.delete();
        goodsDao.save(goods);
        return new JsonMes(1, "删除成功");
    }

    @RequestMapping("/update")
    @JsonIgnore
    public Object updateGood(@RequestParam(value = "id", defaultValue = "1") int id, @RequestParam(value = "number", defaultValue = "0") int number, String price, String detail, String imgurl) {
        Goods goods = goodsDao.findOne(id);
        goods.update(number, price, detail, imgurl);
        goodsDao.save(goods);
        return new JsonMes(1, "更新成功");
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @JsonIgnore
    public Object showGoods(@RequestParam(value = "id", defaultValue = "0") int id) {

        return goodsDao.findOne(id);
    }

    @RequestMapping("/test")
    public Object test() {
        for (int i = 1; i <= 10; i++) {
            int shopid = i;
            int number = i;
            System.out.println(shopid);
            String price = "123";
            String name = "456";
            String imgurl = "wanghaojun";
            String detail = "chengzifeng";
            Goods goods = new Goods(shopid, number, price, name, imgurl, detail);
            goodsDao.save(goods);

        }
        return new JsonMes(1, "charu");
    }

}
