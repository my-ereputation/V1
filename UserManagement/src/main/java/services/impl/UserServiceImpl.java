package services.impl;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.UserService;
import utils.AbstractDaoImpl;

@SuppressWarnings("serial")
@Service("userService")
@Transactional
public class UserServiceImpl extends AbstractDaoImpl<User, Integer> implements UserService {

	private UserService userService;
	
	@Autowired	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User createUser(User user) {
		return userService.insert(user);
	}

	public User readUser(int idUser) {
		return userService.find(idUser);
	}

	public User updateUser(int idUser, User user) {
		return userService.update(user);
	}

	public void deleteUser(User user) {
		userService.delete(user);
	}

}
