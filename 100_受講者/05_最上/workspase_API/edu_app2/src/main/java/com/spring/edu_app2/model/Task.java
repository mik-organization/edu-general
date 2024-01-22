package com.spring.edu_app2.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="t_task")	//DBのテーブル名とMapping
public class Task {

	@Id	//主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	private Long userId;
	private Long categoryId;
	private String userName;
	private String description;
	private String due_date;
	private boolean completed ;
	private LocalDateTime updated;

	public Task() {
	}

	public Task(Long userId, Long categoryId, String userName,String description, String due_date, boolean completed,
			LocalDateTime updated) {
		this.userId = userId;
		this.categoryId = categoryId;
		this.userName = userName;
		this.description = description;
		this.due_date = due_date;
		this.completed = completed;
		this.updated = updated;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}


	
}
