package com.example.demo.dao;

import java.util.List;

import java.util.Optional;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.Comment;

public interface TopPageDao {
	
	List<BathIntegrationEntitiy> getTopBathAll();
	
	List<BathIntegrationEntitiy> getAreaRecommend(int num);
	
	List<BathIntegrationEntitiy> getGenreRecommend(int num);
	
	Optional<BathIntegrationEntitiy> getTopBath(int id);
	
//	List<Comment> getCommentList(int id);
	
	List<BathIntegrationEntitiy> getSearchBath(String arg);
	
	List<BathIntegrationEntitiy> getChoiceBath(int areaId, int price, int genreId, int reviewId);
}
