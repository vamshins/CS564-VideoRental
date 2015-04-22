package edu.unm.cs564.movierental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unm.cs564.movierental.dao.UserDao;
import edu.unm.cs564.movierental.service.exception.ServiceException;
import edu.unm.cs564.movierental.service.support.dto.User;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> queryForAll() {
		List<User> userList = userDao.queryForAll();
		return userList;
	}

	@Override
	public boolean save(User user) {
		if (userDao.save(user) != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		if (userDao.update(user) != 0)
			return true;
		return false;
	}

	@Override
	public boolean checkEmail(String email) throws ServiceException {
		boolean checkEmail;
		try {
			checkEmail = userDao.checkEmail(email);
		} catch (Exception e) {
			//Throwing exception indicates the user exists with this email
			throw new ServiceException("Couldn't retrieve user with email "
					+ email);
		}
		return checkEmail;
	}

}
