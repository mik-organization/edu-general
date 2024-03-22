package com.example.demo.app.record;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.SearchWord;
import com.example.demo.service.SearchService;
import com.example.demo.service.TopPageService;

@Controller
@RequestMapping("/top")
public class SearchController {
	private final SearchService searchService;
	
	@Autowired
	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}
	
//	@GetMapping("/search")
//	public String search(@Validated SearchForm searchForm,
//	BindingResult result, Model model) {
//		SearchWord searchWord = new SearchWord();
//		searchWord.setSearchWord(searchWord.getSearchWord());
//		
//		searchService.fetchBath(searchWord);
//		model.addAttribute("title", "検索結果");
//		return "top/index";
//	}
//	
}
