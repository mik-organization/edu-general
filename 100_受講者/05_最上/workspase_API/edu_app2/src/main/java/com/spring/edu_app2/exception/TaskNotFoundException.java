package com.spring.edu_app2.exception;

public class TaskNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public TaskNotFoundException(Long taskId) {
		super("タスクID：" + taskId + "は見つかりません。");
	}
}
