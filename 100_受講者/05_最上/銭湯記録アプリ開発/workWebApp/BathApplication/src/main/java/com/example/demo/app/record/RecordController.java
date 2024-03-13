package com.example.demo.app.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.RecordService;

@Controller
@RequestMapping("/top")

public class RecordController {
	
	private final RecordService recordService;
	
	@Autowired
	public RecordController(RecordService recordService) {
		this.recordService = recordService;
	}
	
	@GetMapping("/addBathInfo")
	public String addBthInfo(RecordFrom recordForm, Model model) {
		model.addAttribute("title", "新規登録");
		return "addBath/addBathInfo";
	}
	
	@PostMapping("/getBath")
	public String getBath(@Validated RecordFrom recordForm,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "新規登録");
			return "addBath/addBathInfo";
		}
		model.addAttribute("title", "温泉");
		return "addBath/bathInfo";
	}
	
	
}
