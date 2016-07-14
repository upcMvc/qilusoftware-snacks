package com.upcmvc.qilu2016.oauth.qq;

import com.google.gson.Gson;
import com.upcmvc.qilu2016.config.Config;
import com.upcmvc.qilu2016.dto.QQInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Jaxlying on 2016/7/14.
 */
@Service
public class QQOauth {

    private static final String grant_type = "authorization_code";
    private static final String gettokenurl = "https://graph.qq.com/oauth2.0/token";

    private static final String response_type = "code";
    private static final String oauth2url = "https://graph.qq.com/oauth2.0/authorize";

    @Autowired
    private Config config;


    public String getTokenAndRefresh(String code) throws IOException {
        String encodeurl = URLEncoder.encode(config.redirect_url);
        String charset = "UTF-8";
        String sendurl = gettokenurl + "?grant_type=authorization_code&client_id=" + config.appid +"&client_secret=" + config.appkey + "&code=" +code + "&redirect_uri=" + encodeurl ;
        URLConnection connection = new URL(sendurl).openConnection();
        connection.setRequestProperty("Accept-Charset",charset);
        InputStream response = connection.getInputStream();
        StringBuilder sb=new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(response));
        String read;
        while((read=br.readLine()) != null) {
            sb.append(read);
        }
        br.close();
        return sb.toString();
    }

    public String getToken(String str){
        return str.substring(str.indexOf("access_token=") + "access_token=".length(),str.indexOf("&expires_in="));
    }

    public String getOpenId(String token) throws IOException {
        String idurl = "https://graph.qq.com/oauth2.0/me?access_token=" + token;
        String charset = "UTF-8";
        URLConnection connection = new URL(idurl).openConnection();
        connection.setRequestProperty("Accept-Charset",charset);
        InputStream response = connection.getInputStream();
        StringBuilder sb=new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(response));
        String read;
        while((read=br.readLine()) != null) {
            sb.append(read);
        }
        br.close();
        System.out.println(sb.toString());
        return sb.toString();

    }

    public QQInfo getQQinfo(String message){
        String str = message.substring(message.indexOf("callback( ") + "callback( ".length(),message.indexOf(" )"));
        Gson gson = new Gson();
        System.out.println(str);
        return gson.fromJson(str,QQInfo.class);

    }


}
