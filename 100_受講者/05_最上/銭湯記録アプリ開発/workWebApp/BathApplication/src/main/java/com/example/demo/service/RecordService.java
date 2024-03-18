package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Bath;
import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.Comment;

public interface RecordService {
	
	void createBathInfo(BathInfo bathInfo);
	
	List<BathIntegrationEntitiy> getAll();
	
	Optional<BathIntegrationEntitiy> getTopBath(int id);
	
	void insert (BathInfo bathInfo,Bath bath,
			BathIntegrationEntitiy bathIntegrationEntitiy, Comment comment);
	
//	void insert(BathIntegrationEntitiy bathIntegrationEntitiy);
	
	void editBathInfo(BathIntegrationEntitiy bathIntegrationEntitiy);
	
	void delBathInfo(int id);
	
	
	

}
