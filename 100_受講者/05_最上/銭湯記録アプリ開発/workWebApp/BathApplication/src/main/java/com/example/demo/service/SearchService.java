package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.SearchWord;

public interface SearchService {
		
	List<BathIntegrationEntitiy> fetchBath(SearchWord searchWord);

}
