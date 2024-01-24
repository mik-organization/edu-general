package com.spring.edu_app2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.spring.edu_app2.model.Task;
import com.spring.edu_app2.repo.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	//DBから全てのタスク情報を取得してリストで返す
	@Cacheable("getTasks")
	public List<Task> getAllTasks(){
		List<Task> allTasks = new ArrayList<>(); 
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		taskRepository.findAll().forEach(allTasks::add);	//findAll()で全て検索
		
		return allTasks;
	}
	
	@Cacheable(value="getTask",key="#p0")
	public Optional<Task> getTask(long taskId) {
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return taskRepository.findById(taskId);
	}
	
	@CacheEvict(value="getTasks",allEntries=true)
	public void addTask(Task task){
		taskRepository.save(task);
	}
	
	@Caching(evict= {
			@CacheEvict(value="getTask",key="#p0"),
			@CacheEvict(value="getTasks",allEntries=true)
	})
	public void updateTask(Long taskId,Task task) {
		if(taskRepository.findById(taskId).get() != null){
			taskRepository.save(task);
		}
	}
	
	@Caching(evict= {
			@CacheEvict(value="getTask",key="#p0"),
			@CacheEvict(value="getTasks",allEntries=true)
	})
	public void deleteTask(Long taskId) {
		taskRepository.deleteById(taskId);
	}
	
	
}
