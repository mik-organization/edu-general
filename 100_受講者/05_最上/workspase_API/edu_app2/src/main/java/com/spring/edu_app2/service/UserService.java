package com.spring.edu_app2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;

import com.spring.edu_app2.model.User;
import com.spring.edu_app2.repo.UserRepository;

@Service
@EnableJpaAuditing
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//DBから全てのユーザ情報を取得してリストで返す
	@Cacheable("getUsers")
	public List<User> getAllUsers(){
		List<User> allUsers = new ArrayList<>(); 
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		userRepository.findAll().forEach(allUsers::add);	//findAll()で全て検索
		
		return allUsers;
	}
	
	@Cacheable(value="getUser",key="#p0")
	public Optional<User> getUser(long userId) {
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return userRepository.findById(userId);
	}
	
	@CacheEvict(value="getUsers",allEntries=true)
	public void addUser(User user){
		userRepository.save(user);
	}
	
	@Caching(evict= {
			@CacheEvict(value="getUser",key="#p0"),
			@CacheEvict(value="getUsers",allEntries=true)
	})
	public void updateUser(Long userId,User user) {
		if(userRepository.findById(userId).get() != null){
			userRepository.save(user);
		}
	}
	
	@Caching(evict= {
			@CacheEvict(value="getUser",key="#p0"),
			@CacheEvict(value="getUsers",allEntries=true)
	})
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
	
	
}
