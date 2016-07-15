package com.upcmvc.qilu2016.dao;

import com.upcmvc.qilu2016.model.Shop;
import org.apache.tomcat.util.http.fileupload.MultipartStream;
import org.springframework.data.mapping.IdentifierAccessor;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

/**
 * Created by lenovo on 2016/5/30.
 */
public interface ShopDao extends CrudRepository<Shop, Integer> {
  public Shop findByUserid(int userid);

}