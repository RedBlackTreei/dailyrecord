package onlyfun.js.dao;

import java.util.Map;

import onlyfun.js.model.User;

public interface UserDao {
	int deleteByPrimaryKey(Long id);

	int insert(User record); 

	int insertSelective(User record);

	User selectByPrimaryKey(Long id);

	User selectByUserId(String userId);

	User selectLoginUser(Map<String, String> map);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}