package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;

public interface SearchDao {
	
	List<BathIntegrationEntitiy> fetchBath();

}
