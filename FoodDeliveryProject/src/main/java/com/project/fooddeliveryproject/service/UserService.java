package com.project.fooddeliveryproject.service;

import java.util.List;

import com.project.fooddeliveryproject.model.User;

public interface UserService {

	User saveUser(User user);
	User loginUser(User user);
	List<User> getUser();
	 User getUserByEmailId(String emailId);
	 void deleteUser(String emailId);
	
}
