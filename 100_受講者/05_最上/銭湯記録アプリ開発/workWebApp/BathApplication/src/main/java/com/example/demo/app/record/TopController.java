package com.example.demo.app.record;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
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
		List<BathInfo> list = topPageService.getTopBathAll();
		model.addAttribute("bathList",list);
		model.addAttribute("title","top page");
		
		return "top/index";
	}
	
	@GetMapping("/bath/{id}")
	public String getbath( Model model,@PathVariable("id") int id
			) {
		Optional<BathIntegrationEntitiy> list = topPageService.getTopBath(id);
		model.addAttribute("bathList",list.get());
		model.addAttribute("title","温泉");
		
		return "top/bath";
	}
	
	
	
}
