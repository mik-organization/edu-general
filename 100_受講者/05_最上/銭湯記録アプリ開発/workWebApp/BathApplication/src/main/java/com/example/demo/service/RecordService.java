package com.example.demo.service;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;

public interface RecordService {
	
	void createBathInfo(BathInfo bathInfo);
	
	void insert(BathIntegrationEntitiy bathIntegrationEntitiy);
	
	void editBathInfo(BathIntegrationEntitiy bathIntegrationEntitiy);
	
	void delBathInfo(int id);
	
	void updateExComment(BathIntegrationEntitiy bathIntegrationEntitiy);
	

}
