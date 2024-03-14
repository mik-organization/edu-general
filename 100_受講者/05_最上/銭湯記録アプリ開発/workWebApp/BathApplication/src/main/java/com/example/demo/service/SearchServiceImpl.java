package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RecordDao;
import com.example.demo.dao.TopPageDao;
import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;

@Service
public class SearchServiceImpl implements SearchService {
	
	private final SearchService dao;
	
	@Autowired SearchServiceImpl(SearchService dao){
		this.dao = dao;
	}
	
	@Override
	public List<BathIntegrationEntitiy> fetchBath() {
		return dao.fetchBath();
	}


}
