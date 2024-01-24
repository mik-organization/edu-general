package com.spring.edu_app2.exception;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(Long userId) {
		super("ユーザコード：" + userId + "は見つかりません。");
	}
}
