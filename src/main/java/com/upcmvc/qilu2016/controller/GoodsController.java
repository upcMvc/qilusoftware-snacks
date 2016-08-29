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
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private ShopDao shopDao;


    @RequestMapping("/create")
    @JsonIgnore
    public Object createGood(int shopid, int number, String price, String name, String imgurl, String describe) {
        Goods goods = new Goods(shopid, number, price, name, imgurl, describe);
        goodsDao.save(goods);
        return new JsonMes(1, "创建成功");
    }

    @RequestMapping("/delete")
    @JsonIgnore
    public Object deleteGood(@RequestParam(value = "id", defaultValue = "0") int id) {
        Goods goods = goodsDao.findOne(id);
        goods.delete();
        goodsDao.save(goods);
        return new JsonMes(1, "删除成功");
    }

    @RequestMapping("/update")
    @JsonIgnore
    public Object updateGood(int id, int number, String price, String describe, String imgurl) {
        Goods goods = goodsDao.findOne(id);
        goods.update(number, price, describe, imgurl);
        goodsDao.save(goods);
        return new JsonMes(1, "更新成功");
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @JsonIgnore
    public Object showGoods(int id) {

        return goodsDao.findOne(id);
    }

    @RequestMapping("/test")
    public Object test(){
        for (int i=1;i<=10;i++)
        {
            int shopid = i;
            int number = i;
            System.out.println(shopid);
            String price = "123";
            String name = "456";
            String imgurl ="htchengzifeng";
            String describe = "chengzifengshigesb";
            Goods goods = new Goods(shopid,number,price,name,imgurl,describe);
            goodsDao.save(goods);

        }
        return new JsonMes(1, "charu");
    }


}
