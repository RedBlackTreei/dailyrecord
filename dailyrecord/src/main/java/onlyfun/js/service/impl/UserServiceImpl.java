package onlyfun.js.service.impl;

import java.util.HashMap;
import java.util.Map;

import onlyfun.js.dao.UserDao;
import onlyfun.js.model.User;
import onlyfun.js.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User selectByUserId(String userId) {
		return userDao.selectByUserId(userId);
	}

	@Override
	public User selectLoginUser(String userId, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("password", password);
		User user = userDao.selectLoginUser(map);
		return user;
	}
}
