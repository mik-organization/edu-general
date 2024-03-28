package com.example.demo.dao;

import java.sql.Date;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
		String sql = "SELECT BathIntegrationEntitiyId, bathName, address, reviewAverage FROM BathIntegrationEntitiy";
		
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		
		List<BathIntegrationEntitiy> list = new ArrayList<BathIntegrationEntitiy>();
		
		for(Map<String, Object> result : resultList) {
			BathIntegrationEntitiy bathInfo = new BathIntegrationEntitiy();
			bathInfo.setBathIntegrationEntitiyId((int)result.get("bathIntegrationEntitiyId"));
			bathInfo.setBathName((String)result.get("bathName"));
			bathInfo.setAddress((String)result.get("address"));
			bathInfo.setReviewAverage((double)result.get("reviewAverage"));
			
			list.add(bathInfo);
		}
		return list;
	}
	@Override
	public List<BathIntegrationEntitiy> getAreaRecommend(int num) {
		String sql = "SELECT BathIntegrationEntitiyId, bathName, address, reviewAverage FROM BathIntegrationEntitiy WHERE areaId = " + num;
		
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		
		List<BathIntegrationEntitiy> list = new ArrayList<BathIntegrationEntitiy>();
		
		for(Map<String, Object> result : resultList) {
			BathIntegrationEntitiy bathInfo = new BathIntegrationEntitiy();
			bathInfo.setBathIntegrationEntitiyId((int)result.get("bathIntegrationEntitiyId"));
			bathInfo.setBathName((String)result.get("bathName"));
			bathInfo.setAddress((String)result.get("address"));
			bathInfo.setReviewAverage((double)result.get("reviewAverage"));
			bathInfo.setAreaId(num);
			
			list.add(bathInfo);
		}
		return list;
	}
	
	@Override
	public List<BathIntegrationEntitiy> getGenreRecommend(int num) {
		String sql = "SELECT BathIntegrationEntitiyId, bathName, address, reviewAverage FROM BathIntegrationEntitiy WHERE genreId = " + num;
		
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		
		List<BathIntegrationEntitiy> list = new ArrayList<BathIntegrationEntitiy>();
		
		for(Map<String, Object> result : resultList) {
			BathIntegrationEntitiy bathInfo = new BathIntegrationEntitiy();
			bathInfo.setBathIntegrationEntitiyId((int)result.get("bathIntegrationEntitiyId"));
			bathInfo.setBathName((String)result.get("bathName"));
			bathInfo.setAddress((String)result.get("address"));
			bathInfo.setReviewAverage((double)result.get("reviewAverage"));
			bathInfo.setGenreId(num);
			
			list.add(bathInfo);
		}
		return list;
	}
	
	//TopPageから施設名、住所をタップした時
	public Optional<BathIntegrationEntitiy> getTopBath(int id){
		String sql = "SELECT bathIntegrationEntitiyId, bathName, address,openTime, closeTime, price, tel, roten, sauna, genreId, areaId, comments, reviewAverage,recordDate "
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
		bathInte.setComments((String)result.get("comments"));
//		bathInte.setComments((List<String>) result.get("comments"));
		bathInte.setReviewAverage((double)result.get("reviewAverage"));
		bathInte.setRecordDate(((Date) result.get("recordDate")));
		
//		List<String> commentsList = new ArrayList<>();
//		commentsList.add((String)result.get("comments")); // ここでString型のコメントをリストに追加
//		bathInte.setComments(commentsList);
		
		Optional<BathIntegrationEntitiy> bathOpt = Optional.ofNullable(bathInte);
		
		return  bathOpt;
	}
	
