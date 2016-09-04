package com.upcmvc.qilu2016.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upcmvc.qilu2016.config.Config;
import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.dto.JsonMes;
import com.upcmvc.qilu2016.model.User;
import com.upcmvc.qilu2016.util.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jaxlying on 2016/8/29.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserDao userDao;

    @Autowired
    private Config config;

    private static final double MODULUS = 2.56;//验证码计算系数

    @RequestMapping("/user_info")
    @JsonIgnore
    public Object getUserInfo(String mail){
        User user = null;
        System.out.println("查找用户");
        try {
            user = userDao.findByMail(mail);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(user.getId());
        return user;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @JsonIgnore
    public Object doLogin(String username, String password){
        User user = userDao.findByUsername(username);
        if(user == null) return  new JsonMes(-1,"用户名或密码错误");
        System.out.println("用户登录");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(password,user.getPassword())){
            httpSession.setAttribute("user",user);
            return new JsonMes(1,"登录成功");
        }else {
            return new JsonMes(-1,"用户名或密码错误");
        }
    }


    /**
     * 验证邮件回执处理
     */
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public Object validate(String name, Double validateCode, Date sendDate) throws UnsupportedEncodingException {
        System.out.println("用户名 is " + name);
        Date currentDate = new Date();
        long timeSpan = currentDate.getTime() - sendDate.getTime();
        if (name.length() * MODULUS != validateCode) {
            return "非法的验证邮件";
        } else if ((timeSpan / 1000 / 60 / 60) > 48) {
            return "验证邮件失效，请重新验证";
        } else {
            User user = userDao.findByUsername(name);
            System.out.println(user.getUsername());
            if (user != null) {
                user.setStatus(1);
                userDao.save(user);
                return new JsonMes(1,"验证成功");
            } else {
                return new JsonMes(-1,"验证失败  没有此用户 请重新注册");
            }
        }

    }

    /**
     * 注册
     */
    @RequestMapping(value = "/create")
    @ResponseBody
    public Map<String, Object> create(String name, String mail, String password,String phone){
        System.out.println("name: " + name + "mail " + mail + "password " + password + "phone" + phone);
        User user = null;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Map<String, Object> userInfo = new HashMap<>();
        if (userDao.findByUsername(name) == null&&userDao.findByMail(mail) == null) {
            try {
                user = new User(name, mail, phone,"标识构造函数",passwordEncoder.encode(password));
                userDao.save(user);
                userInfo.put("result", "注册成功");
                userInfo.put("id", user.getId());
                userInfo.put("username", user.getUsername());
                userInfo.put("avatar", user.getImgurl());
                userInfo.put("password", user.getPassword());
                userInfo.put("mail", user.getMail());
                userInfo.put("phone", user.getPhone());

                httpSession.setAttribute("user",user);

                ///邮件的内容
                StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时有效，否则重新注册账号，链接只能使用一次，请尽快激活 ！</br>");
                sb.append("<a href=\"" + config.serveraddress +"/user/validate?&name=");
                sb.append(name);
                sb.append("&validateCode=");
                Double validateCode = name.length() * MODULUS;
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("\">" + config.serveraddress + "/validate?&mail=");
                sb.append(name);
                sb.append("&validateCode=");
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("</a>");

                //发送邮件
                MailUtils.send(mail, sb.toString());
                System.out.println("发送邮件");
                return userInfo;
            } catch (Exception ex) {
                ex.printStackTrace();
                userInfo.put("result", "注册失败");
                return userInfo;
            }
        } else {
            userInfo.put("result", "用户名或邮箱已存在");
            return userInfo;
        }

    }


    /**
     * 发送重置密码邮件
     */
    @RequestMapping(value = "/reset_mail")
    public Object reset(String mail) {
        System.out.println("mail " + mail);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (userDao.findByMail(mail) != null) {
            try {

                ///邮件的内容
                StringBuffer sb = new StringBuffer("点击下面链接进行密码重置，48小时内生效，链接只能使用一次，请尽快重置！</br>");
                sb.append("<a href=\"" + config.serveraddress +"/reset_pager?&mail=");
                sb.append(mail);
                sb.append("&validateCode=");
                Double validateCode = mail.length() * MODULUS;
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("\">" + config.serveraddress + "/reset_pager?&mail=");
                sb.append(mail);
                sb.append("&validateCode=");
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("</a>");

                //发送邮件
                MailUtils.send(mail, sb.toString());
                System.out.println("发送邮件");
                return new JsonMes(1,"重置密码邮件发送成功");
            } catch (Exception ex) {
                ex.printStackTrace();
                return new JsonMes(-1,"未知错误");
            }
        } else {
            return new JsonMes(-1,"未知错误");
        }

    }
}
