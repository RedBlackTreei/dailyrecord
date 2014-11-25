package onlyfun.js.controller;

import javax.servlet.http.HttpServletRequest;

import onlyfun.js.model.User;
import onlyfun.js.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@RequestMapping("/greeting/{userId}")
	public String index(@PathVariable String userId, HttpServletRequest request) {
		User user = userService.selectByUserId(userId);
		if(user == null) {
			user = new User();
			user.setName("未知用户。");
		}
		request.setAttribute("user", user);
		return "index";
	}

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}