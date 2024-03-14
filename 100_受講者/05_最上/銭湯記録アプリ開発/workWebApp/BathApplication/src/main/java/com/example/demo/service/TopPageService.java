package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BathInfo;

public interface TopPageService {
	
//	void createBathInfo(BathInfo bathInfo);
	
	List<BathInfo> getTopBath();

}
