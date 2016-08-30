package com.upcmvc.qilu2016.controller;

import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by Explorer on 2016/5/1.
 */
@Controller
public class ResetPwdController {
    private static final double MODULUS = 2.56;//验证码计算系数

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/reset_pager", method = RequestMethod.GET)
    public String ResetPager(HttpServletRequest request, String mail, Double validateCode, Date sendDate) {
        Date currentDate = new Date();
        long timeSpan = currentDate.getTime() - sendDate.getTime();
        if (mail.length() * MODULUS != validateCode) {
            return "非法的验证邮件";
        } else if ((timeSpan / 1000 / 60 / 60) > 24) {
            return "验证邮件失效，请重新验证";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("mail", mail);
            return "changepassword";
        }
    }

    /**
     * 密码重置页面回执处理
     */
    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String resetPassword(HttpServletRequest request, String psw) throws UnsupportedEncodingException {
        String mail = (String)request.getSession().getAttribute("mail");
        User user = userDao.findByMail(mail);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(psw));
        userDao.save(user);
        return "passwordchangesuccess";
    }
}
