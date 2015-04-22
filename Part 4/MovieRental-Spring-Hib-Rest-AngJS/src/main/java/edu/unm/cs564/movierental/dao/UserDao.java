package edu.unm.cs564.movierental.dao;

import java.util.List;

import edu.unm.cs564.movierental.service.support.dto.User;

public interface UserDao {

	int save(User users);

	List<User> queryForAll();

	int update(User users);

	boolean checkEmail(String email);

	User getUserDetail(String email);

}
