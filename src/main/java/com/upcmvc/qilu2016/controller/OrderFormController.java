package com.upcmvc.qilu2016.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upcmvc.qilu2016.dao.OrderFormDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 陈子枫 on 2016/7/16.
 */
@RestController
@RequestMapping("/order")
public class OrderFormController {
    @Autowired
    private OrderFormDao orderFormDao;

    @RequestMapping("/show")
    public Object showOrderForm(@RequestParam(value = "customerid", defaultValue = "0")int customerid)
    {
        return orderFormDao.findByCustomerid(customerid);
    }
    @RequestMapping("/create")
    @JsonIgnore
    public Object createOrderForm(@RequestParam(value = "customerid", defaultValue = "0")int customerid)
    {
        OrderForm orderForm = new OrderForm(customerid);
        orderFormDao.save(orderForm);
        return new JsonMes(1,"创建订单成功");
    }
}
