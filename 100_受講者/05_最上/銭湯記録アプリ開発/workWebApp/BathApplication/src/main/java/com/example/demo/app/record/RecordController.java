package com.example.demo.app.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.BathInfo;
import com.example.demo.service.RecordService;
import com.example.demo.app.*;

@Controller
@RequestMapping("/top")
public class RecordController {
	
	private final RecordService recordService;
	
	@Autowired
	public RecordController(RecordService recordService) {
		this.recordService = recordService;
	}

	@GetMapping("/addBathInfo")
	public String addBthInfo(@ModelAttribute RecordFrom recordForm, Model model
			) {
		model.addAttribute("title", "新規登録");
		return "addBath/addBathInfo";
	}
	
	@PostMapping("/addBathInfo")
	public String formGoBack(@ModelAttribute RecordFrom recordForm, Model model) {
		model.addAttribute("title", "新規登録");
		return "addBath/addBathInfo";
	}
//	
//	@PostMapping("/confirm")
//	public String confirm(@Validated RecordFrom recordForm,
//			BindingResult result, Model model) {
//		if(result.hasErrors()) {
//			model.addAttribute("title", "新規登録");
//			return "addBath/addBathInfo";
//		}
//		model.addAttribute("title", "Confirm Page");
//		return "addBath/bathInfo";
//	}
//	
	
		
	
	@PostMapping("/getBath")
	public String getBath(@Validated RecordFrom recordForm,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "新規登録");
			return "addBath/addBathInfo";
		}
		BathInfo bathInfo = new BathInfo();
		bathInfo.setBathName(recordForm.getBathName());
		bathInfo.setAddress(recordForm.getAddress());
		bathInfo.setOpenTime(recordForm.getOpenTime());
		bathInfo.setCloseTime(recordForm.getCloseTime());
		bathInfo.setPrice(recordForm.getPrice());
		bathInfo.setTel(recordForm.getTel());
		bathInfo.setRoten(recordForm.getIsRoten());
		bathInfo.setSauna(recordForm.getIsSauna());
		
		recordService.createBathInfo(bathInfo);
				
		model.addAttribute("title", "温泉");
		
		return "addBath/bathInfo";
	}
	
	
}
