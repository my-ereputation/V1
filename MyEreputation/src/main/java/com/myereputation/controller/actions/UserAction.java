package com.myereputation.controller.actions;

import org.apache.log4j.Logger;

import com.myereputation.manager.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 7645213596801356778L;
	private static Logger logger = Logger.getLogger(UserAction.class);
	
	private UserManager userManager = new UserManager();
	
}
