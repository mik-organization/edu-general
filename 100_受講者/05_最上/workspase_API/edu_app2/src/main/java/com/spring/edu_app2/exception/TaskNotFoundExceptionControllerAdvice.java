package com.spring.edu_app2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TaskNotFoundExceptionControllerAdvice {
	
	@ResponseBody
	@ExceptionHandler(TaskNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String TaskNotFoundHandler(TaskNotFoundException ex) {
		return ex.getMessage();
	}

}
