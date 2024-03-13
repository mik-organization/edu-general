package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BathInfo;

@Repository
public class RecordDaoImpl implements RecordDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public RecordDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	};

	@Override
	public void createBathInfo(BathInfo bathInfo) {
		jdbcTemplate.update("INASERT INTO bathInfo(bathName, address, openTime, closeTime, price, tel, roten, sauna)VALUES(?, ?, ?, ?, ?, ?, ?,?)",
				bathInfo.getBathName(),bathInfo.getAddress(),bathInfo.getOpenTime(),bathInfo.getCloseTime(),bathInfo.getPrice(),bathInfo.getTel(),bathInfo.isRoten(),bathInfo.isSauna());
	}

	@Override
	public List<BathInfo> getAll() {
		String sql = "SELECT bathInfoId, bathName, address, openTime, closeTime, price, tel, roten, sauna FROM bathInfo";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<BathInfo> list = new ArrayList<BathInfo>();
		for(Map<String, Object> result : resultList) {
			BathInfo bathInfo = new BathInfo();
			bathInfo.setBathInfoId((int)result.get("bathInfoId"));
			bathInfo.setBathName((String)result.get("bathName"));
			bathInfo.setOpenTime((int)result.get("openTime"));
			bathInfo.setCloseTime((int)result.get("closeTime"));
			bathInfo.setPrice((int)result.get("price"));
			bathInfo.setTel((int)result.get("tel"));
			bathInfo.setRoten((boolean)result.get("roten"));
			bathInfo.setSauna((boolean)result.get("sauna"));
			list.add(bathInfo);
		}
		return list;
	}

}
