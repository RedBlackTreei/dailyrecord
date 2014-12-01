package onlyfun.js.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import onlyfun.js.model.User;
import onlyfun.js.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	Logger logger = Logger.getLogger(UserController.class);
	private UserService userService;

	@RequestMapping("/greeting/{userId}")
	public String index(@PathVariable String userId, HttpServletRequest request) {
		User user = userService.selectByUserId(userId);
		if (user == null) {
			user = new User();
			user.setName("未知用户。");
		}
		request.setAttribute("user", user);
		return "index";
	}

	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(@ModelAttribute("user") User user) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(Model model, @Validated User user, BindingResult result) {
		if(result.hasErrors()) {
			return "login";
		}
		user = userService.selectLoginUser(user.getUserId(), user.getPassword());
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping("/users")
	public String list(Model model) {
		List<User> users = userService.getAll();
		for (User user : users) {
			logger.info("name = " + user.getName());
		}
		model.addAttribute("users", users);
		return "/user/list";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "/user/add";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(@ModelAttribute User user, BindingResult result) {
		userService.addUser(user);
		return "redirect:/user/users";
	}

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}