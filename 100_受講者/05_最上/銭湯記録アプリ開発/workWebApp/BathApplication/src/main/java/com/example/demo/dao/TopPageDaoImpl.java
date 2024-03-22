package com.example.demo.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
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
import com.example.demo.entity.SearchWord;

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
		String sql = "SELECT BathIntegrationEntitiyId, BathIntegrationEntitiy.bathName, address, reviewId FROM BathIntegrationEntitiy";
		
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		
		List<BathIntegrationEntitiy> list = new ArrayList<BathIntegrationEntitiy>();
		
		for(Map<String, Object> result : resultList) {
			BathIntegrationEntitiy bathInfo = new BathIntegrationEntitiy();
			bathInfo.setBathIntegrationEntitiyId((int)result.get("bathIntegrationEntitiyId"));
			bathInfo.setBathName((String)result.get("bathName"));
			bathInfo.setAddress((String)result.get("address"));
			bathInfo.setReviewId((int)result.get("reviewId"));
			
			list.add(bathInfo);
		}
		return list;
	}

	
	//TopPageから施設名、住所をタップした時
	@SuppressWarnings("unchecked")
	public Optional<BathIntegrationEntitiy> getTopBath(int id){
		String sql = "SELECT bathIntegrationEntitiyId, bathName, address,openTime, closeTime, price, tel, roten, sauna, genreId, areaId, comments, reviewId,recordDate "
				+ " FROM bathIntegrationEntitiy WHERE bathIntegrationEntitiyId = ?";
		
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
		bathInte.setGenreId((int)result.get("genreId"));
		bathInte.setAreaId((int)result.get("areaId"));
		bathInte.setComments((List<String>) result.get("comments"));
		bathInte.setReviewId((int)result.get("reviewId"));
		bathInte.setRecordDate(((Date) result.get("recordDate")));
		
//		List<String> commentsList = new ArrayList<>();
//		commentsList.add((String)result.get("comments")); // ここでString型のコメントをリストに追加
//		bathInte.setComments(commentsList);
		
		Optional<BathIntegrationEntitiy> bathOpt = Optional.ofNullable(bathInte);
		
		return  bathOpt;
	}
	
	//TopPageから検索
	public List<BathIntegrationEntitiy> getSearchBath(String arg){
		String keyWord = arg;
		String sql = "SELECT * FROM bathIntegrationEntitiy INNER JOIN comment USING(bathInfoId)"
				+"WHERE bathIntegrationEntitiy.bathName LIKE '%"+keyWord+"%'"
				+"OR bathIntegrationEntitiy.address LIKE '%"+keyWord+"%'"
				+"OR comment.comment LIKE '%"+keyWord+"%'";
		
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		
		List<BathIntegrationEntitiy> list = new ArrayList<BathIntegrationEntitiy>();
		
		for(Map<String, Object> result : resultList) {
			BathIntegrationEntitiy bathInfo = new BathIntegrationEntitiy();
			bathInfo.setBathIntegrationEntitiyId((int)result.get("bathIntegrationEntitiyId"));
			bathInfo.setBathName((String)result.get("bathName"));
			bathInfo.setAddress((String)result.get("address"));
			bathInfo.setReviewId((int)result.get("reviewId"));
			
			list.add(bathInfo);
		}
		return list;
		}
//		
//		List<String> commentsList = new ArrayList<>();
//		commentsList.add((String)result.get("comments")); // ここでString型のコメントをリストに追加
//		bathInte.setComments(commentsList);
		
//		Optional<BathIntegrationEntitiy> bathOpt = Optional.ofNullable(bathInte);
//		
//		return  bathOpt;
	
}
