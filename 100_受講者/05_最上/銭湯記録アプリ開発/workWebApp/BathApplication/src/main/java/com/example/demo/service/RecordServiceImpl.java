package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RecordDao;
import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;

@Service
public class RecordServiceImpl implements RecordService {
	
	private final RecordDao dao;
	
	@Autowired RecordServiceImpl(RecordDao dao){
		this.dao = dao;
	}
	
	@Override
	public void createBathInfo(BathInfo bathInfo) {
		dao.createBathInfo(bathInfo);

	}
	
	@Override
	public void insert(BathIntegrationEntitiy bathIntegrationEntitiy) {
		dao.insert(bathIntegrationEntitiy);
	}
	
	@Override
	public void editBathInfo(BathIntegrationEntitiy bathIntegrationEntitiy) {
		dao.editBathInfo(bathIntegrationEntitiy);
	};
	
	@Override
	public void delBathInfo(int id) {
		dao.delBathInfo(id);
	};
	
	@Override
	public void updateExComment(BathIntegrationEntitiy bathIntegrationEntitiy) {
		dao.updateExComment(bathIntegrationEntitiy);
	};
}
