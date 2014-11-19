package onlyfun.js.controller;

import onlyfun.js.model.User;
import onlyfun.js.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
//	private UserService userService;
//	
//	@RequestMapping("/greeting")
//	public String greeting(@RequestParam(value="name", defaultValue = "World")String name, Model model) {
//		User user = userService.selectLoginUser("admin", "admin");
//		model.addAttribute(user);
//		return "hello";
//	}
//
//	public UserService getUserService() {
//		return userService;
//	}
//
//	@Autowired
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
}
