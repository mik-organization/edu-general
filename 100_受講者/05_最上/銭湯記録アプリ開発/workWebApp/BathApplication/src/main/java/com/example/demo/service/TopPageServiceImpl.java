package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RecordDao;
import com.example.demo.dao.TopPageDao;
import com.example.demo.entity.BathInfo;

@Service
public class TopPageServiceImpl implements TopPageService {
	
	private final TopPageDao dao;
	
	@Autowired TopPageServiceImpl(TopPageDao dao){
		this.dao = dao;
	}
	
//	@Override
//	public void createBathInfo(BathInfo bathInfo) {
//		dao.createBathInfo(bathInfo);
//
//	}

	@Override
	public List<BathInfo> getTopBath() {
		return dao.getTopBath();
	}

}
