package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Inquiry;


@Repository		//DBを操作するクラスだとDIコンテナにわかってもらう
public class InquiryDaoImpl implements InquiryDao {
	
	private final JdbcTemplate jdbcTemplate;		//DB操作用のクラス
	
	//JdbcTemplateを読み込むのに@Autowiredを記載し、デフォルトコンストラクタを使う
	@Autowired public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	//DIコンテナで生成されたインスタンスが渡されてjdbcTemplateに代入
	}

	@Override
	public void insertInquiry(Inquiry inquiry) {
		jdbcTemplate.update("INSERT INTO inquiry(name, email, contents, created) VALUES(?,?,?,?)",
				inquiry.getName(),inquiry.getEmail(),inquiry.getContents(),inquiry.getCreated());

	}

	@Override
	public List<Inquiry> getAll() {
		String sql = "SELECT id, name, email, contents, created FROM inquiry ";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql) ;
		List<Inquiry> list = new ArrayList<Inquiry>();		//Mapの中身をInquiryへ詰めなおす
		for(Map<String, Object> result :  resultList) {
			Inquiry inquiry = new Inquiry();
			inquiry.setId((int)result.get("id"));	//Object型で取り出されるためそれぞれ型変換が必要
			inquiry.setName((String)result.get("name"));
			inquiry.setEmail((String)result.get("email"));
			inquiry.setContents((String)result.get("contents"));
			inquiry.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
			list.add(inquiry);			
		}
		return list;
		
		
	}

	@Override
	public int updateInquiry(Inquiry inquiry) {
		return jdbcTemplate.update("UPDATE inquiry SET name = ?, email=?, contents=? WHERE id = ?",
				inquiry.getName(),inquiry.getEmail(),inquiry.getContents(),inquiry.getId());
	}

}
