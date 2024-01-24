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

import com.spring.edu_app2.exception.CategoryNotFoundException;
import com.spring.edu_app2.model.Category;
import com.spring.edu_app2.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categorys")
	public List<Category> getAllCategorys(){
		return categoryService.getAllCategorys();
	}
	
	@GetMapping("/categorys/{categoryId}")
	public Category getcategory(@PathVariable("categoryId") Long categoryId) {
		return categoryService.getCategory(categoryId).orElseThrow(() -> new CategoryNotFoundException(categoryId));
	}
	
	@PostMapping("/categorys")
	public void addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
	}
	
	@PutMapping("/categorys/{categoryId}")
	public void updateCategory(@RequestBody Category category,
			@PathVariable("categoryId") Long categoryId) {
		categoryService.updateCategory(categoryId, category);
	}
	
	@DeleteMapping("/categorys/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}
	/*
	@GetMapping("/callHello")
	public HelloMessage callHello() {
		return userService.getHelloResponse();
	}
	*/

}
