package com.upcmvc.qilu2016.service;

import com.google.gson.Gson;
import com.upcmvc.qilu2016.GsonTemplate.VerifyUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 陈子枫 on 2016/7/5.
 */
@Service
public class LoginService {

    @Autowired
    private HttpSession httpSession;
    @Autowired
    private GetRealMessage getRealMessage;
    @Value("${myconfig.client_id}")
    private static String client_id;

    public boolean procssAuthReal() throws IOException{
        String access_taoken = (String) httpSession.getAttribute("access_token");
        String message = getRealMessage.getMessage(access_taoken,"verify_me");
        return saveRealSession(message);
    }
    /**
     * 保存学校验证信息的session
     * @param message
     * @return
     */
    private boolean saveRealSession(String message) {
        Gson gson = new Gson();
        try {
            VerifyUserInfo verifyUserInfo = gson.fromJson(message,VerifyUserInfo.class);
             if(verifyUserInfo.status.equals("success")){
                 httpSession.setAttribute("realname",verifyUserInfo.info.yb_realname);
                 httpSession.setAttribute("studentid",verifyUserInfo.info.yb_schoolid);
                 return true;
             }else {
                 return false;
             }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}

