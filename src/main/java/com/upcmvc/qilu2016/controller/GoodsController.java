package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.dao.ShopDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.Goods;
import com.upcmvc.qilu2016.dao.GoodsDao;
import com.upcmvc.qilu2016.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 陈子枫 on 2016/7/11.
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private ShopDao shopDao;


    @RequestMapping("/cgh")
    public Object createGood(int number, double price, String name, String creattime, String updatetime) {
        Goods goods = new Goods(number, price, name, creattime, updatetime);
        goodsDao.save(goods);
        return new JsonMes(1, "创建成功");
    }

    @RequestMapping("/vff")
    public Object deleteGood(@RequestParam(value = "id", defaultValue = "0") int id) {
        Goods goods = goodsDao.findOne(id);
        goods.delete();
        goodsDao.save(goods);
        return new JsonMes(1, "删除成功");
    }

    @RequestMapping("/fds")
    public Object updateGood(int shopid, String name, double price,String describe) {
        Goods goods = (Goods) goodsDao.findByShopidAndName(shopid, name);
        goods.update(shopid, price,describe);
        goodsDao.save(goods);
        return new JsonMes(1, "更新成功");
    }

    @RequestMapping("/dqw")
    public Object showGoods(int id ){

        return goodsDao.findOne(id);
    }
}
