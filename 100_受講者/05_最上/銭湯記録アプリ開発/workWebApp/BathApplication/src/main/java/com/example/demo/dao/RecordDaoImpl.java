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
import com.example.demo.entity.Comment;

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
	public List<BathIntegrationEntitiy> getAll() {
		String sql = "SELECT bathInfoId, bathName, address, openTime, closeTime, price, tel, roten, sauna FROM bathInfo";
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
			bathInte.setTel((String)result.get("tel"));
			bathInte.setRoten((boolean)result.get("roten"));
			bathInte.setSauna((boolean)result.get("sauna"));	
			bathInte.setBathInfoId((int)result.get("bathInfoId"));
			
			Optional<BathIntegrationEntitiy> bathOpt = Optional.ofNullable(bathInte);
			
			return  bathOpt;
		}
	
	@Override
	public void insert(BathIntegrationEntitiy bathIntegrationEntitiy) {
		jdbcTemplate.update("INSERT INTO bathIntegrationEntitiy("
				+ "	bathName, address, openTime, closeTime, price, tel, roten, sauna, genreId, areaId, comments ,reviewValue, reviewAverage , recordDate)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
				bathIntegrationEntitiy.getBathName(),
				bathIntegrationEntitiy.getAddress(),
				bathIntegrationEntitiy.getOpenTime(),
				bathIntegrationEntitiy.getCloseTime(),
				bathIntegrationEntitiy.getPrice(),
				bathIntegrationEntitiy.getTel(),
				bathIntegrationEntitiy.isRoten(),
				bathIntegrationEntitiy.isSauna(),
				bathIntegrationEntitiy.getGenreId(),
				bathIntegrationEntitiy.getAreaId(),
				bathIntegrationEntitiy.getComments(),
//				bathIntegrationEntitiy.getReviewId(),
				bathIntegrationEntitiy.getReviewValue(),
				bathIntegrationEntitiy.getReviewValue(),
				bathIntegrationEntitiy.getRecordDate()
				);

		jdbcTemplate.update("INSERT INTO bathInfo("
				+ "	bathName, address, openTime, closeTime, price, tel, roten, sauna)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)", 
				bathIntegrationEntitiy.getBathName(),
				bathIntegrationEntitiy.getAddress(),
				bathIntegrationEntitiy.getOpenTime(),
				bathIntegrationEntitiy.getCloseTime(),
				bathIntegrationEntitiy.getPrice(),
				bathIntegrationEntitiy.getTel(),
				bathIntegrationEntitiy.isRoten(),
				bathIntegrationEntitiy.isSauna()
				);
		
		jdbcTemplate.update("INSERT INTO bath("
				+ "genreId, areaId, reviewAverage)"
				+ "VALUES(?, ?, ?)", 
				bathIntegrationEntitiy.getGenreId(),
				bathIntegrationEntitiy.getAreaId(),
				bathIntegrationEntitiy.getReviewId()
				);
		
		
		

		jdbcTemplate.update("INSERT INTO comment("
				+ "comment, reviewValue, recordDate)"
				+ "VALUES(?, ?, ?)", 
				
//				commentsString,
				bathIntegrationEntitiy.getComments(),
				bathIntegrationEntitiy.getReviewValue(),
				bathIntegrationEntitiy.getRecordDate()
				);
	}
	
	@Override
	public void editBathInfo(BathIntegrationEntitiy bathInfo) {
		 jdbcTemplate.update("UPDATE bathIntegrationEntitiy SET "
				+ "bathName = ?, address = ?, openTime = ?, closeTime = ?, price = ?, tel = ?, roten = ?, sauna = ?, genreId = ?, areaId = ?, comments = ?,reviewValue = ?"
				+ "WHERE bathIntegrationEntitiyId = ?",
				bathInfo.getBathName(),
				bathInfo.getAddress(),
				bathInfo.getOpenTime(),
				bathInfo.getCloseTime(),
				bathInfo.getPrice(),
				bathInfo.getTel(),
				bathInfo.isRoten(),
				bathInfo.isSauna(), 
				bathInfo.getGenreId(),
				bathInfo.getAreaId(),
				bathInfo.getComments(), 
//				bathInfo.getReviewId(), 
				bathInfo.getReviewValue(), 
				bathInfo.getBathIntegrationEntitiyId()); 
		 
		 jdbcTemplate.update("UPDATE bathInfo SET "
					+ "bathName = ?, address = ?, openTime = ?, closeTime = ?, price = ?, tel = ?, roten = ?, sauna = ? "
					+ "WHERE bathInfoId = ?",
					bathInfo.getBathName(),
					bathInfo.getAddress(),
					bathInfo.getOpenTime(),
					bathInfo.getCloseTime(),
					bathInfo.getPrice(),
					bathInfo.getTel(),
					bathInfo.isRoten(),
					bathInfo.isSauna(),
					bathInfo.getBathIntegrationEntitiyId()); 

			jdbcTemplate.update("UPDATE bath SET "
					+ "genreId = ?, areaId = ?, reviewAverage = ? "
					+ "WHERE bathId = ?",
					bathInfo.getGenreId(),
					bathInfo.getReviewValue(),
					bathInfo.getReviewId(),
					bathInfo.getBathIntegrationEntitiyId()); 
//		 
//			List<String> commentsList = bathInfo.getComments();
//			String commentsString = String.join(", ", commentsList);

			jdbcTemplate.update("UPDATE comment SET "
					+ "comment = ?, reviewValue = ?, recordDate = ? "
					+ "WHERE commentId = ?",
					
//					commentsString,
					bathInfo.getComments(),
					bathInfo.getReviewValue(),
					bathInfo.getRecordDate(),
					bathInfo.getBathIntegrationEntitiyId()); 
	}
	@Override
	public int delBathInfo(int id){
		return jdbcTemplate.update("DELETE FROM bathIntegrationEntitiy WHERE bathIntegrationEntitiyId = ?" ,id);
	}
	
	@Override
	public void updateExComment(BathIntegrationEntitiy bathIntegrationEntitiy) {

		//
		jdbcTemplate.update("INSERT INTO comment("
				+ "comment, reviewValue, bathInfoId, recordDate)"
				+ "VALUES(?, ?, ?, ?)", 
				bathIntegrationEntitiy.getComments(),
				bathIntegrationEntitiy.getReviewValue(),
				bathIntegrationEntitiy.getBathInfoId(),
				bathIntegrationEntitiy.getRecordDate());
		
		
		//bathIntegrationEntitiyデータベースに感想を追加
		jdbcTemplate.update("UPDATE bathIntegrationEntitiy "
				+"SET comments = CONCAT(comments, ',',?)"
				+"WHERE bathInfoId =?",
				bathIntegrationEntitiy.getComments(),
				bathIntegrationEntitiy.getBathInfoId());
		
		
		
		
		//評価の平均化
		jdbcTemplate.update("UPDATE bathIntegrationEntitiy "
					+ "SET reviewAverage = ("
					+ "	SELECT ROUND(AVG(reviewValue),2)"
					+ "	FROM comment"
					+ "	WHERE bathInfoId = ?)"
					+ "WHERE bathInfoId = ?",
				 bathIntegrationEntitiy.getBathInfoId(),
				 bathIntegrationEntitiy.getBathInfoId());
	}
}
