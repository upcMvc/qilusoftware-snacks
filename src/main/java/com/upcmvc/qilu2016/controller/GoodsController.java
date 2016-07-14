package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.Goods;
import com.upcmvc.qilu2016.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 陈子枫 on 2016/7/11.
 */
@RestController
public class GoodsController {

    @Autowired
    GoodsDao goodsDao;

//    @RequestMapping("/")
//    public Object createGood( int number, double price, String name, String creattime,String updatetime){
//        Goods goods =new Goods(number,price,name,creattime,updatetime);
//        goodsDao.save(goods);
//        return new JsonMes(1,"创建成功");
//    }

    @RequestMapping("/dsa5")
    public Object deleteGood(int shopid,String name){
       Goods goods = (Goods) goodsDao.findByShopidAndName(shopid,name);
        goods.delete();
        goodsDao.save(goods);
        return new JsonMes(1,"删除成功" );
    }

    @RequestMapping("/568")
    public Object updateGood(int shopid,String name,double price){
        Goods goods = (Goods)goodsDao.findByShopidAndName(shopid,name);
        goods.update(shopid,price);
        goodsDao.save(goods);
        return new JsonMes(1,"更新成功");
    }

    @RequestMapping("/497")
    public Object showGoods(int id,String name){

        return goodsDao.findByShopidAndName(id,name);
    }
}
