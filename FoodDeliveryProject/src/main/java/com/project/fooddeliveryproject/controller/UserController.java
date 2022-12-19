package com.project.fooddeliveryproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooddeliveryproject.model.User;
import com.project.fooddeliveryproject.service.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController //is controller which provides different end points to access the services 

@RequestMapping("/api/user")
public class UserController {
	
	
		@Autowired
		private UserService userService;

		public UserController(UserService userService) {
			super();
			this.userService = userService;
		}
	//Register
		@PostMapping("/register")
		public ResponseEntity<User> saveUser(@Valid @RequestBody  User user)
		{
			
			return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
		}
	//Login
		@PostMapping("/login")
		public  ResponseEntity<User> loginUser( @RequestBody User user)
		{
		 	return new ResponseEntity<User>(userService.loginUser(user),HttpStatus.OK);
			
		}
		@GetMapping
		public List<User> getUser() 
		{
			return userService.getUser();
		}
		
		 @GetMapping("{emailId}")
		public ResponseEntity<User> getUserByEmailID(@PathVariable("emailId") String emailId)
		{
			return new ResponseEntity<User>(userService.getUserByEmailId(emailId),HttpStatus.OK); 
		}
		 @DeleteMapping("{emailId}")
		public ResponseEntity<String> deleteUser(@PathVariable("emailId") String emailId)
		{
			userService.deleteUser(emailId);
			return new ResponseEntity<String>("User deleted successfully",HttpStatus.OK);
		}
}
