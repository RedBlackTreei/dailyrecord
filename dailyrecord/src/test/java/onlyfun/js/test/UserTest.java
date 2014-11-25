package onlyfun.js.test;

import onlyfun.js.model.User;
import onlyfun.js.service.UserService;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml",
		"classpath:conf/spring-mybatis.xml"})
public class UserTest {
	private static final Logger logger = Logger.getLogger(UserTest.class);
	private UserService userService = null;

	@Test
	public void testSelectUserById() {
		User user = userService.selectByUserId("admin");
		logger.info(user.getEmail());
	}

	@Test
	public void testSelectLoginUser() {
		User user = userService.selectLoginUser("admin", "admin");
		if (user != null) {
			logger.info(user.getEmail());
		} else {
			logger.info("用户不存在");
		}
	}

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
