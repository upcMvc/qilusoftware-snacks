package com.upcmvc.qilu2016.model;

import org.apache.tomcat.util.http.fileupload.MultipartStream;
import org.springframework.data.mapping.IdentifierAccessor;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

/**
 * Created by lenovo on 2016/5/30.
 */
public interface ShopDao extends CrudRepository<Shop,Integer> {
public Iterable<Shop> findByTitleOrMaster(String title,String master);
public Iterable<Shop> findByIsdeleteByIdDesc(boolean isdelete);

}