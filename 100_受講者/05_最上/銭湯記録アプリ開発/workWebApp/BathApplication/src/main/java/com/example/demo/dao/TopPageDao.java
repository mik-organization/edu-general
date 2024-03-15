package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;

public interface TopPageDao {
	
	List<BathInfo> getTopBathAll();
	
	Optional<BathIntegrationEntitiy> getTopBath(int id);
	
}
