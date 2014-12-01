package onlyfun.js.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import onlyfun.js.dao.UserDao;
import onlyfun.js.model.User;
import onlyfun.js.service.UserService;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public List<User> getAll() {
		List<User> users = userDao.selectAllUser();
		if(CollectionUtils.isEmpty(users)) {
			return Collections.emptyList();
		}
		return users;
	}
	
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
		if(user == null) {
			user = new User();
		}
		return user;
	}
	
	public void addUser(User user) {
		userDao.insert(user);
	}
}
