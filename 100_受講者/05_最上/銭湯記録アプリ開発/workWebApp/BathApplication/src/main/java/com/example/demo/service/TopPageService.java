package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import com.example.demo.entity.BathIntegrationEntitiy;

public interface TopPageService {
	
	List<BathIntegrationEntitiy> getTopBathAll();
	
	Optional<BathIntegrationEntitiy> getTopBath(int id);

	List<BathIntegrationEntitiy> getSearchBath(String arg);

}
