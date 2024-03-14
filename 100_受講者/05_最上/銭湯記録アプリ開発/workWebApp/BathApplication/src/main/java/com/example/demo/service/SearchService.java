package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;

public interface SearchService {
		
	List<BathIntegrationEntitiy> fetchBath();

}
