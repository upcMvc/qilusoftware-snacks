package com.upcmvc.qilu2016.dao;

import com.upcmvc.qilu2016.model.GoodList;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lenovo on 2016/5/30.
 */
public interface GoodListDao extends CrudRepository<GoodList,Integer> {
    public GoodList findByGoodsid(int goodsid);
    public Iterable<GoodList> findByIspay(boolean ispay);
    public Iterable<GoodList> findAll();
    Iterable<GoodList> findByOrderidAndIsdelete(int orderid,boolean isdelete);
}
