package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InquiryDao;
import com.example.demo.entity.Inquiry;

@Service	//DIコンテナでsingletonとしてインスタンス化される
public class InquiryServiceImpl implements InquiryService {
	
	private final InquiryDao dao;	//Daoクラスを読み込む際インターフェース名の型にする
	
	@Autowired
	InquiryServiceImpl(InquiryDao dao){
		this.dao = dao;
	}

	@Override
	public void save(Inquiry inquiry) {
		dao.insertInquiry(inquiry);

	}

	@Override
	public List<Inquiry> getAll() {
		return dao.getAll();
	}

	@Override
	public void update(Inquiry inquiry) {
		if(dao.updateInquiry(inquiry)==0) {		//UPDATE処理が0件であるかどうか
			throw new InquiryNotFoundException("can't find the same ID");
		}
		
	}

}
