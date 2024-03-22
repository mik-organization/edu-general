package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Bath;
import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.SearchWord;

@Repository
public class SearchDaoImpl implements SearchDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SearchDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	};


	@Override
	public List<BathIntegrationEntitiy> fetchBath(SearchWord searchWord) {
		System.out.println(searchWord);
		
		String sql = "SELECT bathInfoId, bathName, address, openTime, closeTime, price, tel, roten, sauna FROM bathIntegrationEntitiy";
		
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<BathIntegrationEntitiy> list = new ArrayList<BathIntegrationEntitiy>();
		
		for(Map<String, Object> result : resultList) {
			BathIntegrationEntitiy bathInfo = new BathIntegrationEntitiy();
			
			bathInfo.setBathInfoId((int)result.get("bathInfoId"));
			bathInfo.setBathName((String)result.get("bathName"));
			bathInfo.setOpenTime((int)result.get("openTime"));
			bathInfo.setCloseTime((int)result.get("closeTime"));
			bathInfo.setPrice((int)result.get("price"));
			bathInfo.setTel((String)result.get("tel"));
			bathInfo.setRoten((boolean)result.get("roten"));
			bathInfo.setSauna((boolean)result.get("sauna"));	
			list.add(bathInfo);
		}
		return list;
	}

}
