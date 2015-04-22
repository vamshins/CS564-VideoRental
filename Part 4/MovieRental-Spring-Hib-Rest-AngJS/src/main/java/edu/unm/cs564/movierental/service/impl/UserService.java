package edu.unm.cs564.movierental.service.impl;

import java.util.List;

import edu.unm.cs564.movierental.service.exception.ServiceException;
import edu.unm.cs564.movierental.service.support.dto.User;

public interface UserService {

	boolean save(User users);

	List<User> queryForAll();

	boolean update(User users);

	boolean checkEmail(String email) throws ServiceException;

}
