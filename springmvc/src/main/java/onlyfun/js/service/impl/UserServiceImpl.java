package onlyfun.js.service.impl;

import java.util.HashMap;
import java.util.Map;

import onlyfun.js.dao.UserMapper;
import onlyfun.js.model.User;
import onlyfun.js.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;

	@Override
	public User selectByUserId(String userId) {
		return userMapper.selectByUserId(userId);
	}

	@Override
	public User selectLoginUser(String userId, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("password", password);
		User user = userMapper.selectLoginUser(map);
		return user;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
}
