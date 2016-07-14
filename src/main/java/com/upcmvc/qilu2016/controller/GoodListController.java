package com.upcmvc.qilu2016.controller;

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
public class GoodListController {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private GoodListDao goodListDao;


    @RequestMapping("/lju")
    public Object show(@RequestParam(value = "id", defaultValue = "0")int id) {

        return goodListDao.findOne(id);
    }

    @RequestMapping("/456")
    public Object createGoodList(int goodsid, int orderid, double price, int num, String name, String createtime, String updatetime) {

        GoodList goodList = new GoodList(goodsid, orderid, price, num, name,createtime, updatetime);
        goodListDao.save(goodList);
        return new JsonMes(1, "创建成功");
    }

    @RequestMapping("/789")
    public Object delete(@RequestParam(value = "id", defaultValue = "0") int id) {
        GoodList goodList = goodListDao.findOne(id);
        goodList.delete();
        goodListDao.save(goodList);
        return new JsonMes(1, "删除成功");
    }

    @RequestMapping("/123")
    public Object update(@RequestParam(value = "id", defaultValue = "0")int id, int num, double price) {
        GoodList goodList = goodListDao.findOne(id);
        goodList.update(num, price);
        goodListDao.save(goodList);
        return new JsonMes(1, "更新成功");
    }

}
