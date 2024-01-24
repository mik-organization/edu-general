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

import com.spring.edu_app2.exception.TaskNotFoundException;
import com.spring.edu_app2.model.Task;
import com.spring.edu_app2.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	@GetMapping("/tasks/{tasksId}")
	public Task getTask(@PathVariable("tasksId") Long tasksId) {
		return taskService.getTask(tasksId).orElseThrow(() -> new TaskNotFoundException(tasksId));
	}
	
	@PostMapping("/tasks")
	public void addTask(@RequestBody Task task) {
		taskService.addTask(task);
	}
	
	@PutMapping("/tasks/{tasksId}")
	public void updateTask(@RequestBody Task task,
			@PathVariable("tasksId") Long tasksId) {
		taskService.updateTask(tasksId, task);
	}
	
	@DeleteMapping("/tasks/{tasksId}")
	public void deleteTask(@PathVariable("tasksId") Long tasksId) {
		taskService.deleteTask(tasksId);
	}
}
