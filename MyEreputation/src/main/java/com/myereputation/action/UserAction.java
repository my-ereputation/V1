package com.myereputation.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.myereputation.bean.UserBean;
import com.myereputation.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<UserBean> {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(UserAction.class);
	
	@Autowired
	private UserBean userBean;
	@Autowired
	private UserService userService;
	private String message;
	
	public UserBean getModel() {
		return userBean;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute(){
		setMessage("Number of users recorded :" + getSizeUsers());
		logger.debug(getMessage());
		return "success";
	}
	
	public int getSizeUsers(){
		int nb = 0;
		nb = userService.getAllUsers().size();
		logger.debug("size user list"+nb);
		return nb;
	}
}
