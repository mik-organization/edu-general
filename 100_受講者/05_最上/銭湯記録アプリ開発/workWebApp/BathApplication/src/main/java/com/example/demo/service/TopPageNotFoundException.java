package com.example.demo.service;

public class TopPageNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TopPageNotFoundException(String message) {
		super(message);
	}

}
