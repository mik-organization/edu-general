package com.spring.edu_app2.exception;

public class CategoryNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public CategoryNotFoundException(Long categoryId) {
		super("カテゴリーID：" + categoryId + "は見つかりません。");
	}
}
