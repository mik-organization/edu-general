package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Bath;
import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;

@Repository
public class TopPageDaoImpl implements TopPageDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public TopPageDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	};

	//TopPage表示
	@Override
	public List<BathInfo> getTopBathAll() {
//		String sql = "SELECT bathInfoId, bathName, address, openTime, closeTime, price, tel, roten, sauna FROM bathInfo";
		String sql = "SELECT bathInfo.bathInfoId, bathInfo.bathName, address, bath.reviewAverage FROM bathInfo INNER JOIN bath ON bathInfo.bathInfoId = bath.bathInfoId";
		
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		
		List<BathInfo> list = new ArrayList<BathInfo>();
		
		for(Map<String, Object> result : resultList) {
			BathInfo bathInfo = new BathInfo();
			bathInfo.setBathInfoId((int)result.get("bathInfoId"));
			bathInfo.setBathName((String)result.get("bathName"));
			bathInfo.setAddress((String)result.get("address"));
//			bathInfo.setOpenTime((int)result.get("openTime"));
//			bathInfo.setCloseTime((int)result.get("closeTime"));
//			bathInfo.setPrice((int)result.get("price"));
//			bathInfo.setTel((int)result.get("tel"));
//			bathInfo.setRoten((boolean)result.get("roten"));
//			bathInfo.setSauna((boolean)result.get("sauna"));	
					
			Bath bath = new Bath();
			bath.setReviewAverage((double)result.get("reviewAverage"));
			
			bathInfo.setBath(bath);
			
			list.add(bathInfo);
		}
		return list;
	}

	
	//TopPageから施設名、住所をタップした時
	public Optional<BathIntegrationEntitiy> getTopBath(int id){
		String sql = "SELECT bathIntegrationEntitiyId, bathName, address,openTime, closeTime, price, tel, roten, sauna, bathInfoId FROM bathIntegrationEntitiy WHERE infoId = ?";
		
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, id);
		
		BathIntegrationEntitiy bathInte = new BathIntegrationEntitiy();
		bathInte.setBathIntegrationEntitiyId((int)result.get("bathIntegrationEntitiyId"));
		bathInte.setBathName((String)result.get("bathName"));
		bathInte.setAddress((String)result.get("address"));
		bathInte.setOpenTime((int)result.get("openTime"));
		bathInte.setCloseTime((int)result.get("closeTime"));
		bathInte.setPrice((int)result.get("price"));
		bathInte.setTel((int)result.get("tel"));
		bathInte.setRoten((boolean)result.get("roten"));
		bathInte.setSauna((boolean)result.get("sauna"));	
		bathInte.setBathInfoId((int)result.get("bathInfoId"));
		
		Optional<BathIntegrationEntitiy> bathOpt = Optional.ofNullable(bathInte);
		
		return  bathOpt;
	}
	
}
