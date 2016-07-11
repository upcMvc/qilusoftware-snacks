package com.upcmvc.qilu2016.model;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by lenovo on 2016/5/30.
 */
public interface GoodsDao extends CrudRepository<Goods,Integer>{

    public GoodsDao findByShopid(int shopid);
}
