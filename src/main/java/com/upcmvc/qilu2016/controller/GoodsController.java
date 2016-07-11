package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.Goods;
import com.upcmvc.qilu2016.model.GoodsDao;
import com.upcmvc.qilu2016.model.OrderFormDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 陈子枫 on 2016/7/11.
 */
public class GoodsController {

    @Autowired
    GoodsDao goodsDao;

    @RequestMapping
    public Object createGood( int number, double price, String name, String creattime,String updatetime){
        Goods goods =new Goods(number,price,name,creattime,updatetime);
        goodsDao.save(goods);
        return new JsonMes(1,"创建成功");
    }

    @RequestMapping
    public Object showGoods(){

        return 0;
    }
}
