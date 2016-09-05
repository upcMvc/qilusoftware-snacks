package com.upcmvc;

import com.upcmvc.qilu2016.Qilu2016Application;
import com.upcmvc.qilu2016.dao.GoodsDao;
import com.upcmvc.qilu2016.dao.OrderFormDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.Goods;
import com.upcmvc.qilu2016.model.OrderForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/test")
    public Object goodtest() {
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
