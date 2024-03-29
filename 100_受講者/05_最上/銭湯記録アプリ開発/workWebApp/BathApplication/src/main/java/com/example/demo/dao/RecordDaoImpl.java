package com.example.demo.dao;

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
				bathInfo.getReviewValue(), 
				bathInfo.getBathIntegrationEntitiyId()); 
		 
		 System.out.println("+++++++:"+bathInfo.getAreaId());
		 
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
					bathInfo.getAreaId(),
					bathInfo.getReviewValue(),
					bathInfo.getBathIntegrationEntitiyId()); 

			jdbcTemplate.update("UPDATE comment SET "
					+ "comment = ?, reviewValue = ?, recordDate = ? "
					+ "WHERE commentId = ?",
					
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
