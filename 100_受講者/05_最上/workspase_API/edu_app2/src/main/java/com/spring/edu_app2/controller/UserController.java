package com.spring.edu_app2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.edu_app2.exception.UserNotFoundException;
import com.spring.edu_app2.model.User;
import com.spring.edu_app2.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable("userId") Long userId) {
		return userService.getUser(userId).orElseThrow(() -> new UserNotFoundException(userId));
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping("/users/{userId}")
	public void updateUser(@RequestBody User user,
			@PathVariable("userId") Long userId) {
		userService.updateUser(userId, user);
	}
	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
	}
	/*
	@GetMapping("/callHello")
	public HelloMessage callHello() {
		return userService.getHelloResponse();
	}
	*/

}
