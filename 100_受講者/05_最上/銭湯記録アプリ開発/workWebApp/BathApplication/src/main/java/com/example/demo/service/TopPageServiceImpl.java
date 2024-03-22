package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RecordDao;
import com.example.demo.dao.TopPageDao;
import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.SearchWord;

@Service
public class TopPageServiceImpl implements TopPageService {
	
	private final TopPageDao dao;
	
	@Autowired TopPageServiceImpl(TopPageDao dao){
		this.dao = dao;
	}

	@Override
	public List<BathIntegrationEntitiy> getTopBathAll() {
		return dao.getTopBathAll();
	};
	
	@Override
	public Optional<BathIntegrationEntitiy> getTopBath(int id){
		return dao.getTopBath(id);
	};
	
	@Override
	public List<BathIntegrationEntitiy> getSearchBath(String arg){
		return dao.getSearchBath(arg);
	};
}
