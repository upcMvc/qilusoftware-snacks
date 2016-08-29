package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.model.User;
import com.upcmvc.qilu2016.util.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jaxlying on 2016/8/29.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserDao userDao;

    private static final double MODULUS = 2.56;//验证码计算系数

    @RequestMapping("/user_info")
    public User getUserInfo(String mail){
        User user = null;
        try {
            user = userDao.findByMail(mail);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String doLogin(String username, String password){
        User user = userDao.findByMail(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(password,user.getPassword())){
            httpSession.setAttribute("user",user);
            return "success";
        }else {
            return "failed";
        }
    }


    /**
     * 验证邮件回执处理
     */
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    @ResponseBody
    public String validate(String name, Double validateCode, Date sendDate) throws UnsupportedEncodingException {
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
                return "验证成功";
            } else {
                return "验证失败  没有此用户 请重新注册";
            }
        }

    }

    /**
     * 注册
     */
    @RequestMapping(value = "/create")
    @ResponseBody
    public Map<String, Object> create(String name, String mail, String password) {
        System.out.println("name: " + name + "mail " + mail + "password " + password);
        User user = null;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Map<String, Object> userInfo = new HashMap<>();
        if (userDao.findByUsername(name) == null) {
            try {
                user = new User(name, mail, passwordEncoder.encode(password));
                userDao.save(user);
                userInfo.put("result", "注册成功");
                userInfo.put("id", user.getId());
                userInfo.put("username", user.getUsername());
                userInfo.put("avatar", user.getImgurl());
                userInfo.put("password", user.getPassword());
                userInfo.put("mail", user.getMail());

                httpSession.setAttribute("user",user);

                ///邮件的内容
                StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时有效，否则重新注册账号，链接只能使用一次，请尽快激活 ！</br>");
                sb.append("<a href=\"http://localhost:8080/user/validate?&name=");
                sb.append(name);
                sb.append("&validateCode=");
                Double validateCode = name.length() * MODULUS;
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("\">http://localhost:8080/validate?&mail=");
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
            userInfo.put("result", "用户已存在");
            return userInfo;
        }

    }


    /**
     * 发送重置密码邮件
     */
    @RequestMapping(value = "/reset_mail",method = RequestMethod.POST)
    @ResponseBody
    public boolean create(String mail) {
        System.out.println("mail " + mail);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (userDao.findByMail(mail) != null) {
            try {

                ///邮件的内容
                StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
                sb.append("<a href=\"http://localhost:8080/reset_pager?&mail=");
                sb.append(mail);
                sb.append("&validateCode=");
                Double validateCode = mail.length() * MODULUS;
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("\">http://localhost:8080/reset_pager?&mail=");
                sb.append(mail);
                sb.append("&validateCode=");
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("</a>");

                //发送邮件
                MailUtils.send(mail, sb.toString());
                System.out.println("发送邮件");
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            return false;
        }

    }
}
