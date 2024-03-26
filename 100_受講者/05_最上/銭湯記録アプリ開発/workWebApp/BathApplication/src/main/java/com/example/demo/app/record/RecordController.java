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
	
	//新規登録画面を表示
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
	
	@PostMapping("/insert")
	public String insert(
		@Validated @ModelAttribute RecordFrom recordForm,
		BindingResult result, Model model){
		
		BathIntegrationEntitiy bathIntegrationEntitiy = makeBathtegrationEntitiy(recordForm,0);

		recordService.insert(bathIntegrationEntitiy);

		return "redirect:/top";
	}
	
	@GetMapping("/bath/update/{id}")
	public String updateBathInfo(RecordFrom recordForm,@PathVariable("id") int id,
			Model model) {
		
		Optional<BathIntegrationEntitiy> bathOpt = topPageService.getTopBath(id);
//		List<Comment> commentlist = topPageService.getCommentList(id);
		
		Optional<RecordFrom> recoFromOpt = bathOpt.map(t -> makeRecordFrom(t));
		
		if(recoFromOpt.isPresent()) {
			recordForm = recoFromOpt.get();
		}
		
		model.addAttribute("recordForm",recordForm );
		List<BathIntegrationEntitiy> list = topPageService.getTopBathAll();
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
		
		return "redirect:/top";
		
	};
	
	//削除
	@PostMapping("/deleteBathInfo")
	public String deleteBathInfo(@RequestParam("bathInfoId")int id, Model model) {
		recordService.delBathInfo(id);
		return "redirect:/top";
	}

	//コメント追加
	@PostMapping("/updateExComment")
	public String updateExComment(@Validated @ModelAttribute RecordFrom recordForm,
			BindingResult result, @RequestParam("bathInfoId")int bathInfoId ){
		
		BathIntegrationEntitiy bathIntegrationEntitiy = makeComment(recordForm, bathInfoId);
		
		recordService.updateExComment(bathIntegrationEntitiy);
		
		return "redirect:/top";
		
	};
	
	private BathIntegrationEntitiy makeBathtegrationEntitiy(RecordFrom recordForm ,int bathtegrationEntitiyId) {
		BathIntegrationEntitiy bathIntegrationEntitiy = new BathIntegrationEntitiy();
		if(bathtegrationEntitiyId != 0) {
			bathIntegrationEntitiy.setBathIntegrationEntitiyId(bathtegrationEntitiyId) ;
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
		bathIntegrationEntitiy.setReviewId(recordForm.getReviewId());
		bathIntegrationEntitiy.setReviewValue(recordForm.getReviewValue());
		bathIntegrationEntitiy.setRecordDate(recordForm.getRecordDate());
		
		System.out.println("comment:::::"+recordForm.getComments());
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
		recordFrom.setGenreId(bathInfo.getGenreId());
		recordFrom.setAreaId(bathInfo.getAreaId());
		recordFrom.setComments(bathInfo.getComments());
		recordFrom.setReviewId(bathInfo.getReviewId());
		recordFrom.setReviewValue(bathInfo.getReviewValue());
		recordFrom.setRecordDate(bathInfo.getRecordDate());
		System.out.println("comment:::::"+bathInfo.getComments());
		return recordFrom;
	}
	
	//コメントの追加
	private BathIntegrationEntitiy makeComment(RecordFrom recordForm ,int bathtegrationEntitiyId) {
		BathIntegrationEntitiy bathIntegrationEntitiy = new BathIntegrationEntitiy();
		
		bathIntegrationEntitiy.setBathIntegrationEntitiyId(bathtegrationEntitiyId) ;
		bathIntegrationEntitiy.setBathInfoId(recordForm.getBathInfoId());
//		List<String> commentList = new ArrayList<>();
//		commentList.add(recordForm.getComments());
		bathIntegrationEntitiy.setComments(recordForm.getComments());
		bathIntegrationEntitiy.setReviewValue(recordForm.getReviewValue());
		bathIntegrationEntitiy.setRecordDate(recordForm.getRecordDate());
		System.out.println("komennto@@@@@"+recordForm.getComments());
		
		return bathIntegrationEntitiy;
	}
}
	