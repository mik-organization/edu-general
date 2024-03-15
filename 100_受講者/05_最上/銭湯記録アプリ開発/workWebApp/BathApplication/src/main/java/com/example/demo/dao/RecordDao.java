package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;

public interface RecordDao {
	
	void createBathInfo(BathInfo bathInfo);
	
	List<BathInfo> getAll();
	
	Optional<BathIntegrationEntitiy> getTopBath(int id);
		
	void insert (BathIntegrationEntitiy bathIntegrationEntitiy);

	int editBathInfo(BathIntegrationEntitiy bathIntegrationEntitiy);
	
	int delBathInfo(int id);

}
