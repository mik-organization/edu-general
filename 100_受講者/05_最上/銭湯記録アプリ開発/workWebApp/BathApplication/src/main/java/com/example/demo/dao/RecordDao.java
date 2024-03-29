package com.example.demo.dao;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;

public interface RecordDao {
	
	void createBathInfo(BathInfo bathInfo);
	
	void insert (BathIntegrationEntitiy bathIntegrationEntitiy);

	void editBathInfo(BathIntegrationEntitiy bathIntegrationEntitiy);
	
	int delBathInfo(int id);

	void updateExComment(BathIntegrationEntitiy bathIntegrationEntitiy);
}
