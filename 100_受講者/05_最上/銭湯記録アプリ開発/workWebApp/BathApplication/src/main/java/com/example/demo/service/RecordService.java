package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;

public interface RecordService {
	
	void createBathInfo(BathInfo bathInfo);
	
	List<BathInfo> getAll();

	Optional<BathIntegrationEntitiy> getTopBath(int id);
	
	void insert(BathIntegrationEntitiy bathIntegrationEntitiy);
	
	void editBathInfo(BathIntegrationEntitiy bathIntegrationEntitiy);
	
	void delBathInfo(int id);

}