//	public List<Comment> getCommentList(int id){
//		String sql = "SELECT comment, recordDate FROM comment WHERE bathInfoId = "+id;
//		System.out.println("iddddddd:"+id);
//		
//		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
//		
//		List<Comment> commentlist = new ArrayList<Comment>();
//		
//		for(Map<String, Object> result : resultList) {
//			Comment comment = new Comment();
//			comment.setComment((String)result.get("comment"));
//			comment.setRecordDate((Date)result.get("recordDate"));
//			commentlist.add(comment);
//		}
//		return commentlist;
//		
//	}
	
	//TopPageから検索
	public List<BathIntegrationEntitiy> getSearchBath(String arg){
		String keyWord = arg;
		String sql = "SELECT * FROM bathIntegrationEntitiy "
				+"WHERE bathIntegrationEntitiy.bathName LIKE '%"+keyWord+"%'"
				+"OR bathIntegrationEntitiy.address LIKE '%"+keyWord+"%'"
				+"OR comments LIKE '%"+keyWord+"%'";
		
		System.out.println(sql);
		
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		
		List<BathIntegrationEntitiy> list = new ArrayList<BathIntegrationEntitiy>();
		
		for(Map<String, Object> result : resultList) {
			BathIntegrationEntitiy bathInfo = new BathIntegrationEntitiy();
			bathInfo.setBathIntegrationEntitiyId((int)result.get("bathIntegrationEntitiyId"));
			bathInfo.setBathName((String)result.get("bathName"));
			bathInfo.setAddress((String)result.get("address"));
			bathInfo.setReviewAverage((double)result.get("reviewAverage"));
			
			list.add(bathInfo);
		}
		return list;
		}

	//TopPageから絞り込み
	public List<BathIntegrationEntitiy> getChoiceBath(int areaId, int price, int genreId, int reviewId){
//		StringBuilder sql = new StringBuilder("SELECT * FROM bathIntegrationEntitiy ");
		String sql = null;
		
		
		
		//(地域〇)
		if(areaId != 0) {
			
			//(地域〇,ジャンル〇)
			if(genreId != 0) {
			
				//(地域〇,ジャンル〇,評価1)★★★
				if(reviewId == 1) {
					
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE areaId = "+areaId
							+"AND genreId = "+genreId
							+"AND reviewAverage <1.0";
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE areaId = "+areaId
							+"AND price <= 500"
							+"AND genreId = "+genreId
							+"AND reviewAverage <1.0";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price BETWEEN 501 AND 999"
								+"AND genreId = "+genreId
								+"AND reviewAverage <1.0";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price BETWEEN 1000 AND 1499"
								+"AND genreId = "+genreId
								+"AND reviewAverage <1.0";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price >=1500"
								+"AND genreId = "+genreId
								+"AND reviewAverage <1.0";
						break;
					}
				//(地域〇,ジャンル〇,評価2)★★★
				}else if(reviewId == 2) {
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE areaId = "+areaId
							+"AND genreId = "+genreId
							+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE areaId = "+areaId
							+"AND price <= 500"
							+"AND genreId = "+genreId
							+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price BETWEEN 501 AND 999"
								+"AND genreId = "+genreId
								+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price BETWEEN 1000 AND 1499"
								+"AND genreId = "+genreId
								+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price >=1500"
								+"AND genreId = "+genreId
								+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					}
				//(地域〇,ジャンル〇,評価3)★★★
				}else if(reviewId == 3) {
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE areaId = "+areaId
							+"AND genreId = "+genreId
							+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE areaId = "+areaId
							+"AND price <= 500"
							+"AND genreId = "+genreId
							+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price BETWEEN 501 AND 999"
								+"AND genreId = "+genreId
								+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price BETWEEN 1000 AND 1499"
								+"AND genreId = "+genreId
								+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price >=1500"
								+"AND genreId = "+genreId
								+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					}
				//(地域〇,ジャンル〇,評価✕)★★★
				}else if(reviewId == 0) {
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE areaId = "+areaId
							+"AND genreId = "+genreId;
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE areaId = "+areaId
							+"AND price <= 500"
							+"AND genreId = "+genreId;
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price BETWEEN 501 AND 999"
								+"AND genreId = "+genreId;
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price BETWEEN 1000 AND 1499"
								+"AND genreId = "+genreId;
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price >=1500"
								+"AND genreId = "+genreId;
						break;
					}
				}
			//(地域〇,ジャンル✕)
			}else if(genreId == 0) {
				//(地域〇,ジャンル✕,評価1)★★★
					if(reviewId == 1) {
						
						switch (price){
						case 0:
							sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND reviewAverage <1.0";
							break;
						case 1:
							sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price <= 500"
								+"AND reviewAverage <1.0";
							break;
						case 2:
							sql = "SELECT * FROM bathIntegrationEntitiy "
									+"WHERE areaId = "+areaId
									+"AND price BETWEEN 501 AND 999"
									+"AND reviewAverage <1.0";
							break;
						case 3:
							sql = "SELECT * FROM bathIntegrationEntitiy "
									+"WHERE areaId = "+areaId
									+"AND price BETWEEN 1000 AND 1499"
									+"AND reviewAverage <1.0";
							break;
						case 4:
							sql = "SELECT * FROM bathIntegrationEntitiy "
									+"WHERE areaId = "+areaId
									+"AND price >=1500"
									+"AND reviewAverage <1.0";
							break;
						}
					//(地域〇,ジャンル✕,評価2)★★★
					}else if(reviewId == 2) {
						switch (price){
						case 0:
							sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND reviewAverage BETWEEN 1.5 AND 3.0";
							break;
						case 1:
							sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price <= 500"
								+"AND reviewAverage BETWEEN 1.5 AND 3.0";
							break;
						case 2:
							sql = "SELECT * FROM bathIntegrationEntitiy "
									+"WHERE areaId = "+areaId
									+"AND price BETWEEN 501 AND 999"
									+"AND reviewAverage BETWEEN 1.5 AND 3.0";
							break;
						case 3:
							sql = "SELECT * FROM bathIntegrationEntitiy "
									+"WHERE areaId = "+areaId
									+"AND price BETWEEN 1000 AND 1499"
									+"AND reviewAverage BETWEEN 1.5 AND 3.0";
							break;
						case 4:
							sql = "SELECT * FROM bathIntegrationEntitiy "
									+"WHERE areaId = "+areaId
									+"AND price >=1500"
									+"AND reviewAverage BETWEEN 1.5 AND 3.0";
							break;
						}
					//(地域〇,ジャンル✕,評価3)★★★
					}else if(reviewId == 3) {
						switch (price){
						case 0:
							sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND reviewAverage BETWEEN 3.5 AND 5.0";
							break;
						case 1:
							sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price <= 500"
								+"AND reviewAverage BETWEEN 3.5 AND 5.0";
							break;
						case 2:
							sql = "SELECT * FROM bathIntegrationEntitiy "
									+"WHERE areaId = "+areaId
									+"AND price BETWEEN 501 AND 999"
									+"AND reviewAverage BETWEEN 3.5 AND 5.0";
							break;
						case 3:
							sql = "SELECT * FROM bathIntegrationEntitiy "
									+"WHERE areaId = "+areaId
									+"AND price BETWEEN 1000 AND 1499"
									+"AND reviewAverage BETWEEN 3.5 AND 5.0";
							break;
						case 4:
							sql = "SELECT * FROM bathIntegrationEntitiy "
									+"WHERE areaId = "+areaId
									+"AND price >=1500"
									+"AND reviewAverage BETWEEN 3.5 AND 5.0";
							break;
						}
					//(地域〇,ジャンル✕,評価✕)★★★
					}else if(reviewId == 0) {
						switch (price){
						case 0:
							sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId;
							break;
						case 1:
							sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price <= 500";
							break;
						case 2:
							sql = "SELECT * FROM bathIntegrationEntitiy "
									+"WHERE areaId = "+areaId
									+"AND price BETWEEN 501 AND 999";
							break;
						case 3:
							sql = "SELECT * FROM bathIntegrationEntitiy "
									+"WHERE areaId = "+areaId
									+"AND price BETWEEN 1000 AND 1499";
							break;
						case 4:
							sql = "SELECT * FROM bathIntegrationEntitiy "
									+"WHERE areaId = "+areaId
									+"AND price >=1500";
							break;
						}
				//(地域〇,ジャンル✕,評価✕)★★★
				}else if(reviewId == 0) {
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE areaId = "+areaId;
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE areaId = "+areaId
							+"AND price <= 500";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price BETWEEN 501 AND 999";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price BETWEEN 1000 AND 1499";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE areaId = "+areaId
								+"AND price >=1500";
						break;
					}
				}
			}
		
		//(地域✕)::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		}else if(areaId == 0){
			
			//(地域✕,ジャンル〇)
			if(genreId != 0) {
				//(地域✕,ジャンル〇,評価1)★★★
				if(reviewId == 1) {
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE genreId = "+genreId
							+"AND review <1.0";
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE genreId = "+genreId
							+"AND price <= 500"
							+"AND reviewAverage <1.0";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price BETWEEN 501 AND 999"
								+"AND reviewAverage <1.0";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price BETWEEN 1000 AND 1499"
								+"AND reviewAverage <1.0";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price >=1500"
								+"AND reviewAverage <1.0";
						break;
					}
				//(地域✕,ジャンル〇,評価2)★★★
				}else if(reviewId == 2) {
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
							+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
							+"AND price <= 500"
							+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price BETWEEN 501 AND 999"
								+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price BETWEEN 1000 AND 1499"
								+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price >=1500"
								+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					}
				//(地域✕,ジャンル〇,評価3)★★★
				}else if(reviewId == 3) {
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
							+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
							+"AND price <= 500"
							+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price BETWEEN 501 AND 999"
								+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price BETWEEN 1000 AND 1499"
								+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price >=1500"
								+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					}
				//(地域✕,ジャンル〇,評価✕)★★★
				}else if(reviewId == 0) {
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId;
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
							+"AND price <= 500";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price BETWEEN 501 AND 999";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price BETWEEN 1000 AND 1499";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price >=1500";
						break;
					}
				}
			//(地域✕,ジャンル✕)
			}else if(genreId == 0) {
				//(地域✕,ジャンル✕,評価1)★★★
				if(reviewId == 1) {
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE reviewAverage <1.0";
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE price <= 500"
							+"AND reviewAverage <1.0";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE price BETWEEN 501 AND 999"
								+"AND reviewAverage <1.0";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE price BETWEEN 1000 AND 1499"
								+"AND reviewAverage <1.0";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE price >=1500"
								+"AND reviewAverage <1.0";
						break;
					}
				//(地域✕,ジャンル✕,評価2)★★★
				}else if(reviewId == 2) {
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE price <= 500"
							+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE price BETWEEN 501 AND 999"
								+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE price BETWEEN 1000 AND 1499"
								+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE price >=1500"
								+"AND reviewAverage BETWEEN 1.5 AND 3.0";
						break;
					}
				//(地域✕,ジャンル〇,評価3)★★★
				}else if(reviewId == 3) {
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE price <= 500"
							+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE price BETWEEN 501 AND 999"
								+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE price BETWEEN 1000 AND 1499"
								+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE price >=1500"
								+"AND reviewAverage BETWEEN 3.5 AND 5.0";
						break;
					}
				//(地域✕,ジャンル〇,評価✕)★★★
				}else if(reviewId == 0) {
					switch (price){
					case 0:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId;
						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
							+"AND price <= 500";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price BETWEEN 501 AND 999";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price BETWEEN 1000 AND 1499";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE genreId = "+genreId
								+"AND price >=1500";
						break;
					}
				//(地域✕,ジャンル✕,評価✕)★★★
				}else if(reviewId == 0) {
					switch (price){
//					case 0:
//						sql = "SELECT * FROM bathIntegrationEntitiy "
//						
//						break;
					case 1:
						sql = "SELECT * FROM bathIntegrationEntitiy "
							+"WHERE price <= 500";
						break;
					case 2:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE price BETWEEN 501 AND 999";
						break;
					case 3:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE price BETWEEN 1000 AND 1499";
						break;
					case 4:
						sql = "SELECT * FROM bathIntegrationEntitiy "
								+"WHERE price >=1500";
						break;
					}
				}
			}
		}
				
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		
		List<BathIntegrationEntitiy> list = new ArrayList<BathIntegrationEntitiy>();
		
		for(Map<String, Object> result : resultList) {
			BathIntegrationEntitiy bathInfo = new BathIntegrationEntitiy();
			bathInfo.setBathIntegrationEntitiyId((int)result.get("bathIntegrationEntitiyId"));
			bathInfo.setBathName((String)result.get("bathName"));
			bathInfo.setAddress((String)result.get("address"));
			bathInfo.setReviewAverage((double)result.get("reviewAverage"));
			
			list.add(bathInfo);
		}
		return list;
		}
	
}
