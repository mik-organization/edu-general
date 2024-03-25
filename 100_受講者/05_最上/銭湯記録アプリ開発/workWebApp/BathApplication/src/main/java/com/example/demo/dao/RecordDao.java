package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Bath;
import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.Comment;

public interface RecordDao {
	
	void createBathInfo(BathInfo bathInfo);
	
	List<BathIntegrationEntitiy> getAll();
		
	Optional<BathIntegrationEntitiy> getTopBath(int id);
		
	void insert (BathIntegrationEntitiy bathIntegrationEntitiy);

	void editBathInfo(BathIntegrationEntitiy bathIntegrationEntitiy);
	
	int delBathInfo(int id);

	void updateExComment(BathIntegrationEntitiy bathIntegrationEntitiy);
}
