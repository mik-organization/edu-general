package com.spring.edu_app2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.edu_app2.model.Task;
import com.spring.edu_app2.repo.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	//DBから全てのタスク情報を取得してリストで返す
	public List<Task> getAllTasks(){
		List<Task> allTasks = new ArrayList<>(); 
		taskRepository.findAll().forEach(allTasks::add);	//findAll()で全て検索
		
		return allTasks;
	}
	
	public Optional<Task> getTask(long taskId) {
		
		return taskRepository.findById(taskId);
	}

	public void addTask(Task task){
		taskRepository.save(task);
	}
	
	
	public void updateTask(Long taskId,Task task) {
		if(taskRepository.findById(taskId).get() != null){
			taskRepository.save(task);
		}
	}
	public void deleteTask(Long taskId) {
		taskRepository.deleteById(taskId);
	}
	
	
}
