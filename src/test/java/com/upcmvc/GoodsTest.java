package com.upcmvc;

import com.upcmvc.qilu2016.Qilu2016Application;
import com.upcmvc.qilu2016.dao.GoodsDao;
import com.upcmvc.qilu2016.dao.OrderFormDao;
import com.upcmvc.qilu2016.model.Goods;
import com.upcmvc.qilu2016.model.OrderForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by 陈子枫 on 2016/7/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Qilu2016Application.class)
@WebAppConfiguration
public class GoodsTest {

    @Autowired
    GoodsDao goodsDao;
    @Autowired
    OrderFormDao orderFormDao;

    @Test
    public void goods(){
//        Goods goods = new Goods(1,2,"3","4","5","6");
//        Goods goods = new Goods();
//        goodsDao.save(goods);
        OrderForm orderForm = new OrderForm();
        orderFormDao.save(orderForm);

    }
}
