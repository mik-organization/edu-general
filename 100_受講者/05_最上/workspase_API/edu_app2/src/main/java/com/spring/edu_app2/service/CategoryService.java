package com.spring.edu_app2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.spring.edu_app2.model.Category;
import com.spring.edu_app2.repo.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//DBから全てのユーザ情報を取得してリストで返す
	@Cacheable("getCategorys")
	public List<Category> getAllCategorys(){
		List<Category> allCategorys = new ArrayList<>(); 
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		categoryRepository.findAll().forEach(allCategorys::add);	//findAll()で全て検索
		
		return allCategorys;
	}
	
	@Cacheable(value="getCategory",key="#p0")
	public Optional<Category> getCategory(long categoryId) {
		
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return categoryRepository.findById(categoryId);
	}
	
	@CacheEvict(value="getCategorys",allEntries=true)
	public void addCategory(Category category){
		categoryRepository.save(category);
	}
	
	@Caching(evict= {
			@CacheEvict(value="getCategory",key="#p0"),
			@CacheEvict(value="getCategorys",allEntries=true)
	})
	public void updateCategory(Long categoryId,Category category) {
		if(categoryRepository.findById(categoryId).get() != null){
			categoryRepository.save(category);
		}
	}
	
	@Caching(evict= {
			@CacheEvict(value="getCategory",key="#p0"),
			@CacheEvict(value="getCategorys",allEntries=true)
	})
	public void deleteCategory(Long categoryId) {
		categoryRepository.deleteById(categoryId);
	}
	
	
}
