package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.Comment;

public interface TopPageService {
	
	List<BathIntegrationEntitiy> getTopBathAll();
	
	Optional<BathIntegrationEntitiy> getTopBath(int id);

//	List<Comment> getCommentList(int id);
	
	List<BathIntegrationEntitiy> getSearchBath(String arg);
	
	List<BathIntegrationEntitiy> getChoiceBath(int areaId, int price, int genreId, int reviewId);

	

}
