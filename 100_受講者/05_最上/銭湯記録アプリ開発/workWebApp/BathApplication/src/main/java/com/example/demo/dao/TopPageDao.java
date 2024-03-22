package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.SearchWord;

public interface TopPageDao {
	
	List<BathIntegrationEntitiy> getTopBathAll();
	
	Optional<BathIntegrationEntitiy> getTopBath(int id);
	
	List<BathIntegrationEntitiy> getSearchBath(String arg);
}
