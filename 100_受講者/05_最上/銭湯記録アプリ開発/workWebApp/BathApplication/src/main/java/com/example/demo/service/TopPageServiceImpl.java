package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RecordDao;
import com.example.demo.dao.TopPageDao;
import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.Comment;

@Service
public class TopPageServiceImpl implements TopPageService {
	
	private final TopPageDao dao;
	
	@Autowired TopPageServiceImpl(TopPageDao dao){
		this.dao = dao;
	}

	@Override
	public List<BathIntegrationEntitiy> getTopBathAll() {
		return dao.getTopBathAll();
	};
	
	@Override
	public Optional<BathIntegrationEntitiy> getTopBath(int id){
		
		//Optional<BathIntegrationEntitiy>　１件を取得でIDがなければ例外発生
		try {
			return dao.getTopBath(id);
		}catch(EmptyResultDataAccessException e) {
			throw new TopPageNotFoundException("指定された施設情報が存在しません。");
		}
	};
	
	@Override
	public List<BathIntegrationEntitiy> getSearchBath(String arg){
		if (dao.getSearchBath(arg).isEmpty()) {
			throw new TopPageNotFoundException("検索キーワードに当てはまる施設情報はありません。");
		}
		return dao.getSearchBath(arg);
		
	};
	
	@Override
	public List<BathIntegrationEntitiy> getChoiceBath(int areaId, int price, int genreId, int reviewId){
		if (dao.getChoiceBath(areaId, price, genreId, reviewId).isEmpty()) {
			throw new TopPageNotFoundException("絞り込みに当てはまる施設情報はありません。");
		}
			return  dao.getChoiceBath(areaId, price, genreId, reviewId);
		
	};
}
