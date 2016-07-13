package com.upcmvc.qilu2016.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Jaxlying on 2016/7/12.
 */

@Component
public class Config {

    @Value("${mail.host}")
    public String host;

    @Value("${mail.protocol}")
    public String protocol;

    @Value("${mail.port}")
    public int port;

    @Value("${mail.form}")
    public String from;

    @Value("${mail.password}")
    public String password;

}
