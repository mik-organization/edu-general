package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.BathInfo;

public interface RecordDao {
	
	void createBathInfo(BathInfo bathInfo);
	
	List<BathInfo> getAll();

}
