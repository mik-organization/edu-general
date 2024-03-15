package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.SearchWord;

public interface SearchDao {
	
	List<BathIntegrationEntitiy> fetchBath(SearchWord searchWord);

}
