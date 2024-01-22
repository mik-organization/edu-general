package com.spring.edu_app2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.edu_app2.model.Category;
import com.spring.edu_app2.repo.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//DBから全てのユーザ情報を取得してリストで返す
	public List<Category> getAllCategorys(){
		List<Category> allCategorys = new ArrayList<>(); 
		categoryRepository.findAll().forEach(allCategorys::add);	//findAll()で全て検索
		
		return allCategorys;
	}
	
	public Optional<Category> getCategory(long categoryId) {
		
		return categoryRepository.findById(categoryId);
	}

	public void addCategory(Category category){
		categoryRepository.save(category);
	}
	
	
	public void updateCategory(Long categoryId,Category category) {
		if(categoryRepository.findById(categoryId).get() != null){
			categoryRepository.save(category);
		}
	}
	public void deleteCategory(Long categoryId) {
		categoryRepository.deleteById(categoryId);
	}
	
	
}
