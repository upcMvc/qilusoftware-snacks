package com.upcmvc.qilu2016;

import com.upcmvc.qilu2016.util.MailUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
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

}
