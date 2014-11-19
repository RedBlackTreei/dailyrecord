package onlyfun.js.service;

import onlyfun.js.model.User;

public interface UserService {
	public User selectByUserId(String userId);
	public User selectLoginUser(String userId, String password);
}
