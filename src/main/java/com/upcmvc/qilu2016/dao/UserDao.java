package com.upcmvc.qilu2016.dao;

import com.upcmvc.qilu2016.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lenovo on 2016/5/30.
 */
public interface UserDao extends CrudRepository<User,Integer> {
        User findByQqopenid(String qqopenid);
        User findTopByOrderByCreattimeDesc();
        User findByMail(String mail);
        User findByUsername(String username);
        User findByIdAndIsdelete(int id,boolean isdelete);
        User findBySelleridAndIsmaster(int sellerid,boolean ismaster);
}
