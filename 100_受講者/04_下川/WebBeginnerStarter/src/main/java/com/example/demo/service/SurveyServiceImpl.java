package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SurveyDao;
import com.example.demo.entity.Survey;

@Service
public class SurveyServiceImpl implements SurveyService {

	private final SurveyDao dao;

	@Autowired SurveyServiceImpl(SurveyDao dao){
		this.dao = dao;
	}

	@Override
	public void save(Survey survey) {
		dao.insertSurvey(survey);
	}

	@Override
	public List<Survey> getAll() {
		if(dao.getAll().isEmpty()) {
			throw new SurveyNotFoundException("SQL error");
		}
		return dao.getAll();
	}

	@Override
	public void update(Survey survey) {
		if(dao.updateSurvey(survey) == 0) {
			throw new SurveyNotFoundException("can't find the same ID");
	}

}
}
