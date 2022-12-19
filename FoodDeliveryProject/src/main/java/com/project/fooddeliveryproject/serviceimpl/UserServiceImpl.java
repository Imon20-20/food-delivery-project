package com.project.fooddeliveryproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooddeliveryproject.exception.ResourceNotFoundException;
import com.project.fooddeliveryproject.model.User;
import com.project.fooddeliveryproject.repository.UserRepository;
import com.project.fooddeliveryproject.service.UserService;

 
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
private UserRepository userRepository;
	
	 public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
 
	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}
	@Override
	public User loginUser(User user) {
		
		return this.userRepository.findByEmailIdAndPassword(user.emailId,user.password).orElseThrow(()->new ResourceNotFoundException("User ", "EmailId", user.emailId+" and password "+user.password) );
	}
	

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailId(emailId).orElseThrow(()->new ResourceNotFoundException("User","EmailId",emailId));

	}

	@Override
	public void deleteUser(String emailId) {
		// TODO Auto-generated method stub
		  userRepository.findByEmailId(emailId).orElseThrow(()->new ResourceNotFoundException("User","EmailId",emailId));
		  userRepository.deleteUserByEmailId(emailId);
	}

	
}

