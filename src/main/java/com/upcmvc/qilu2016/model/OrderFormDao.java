package com.upcmvc.qilu2016.model;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by lenovo on 2016/5/30.
 */
public interface OrderFormDao extends CrudRepository<OrderForm,Integer> {
    public OrderForm findByCustomerid(String customerid);

}
