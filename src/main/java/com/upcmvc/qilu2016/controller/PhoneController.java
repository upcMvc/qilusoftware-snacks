package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.dao.GoodsDao;
import com.upcmvc.qilu2016.dao.ShopDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.Goods;
import com.upcmvc.qilu2016.model.Shop;
import com.upcmvc.qilu2016.model.User;
import com.upcmvc.qilu2016.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.AssociationOverride;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 陈子枫 on 2016/9/13.
 */
@Controller
public class PhoneController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    ShopDao shopDao;
    @Autowired
    GoodsDao goodsDao;
    /*
   上传商品照片的接口
   */
    @RequestMapping(value = "/phone",method = RequestMethod.POST)
    public String createGood(MultipartFile file, String price, String name ) throws IOException {
        User user =(User) httpSession.getAttribute("user");
        if (user !=null){
            String imgurl = fileUploadService.handleFileUpload(file);
            int id = user.getId();
            System.out.println("userid: " + id);
            Shop shop =shopDao.findByUserid(id);
            String title = shop.getTitle();
            int shopid = shop.getId();
            System.out.println(title + " " + shopid);
            Goods goods = new Goods(shopid,price, name, imgurl,title);
            goodsDao.save(goods);
            return "redirect:http://qilu.y1code.cn/#/myadmin";

        }else {
            String code ="-1";
            return code;
        }

    }


}
