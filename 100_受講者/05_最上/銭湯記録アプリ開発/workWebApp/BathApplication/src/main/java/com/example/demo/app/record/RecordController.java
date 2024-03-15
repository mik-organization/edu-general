package com.example.demo.app.record;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.service.RecordService;
import com.example.demo.service.TopPageService;

@Controller
@RequestMapping("/top")
public class RecordController {
	
	private final RecordService recordService;
	private final TopPageService topPageService;
	
	@Autowired
	public RecordController(RecordService recordService,TopPageService topPageService) {
		this.recordService = recordService;
		this.topPageService = topPageService;
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
	
	
	@PostMapping("/insert")
	public String insert(
			@Validated @ModelAttribute RecordFrom recordForm,
			BindingResult result, Model model) {
//		BathIntegrationEntitiy bathIntegrationEntitiy = new BathIntegrationEntitiy();
//		
//		bathIntegrationEntitiy.setBathIntegrationEntitiyId(recordForm.getBathIntegrationEntitiyId());
//		bathIntegrationEntitiy.setBathInfoId(recordForm.getBathInfoId());
//		bathIntegrationEntitiy.setBathName(recordForm.getBathName());
//		bathIntegrationEntitiy.setAddress(recordForm.getAddress());
//		bathIntegrationEntitiy.setOpenTime(recordForm.getOpenTime());
//		bathIntegrationEntitiy.setCloseTime(recordForm.getCloseTime());
//		bathIntegrationEntitiy.setPrice(recordForm.getPrice());
//		bathIntegrationEntitiy.setTel(recordForm.getTel());
//		bathIntegrationEntitiy.setRoten(recordForm.getIsRoten());
//		bathIntegrationEntitiy.setSauna(recordForm.getIsSauna());
//		bathIntegrationEntitiy.setBathId(recordForm.getBathId());
//		bathIntegrationEntitiy.setGenreId(recordForm.getGenreId());
//		bathIntegrationEntitiy.setAreaId(recordForm.getAreaId());
//		bathIntegrationEntitiy.setComments(recordForm.getComments());
		
		BathIntegrationEntitiy bathIntegrationEntitiy = makeBathInfo(recordForm, 0);
		
		recordService.insert(bathIntegrationEntitiy);
		return "update/{id}";
	}

	@GetMapping("update/{id}")
	public String updateBathInfo(RecordFrom recordForm,@PathVariable int id,
			Model model) {
		
		Optional<BathIntegrationEntitiy> bathOpt = topPageService.getTopBath(id);
		
		Optional<RecordFrom> recoFromOpt = bathOpt.map(t -> makeRecordFrom(t));
		
		if(recoFromOpt.isPresent()) {
			recordForm = recoFromOpt.get();
		}
		
		model.addAttribute("recordForm",recordForm );
		List<BathInfo> list = recordService.getAll();
		model.addAttribute("list", list);
		model.addAttribute("bathInfoId", id);
		model.addAttribute("title", "編集");
		
		return "addBath/update";
	}
	
	
	
	@PatchMapping("/update")
	public String updateBath(@Validated @ModelAttribute RecordFrom recordForm,
			BindingResult result, @RequestParam("bathInfoId")int bathInfoId ){
		BathIntegrationEntitiy bathIntegrationEntitiy = makeBathInfo(recordForm, bathInfoId);
		
		recordService.editBathInfo(bathIntegrationEntitiy);
		return "/"+bathInfoId;
		
	};
	
	//
	@PostMapping("/deleteBathInfo")
	public String deleteBathInfo(@RequestParam("bathInfoId")int id, Model model) {
		recordService.delBathInfo(id);
		return "top/";
	}
	
	//
	private BathIntegrationEntitiy makeBathInfo(RecordFrom recordForm, int bathInfoId) {
		BathIntegrationEntitiy bathIntegrationEntitiy = new BathIntegrationEntitiy();
		
		if(bathInfoId != 0) {
			bathIntegrationEntitiy.setBathInfoId(bathInfoId) ;
		}
		bathIntegrationEntitiy.setBathIntegrationEntitiyId(recordForm.getBathIntegrationEntitiyId());
		bathIntegrationEntitiy.setBathInfoId(recordForm.getBathInfoId());
		bathIntegrationEntitiy.setBathName(recordForm.getBathName());
		bathIntegrationEntitiy.setAddress(recordForm.getAddress());
		bathIntegrationEntitiy.setOpenTime(recordForm.getOpenTime());
		bathIntegrationEntitiy.setCloseTime(recordForm.getCloseTime());
		bathIntegrationEntitiy.setPrice(recordForm.getPrice());
		bathIntegrationEntitiy.setTel(recordForm.getTel());
		bathIntegrationEntitiy.setRoten(recordForm.getIsRoten());
		bathIntegrationEntitiy.setSauna(recordForm.getIsSauna());
		bathIntegrationEntitiy.setBathId(recordForm.getBathId());
		bathIntegrationEntitiy.setGenreId(recordForm.getGenreId());
		bathIntegrationEntitiy.setAreaId(recordForm.getAreaId());
		bathIntegrationEntitiy.setComments(recordForm.getComments());
		
		return bathIntegrationEntitiy;
	}
	
	
	
	//データをRecordFormに詰めなおす
	private RecordFrom makeRecordFrom(BathIntegrationEntitiy bathInfo) {
		RecordFrom recordFrom = new RecordFrom();
		
		recordFrom.setBathName(bathInfo.getBathName());
		recordFrom.setAddress(bathInfo.getAddress());
		recordFrom.setOpenTime(bathInfo.getOpenTime());
		recordFrom.setCloseTime(bathInfo.getCloseTime());
		recordFrom.setPrice(bathInfo.getPrice());
		recordFrom.setTel(bathInfo.getTel());
		recordFrom.setRoten(bathInfo.isRoten());
		recordFrom.setSauna(bathInfo.isSauna());
		
		return recordFrom;
	}
}
	