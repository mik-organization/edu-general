package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RecordDao;
import com.example.demo.dao.TopPageDao;
import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.SearchWord;

@Service
public class SearchServiceImpl implements SearchService {
	
	private final SearchService dao;
	
	@Autowired
	public SearchServiceImpl(@Lazy SearchService dao){
		this.dao = dao;
	}
	
	@Override
	public List<BathIntegrationEntitiy> fetchBath(SearchWord searchWord) {
		return dao.fetchBath(searchWord);
	}


}
