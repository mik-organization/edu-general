package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;

@Repository
public class RecordDaoImpl implements RecordDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public RecordDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	};

	@Override
	public void createBathInfo(BathInfo bathInfo) {
		jdbcTemplate.update("INSERT INTO bathInfo(bathName, address, openTime, closeTime, price, tel, roten, sauna)VALUES(?, ?, ?, ?, ?, ?, ?,?)",
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
	

	
	//TopPageから施設名、住所をタップした時
	@Override
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
	
	@Override
	public void insert(BathIntegrationEntitiy bathIntegrationEntitiy) {
		jdbcTemplate.update("INSERT INTO bathIntegrationEntitiy("
				+ "	bathInfoId,bathName, address, openTime, closeTime, price, tel, roten, sauna, bathId, genreId, areaId, comments)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
				bathIntegrationEntitiy.getBathInfoId(),
				bathIntegrationEntitiy.getBathName(),
				bathIntegrationEntitiy.getAddress(),
				bathIntegrationEntitiy.getOpenTime(),
				bathIntegrationEntitiy.getCloseTime(),
				bathIntegrationEntitiy.getPrice(),
				bathIntegrationEntitiy.getTel(),
				bathIntegrationEntitiy.isRoten(),
				bathIntegrationEntitiy.isSauna(),
				bathIntegrationEntitiy.getBathId(),
				bathIntegrationEntitiy.getGenreId(),
				bathIntegrationEntitiy.getAreaId(),
				bathIntegrationEntitiy.getComments(),
				bathIntegrationEntitiy.getBathInfoId()
				);			
	}
	
	@Override
	public int editBathInfo(BathIntegrationEntitiy bathInfo) {
		return jdbcTemplate.update("UPDATE bathInfo SET bathName = ?, address = ?, openTime = ?, closeTime = ?, price = ?, tel = ?, roten = ?, sauna = ?",
				bathInfo.getBathName(),bathInfo.getAddress(),bathInfo.getOpenTime(),bathInfo.getCloseTime(),bathInfo.getPrice(),bathInfo.getTel()); 
	}
	@Override
	public int delBathInfo(int id){
		return jdbcTemplate.update("DELET FROM bathInfo	WHERE id = ?" ,id);
	}
	

}
