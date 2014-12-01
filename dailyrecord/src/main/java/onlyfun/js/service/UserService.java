package onlyfun.js.service;

import java.util.List;

import onlyfun.js.model.User;

public interface UserService {
	public List<User> getAll();
	public User selectByUserId(String userId);
	public User selectLoginUser(String userId, String password);
	public void addUser(User user);
}
