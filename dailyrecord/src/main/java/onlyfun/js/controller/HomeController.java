package onlyfun.js.controller;

import javax.servlet.http.HttpServletRequest;

import onlyfun.js.model.User;
import onlyfun.js.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	Logger logger = Logger.getLogger(this.getClass());
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = {"/greeting/{userId}", "/greeting"})
	public String index(@PathVariable String userId, HttpServletRequest request) {
		User user = userService.selectByUserId(userId);
		if (user == null) {
			user = new User();
			user.setName("未知用户。");
		}
		request.setAttribute("user", user);
		return "index";
	}
}
