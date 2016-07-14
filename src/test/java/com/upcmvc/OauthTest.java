package com.upcmvc;

import com.upcmvc.qilu2016.Qilu2016Application;
import com.upcmvc.qilu2016.oauth.qq.QQOauth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Qilu2016Application.class)
@WebAppConfiguration

/**
 * Created by Jaxlying on 2016/7/14.
 */
public class OauthTest {


    @Test
    public void getAcess(){

    }

    @Test
    public void testOauth() throws IOException {
    }
}
