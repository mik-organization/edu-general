package com.spring.edu_app2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.edu_app2.model.User;
import com.spring.edu_app2.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//DBから全てのユーザ情報を取得してリストで返す
	public List<User> getAllUsers(){
		List<User> allUsers = new ArrayList<>(); 
		userRepository.findAll().forEach(allUsers::add);	//findAll()で全て検索
		
		return allUsers;
	}
	
	public Optional<User> getUser(long userId) {
		
		return userRepository.findById(userId);
	}

	public void addUser(User user){
		userRepository.save(user);
	}
	
	
	public void updateUser(Long userId,User user) {
		if(userRepository.findById(userId).get() != null){
			userRepository.save(user);
		}
	}
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
	
	
}
