package onlyfun.js.test;

import static org.junit.Assert.fail;
import onlyfun.js.model.User;
import onlyfun.js.service.UserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

	private ApplicationContext context = null;
	private UserService userService = null;
	Log log = LogFactory.getLog(UserTest.class);
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml", "spring-mybatis.xml"});
		userService = (UserService)context.getBean("userService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSelectUserById() {
		User user = userService.selectByUserId("admin");
		System.out.println(user.getEmail());
	}
	
	@Test
	public void testSelectLoginUser() {
		User user = userService.selectLoginUser("admin", "admin");
		if(user != null) {
			System.out.println(user.getEmail());
			log.info("email = " + user.getEmail());
		} else {
			log.info("用户不存在");
			System.out.println("用户不存在");
		}
	}

}
