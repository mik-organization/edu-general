package com.example.demo.app.record;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.Comment;
import com.example.demo.service.RecordService;
import com.example.demo.service.TopPageService;

@Controller
@RequestMapping("/top")
public class TopController {

	private final TopPageService topPageService;
	
	@Autowired
	public TopController(TopPageService topPageService) {
		this.topPageService = topPageService;
	}
	
	@GetMapping
	public String index(Model model) {
		List<BathIntegrationEntitiy> list = topPageService.getTopBathAll();
		model.addAttribute("bathList",list);
		model.addAttribute("title","銭湯レコード");
		
		return "top/index";
	}
	
	@GetMapping("/bath/{id}")
	public String getbath( Model model,@PathVariable("id") int id
			) {
		Optional<BathIntegrationEntitiy> list = topPageService.getTopBath(id);
//		List<Comment> commentlist = topPageService.getCommentList(id);
		model.addAttribute("bathList",list.get());
//		model.addAttribute("commentlist",commentlist);
		model.addAttribute("title","温泉");
		
		return "top/bath";
	}
	
	//検索
	@PostMapping("/search")
	public String search( Model model ,
			@ModelAttribute("keyWord") String arg) {
		System.out.println("msg:" + arg);
		
		List<BathIntegrationEntitiy> list = topPageService.getSearchBath(arg);
		model.addAttribute("bathList",list);
		model.addAttribute("title","検索結果");
		
		return "top/search";
	}
	
	//絞り込み
	@PostMapping("/choice")
	public String choice( Model model ,
			@ModelAttribute("areaId") int areaId,
			@ModelAttribute("price") int price,
			@ModelAttribute("genreId") int genreId,
			@ModelAttribute("reviewId") int reviewId
			) {
		
		List<BathIntegrationEntitiy> list = topPageService.getChoiceBath(areaId, price, genreId, reviewId);
		model.addAttribute("bathList",list);
		model.addAttribute("title","絞り込み結果");
		
		return "top/choice";
	}
}
