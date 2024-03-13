package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RecordDao;
import com.example.demo.entity.BathInfo;

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
	public List<BathInfo> getAll() {
		return dao.getAll();
	}

}
