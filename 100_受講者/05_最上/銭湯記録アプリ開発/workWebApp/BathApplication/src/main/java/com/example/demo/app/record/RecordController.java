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

import com.example.demo.entity.Bath;
import com.example.demo.entity.BathInfo;
import com.example.demo.entity.BathIntegrationEntitiy;
import com.example.demo.entity.Comment;
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
		BindingResult result, Model model){
		
		BathInfo bathInfo = makeBathInfo(recordForm,0);
		Bath bath = makeBath(recordForm,0);
		BathIntegrationEntitiy bathIntegrationEntitiy = makeBathtegrationEntitiy(recordForm,0);
		Comment comment =  makeComment(recordForm,0);
//		BathIntegrationEntitiy bathIntegrationEntitiy = makeBathInfo(recordForm, 0);

		recordService.insert(bathInfo, bath, bathIntegrationEntitiy, comment);

//		topPageService.getTopBath(id);
//		System.out.println("▲▲"+id);
		return "top/bath";
	}

	@GetMapping("/bath/update/{id}")
	public String updateBathInfo(RecordFrom recordForm,@PathVariable("id") int id,
			Model model) {
		
		Optional<BathIntegrationEntitiy> bathOpt = topPageService.getTopBath(id);
		
		Optional<RecordFrom> recoFromOpt = bathOpt.map(t -> makeRecordFrom(t));
		
		if(recoFromOpt.isPresent()) {
			recordForm = recoFromOpt.get();
		}
		
		model.addAttribute("recordForm",recordForm );
		List<BathIntegrationEntitiy> list = recordService.getAll();
		model.addAttribute("list", list);
		model.addAttribute("bathInfoId", id);
		model.addAttribute("title", "編集");
		
		return "addBath/update";
	}
	
	
	
	@PostMapping("addBath/update")
	public String updateBath(@Validated @ModelAttribute RecordFrom recordForm,
			BindingResult result, @RequestParam("bathInfoId")int bathInfoId ){
		
		BathIntegrationEntitiy bathIntegrationEntitiy = makeBathtegrationEntitiy(recordForm, bathInfoId);
		
		recordService.editBathInfo(bathIntegrationEntitiy);
		return "bath/"+bathInfoId;
		
	};
	
	//
	@PostMapping("/deleteBathInfo")
	public String deleteBathInfo(@RequestParam("bathInfoId")int id, Model model) {
		recordService.delBathInfo(id);
		return "top/";
	}
	
	//
	private BathInfo makeBathInfo(RecordFrom recordForm,int bathInfoId) {
		BathInfo bathInfo = new BathInfo();
		
		if(bathInfoId != 0) {
			bathInfo.setBathInfoId(bathInfoId) ;
		}
//		bathInfo.setBathInfoId(recordForm.getBathInfoId());
		bathInfo.setBathName(recordForm.getBathName());
		bathInfo.setAddress(recordForm.getAddress());
		bathInfo.setOpenTime(recordForm.getOpenTime());
		bathInfo.setCloseTime(recordForm.getCloseTime());
		bathInfo.setPrice(recordForm.getPrice());
		bathInfo.setTel(recordForm.getTel());
		bathInfo.setRoten(recordForm.getIsRoten());
		bathInfo.setSauna(recordForm.getIsSauna());
		
		return bathInfo;
	}
	
	private Bath makeBath(RecordFrom recordForm,int bathId) {
		Bath bath = new Bath();
		
		if(bathId != 0) {
			bath.setBathId(bathId) ;
		}
		
		bath.setBathInfoId(recordForm.getBathInfoId());
//		bath.setBathId(recordForm.getBathId());
		bath.setGenreId(recordForm.getGenreId());
		bath.setAreaId(recordForm.getAreaId());
		
		System.out.println("★★"+recordForm.getBathId());
		
		return bath;
	}
	
	private Comment makeComment(RecordFrom recordForm, int commentId) {
		
		Comment comment = new Comment();
		
		if(commentId != 0) {
			comment.setBathInfoId(commentId) ;
		}

		comment.setBathInfoId(recordForm.getBathInfoId());
		comment.setComment(recordForm.getComments());
		comment.setReviewId(recordForm.getReviewId());
		comment.setRecordDate(recordForm.getRecordDate());
		
		return comment;
	}
		
	private BathIntegrationEntitiy makeBathtegrationEntitiy(RecordFrom recordForm ,int bathtegrationEntitiyId) {
		
		BathIntegrationEntitiy bathIntegrationEntitiy = new BathIntegrationEntitiy();
		
		if(bathtegrationEntitiyId != 0) {
			bathIntegrationEntitiy.setBathInfoId(bathtegrationEntitiyId) ;
		}
		
//		bathIntegrationEntitiy.setBathIntegrationEntitiyId(recordForm.getBathIntegrationEntitiyId());
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
	
//	private BathIntegrationEntitiy makeBathtegrationEntitiy(RecordFrom recordForm, int bathInfoId) {
//		
//		BathIntegrationEntitiy bathIntegrationEntitiy = new BathIntegrationEntitiy();
//		
//		if(bathInfoId != 0) {
//			bathIntegrationEntitiy.setBathInfoId(bathInfoId) ;
//		}
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
//		
//		return bathIntegrationEntitiy;
//	}
//	
	
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
	