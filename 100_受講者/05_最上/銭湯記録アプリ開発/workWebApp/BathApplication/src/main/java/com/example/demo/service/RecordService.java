package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BathInfo;

public interface RecordService {
	
	void createBathInfo(BathInfo bathInfo);
	
	List<BathInfo> getAll();

}
