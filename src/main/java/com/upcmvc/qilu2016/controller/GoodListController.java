package com.upcmvc.qilu2016.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upcmvc.qilu2016.dao.GoodListDao;
import com.upcmvc.qilu2016.dao.GoodsDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.GoodList;
import com.upcmvc.qilu2016.model.Goods;
import com.upcmvc.qilu2016.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 陈子枫 on 2016/7/13.
 */
@RestController
@RequestMapping("/goodlist")
public class GoodListController {

    @Autowired
    private GoodListDao goodListDao;


    @RequestMapping("/show")
    @JsonIgnore
    public Object show(@RequestParam(value = "goodsid", defaultValue = "0")int goodsid) {

        return goodListDao.findByGoodsid(goodsid);
    }

    @RequestMapping("/create")
    @JsonIgnore
    public Object createGoodList(@RequestParam(value = "goodsid", defaultValue = "0")int goodsid,@RequestParam(value = "orderid", defaultValue = "0") int orderid, @RequestParam(value = "num", defaultValue = "0")int num
    ,String name,float price) {

        GoodList goodList = new GoodList(goodsid,orderid,num,name,price);
        goodListDao.save(goodList);
        return new JsonMes(1, "创建成功");
    }

    @RequestMapping("/delete")
    @JsonIgnore
    public Object delete(@RequestParam(value = "id", defaultValue = "0") int id) {
        GoodList goodList = goodListDao.findOne(id);
        goodList.delete();
        goodListDao.save(goodList);
        return new JsonMes(1, "删除成功");
    }

    @RequestMapping("/update")
    @JsonIgnore
    public Object update(@RequestParam(value = "id", defaultValue = "0")int id, @RequestParam(value = "num", defaultValue = "0")int num,String name ,float price) {
        GoodList goodList = goodListDao.findOne(id);
        goodList.update(num,name,price);
        goodListDao.save(goodList);
        return new JsonMes(1, "更新成功");
    }
    @RequestMapping("/test")
    public Object test(){

        for(int i = 1;i<10;i++)
        {
            int goodsid = i;
            int orderid = i;
            int num = i + 5;
            String name = "latiao";
            float price = 3;
            GoodList goodList = new GoodList(goodsid,orderid,num,name,price);
            goodListDao.save(goodList);
        }
        return new JsonMes(1,"OK");
    }
}
