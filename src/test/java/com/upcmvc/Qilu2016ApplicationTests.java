package com.upcmvc;

import com.upcmvc.qilu2016.Qilu2016Application;
import com.upcmvc.qilu2016.dao.UserDao;
import com.upcmvc.qilu2016.model.Shop;
import com.upcmvc.qilu2016.model.User;
import com.upcmvc.qilu2016.util.MailUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Qilu2016Application.class)
@WebAppConfiguration
public class Qilu2016ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMail(){
		MailUtils mailUtils = new MailUtils();
		mailUtils.send("710801583@qq.com","cheng");
	}

	@Test
	public void update(){

	}

	@Autowired
	UserDao userDao;
	@Test
	public void creatUser(){

		User user = new User();
	}
}
