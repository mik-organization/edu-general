package com.example.demo.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
public class TopPageDaoImpl implements TopPageDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public TopPageDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	};

	//TopPage表示
	@Override
	public List<BathIntegrationEntitiy> getTopBathAll() {
//		String sql = "SELECT bathInfoId, bathName, address, openTime, closeTime, price, tel, roten, sauna FROM bathInfo";
		String sql = "SELECT BathIntegrationEntitiyId, BathIntegrationEntitiy.bathName, address FROM BathIntegrationEntitiy";
		
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		
		List<BathIntegrationEntitiy> list = new ArrayList<BathIntegrationEntitiy>();
		
		for(Map<String, Object> result : resultList) {
			BathIntegrationEntitiy bathInfo = new BathIntegrationEntitiy();
			bathInfo.setBathIntegrationEntitiyId((int)result.get("bathIntegrationEntitiyId"));
			bathInfo.setBathName((String)result.get("bathName"));
			bathInfo.setAddress((String)result.get("address"));
//			bathInfo.setOpenTime((int)result.get("openTime"));
//			bathInfo.setCloseTime((int)result.get("closeTime"));
//			bathInfo.setPrice((int)result.get("price"));
//			bathInfo.setTel((int)result.get("tel"));
//			bathInfo.setRoten((boolean)result.get("roten"));
//			bathInfo.setSauna((boolean)result.get("sauna"));	
					
//			Bath bath = new Bath();
//			bath.setReviewAverage((double)result.get("reviewAverage"));
			
//			bathInfo.setBath(bath);
			
			list.add(bathInfo);
		}
		return list;
	}

	
	//TopPageから施設名、住所をタップした時
	public Optional<BathIntegrationEntitiy> getTopBath(int id){
		System.out.println("■■■来たやつ"+id);
		String sql = "SELECT bathIntegrationEntitiyId, bathName, address,openTime, closeTime, price, tel, roten, sauna, genreId, areaId, comments, bathInfoId FROM bathIntegrationEntitiy WHERE bathIntegrationEntitiyId = ?";
//		String sql = "SELECT bathIntegrationEntitiyId, bathName, address,openTime, closeTime, price, tel, roten, sauna, genreId, areaId, comments, bathIntegrationEntitiy.bathInfoId, reviewId,recordDate FROM bathIntegrationEntitiy"
//				+ "INNER JOIN comment ON bathIntegrationEntitiy.bathinfoId = comment.bathinfoId"
//				+ " WHERE bathIntegrationEntitiy.bathinfoId = ?";
		
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
		bathInte.setGenreId((int)result.get("genreId"));
		bathInte.setAreaId((int)result.get("areaId"));
		
		List<String> commentsList = new ArrayList<>();
		commentsList.add((String)result.get("comments")); // ここでString型のコメントをリストに追加
		bathInte.setComments(commentsList);
		
//		bathInte.setComments((String)result.get("comments"));
//		bathInte.setBathInfoId((int)result.get("bathInfoId"));
		
//		Comment comment = new Comment();
//		comment.setReviewId((int)result.get("reviewId"));
//		comment.setRecordDate(((Date)result.get("recordDate")).toLocalDate());
//		
//		bathInte.setComment(comment);
		
		Optional<BathIntegrationEntitiy> bathOpt = Optional.ofNullable(bathInte);
		
		return  bathOpt;
	}
	
}
