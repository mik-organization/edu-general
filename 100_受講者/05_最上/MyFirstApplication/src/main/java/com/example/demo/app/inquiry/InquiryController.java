package com.example.demo.app.inquiry;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Inquiry;
import com.example.demo.service.InquiryNotFoundException;
import com.example.demo.service.InquiryService;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {
	
	private final InquiryService inquiryService;	//インターフェース名
	
	@Autowired
	public InquiryController(InquiryService inquiryService) {
		this.inquiryService = inquiryService;
	}
	
	@GetMapping
	public String index(Model model) {
		List<Inquiry> list = inquiryService.getAll();
		
//		Inquiry inquiry = new Inquiry();
//		inquiry.setId(4);
//		inquiry.setName("sasaki");
//		inquiry.setEmail("sample4@example.com");
//		inquiry.setContents("oishii");
//		
//		inquiryService.update(inquiry);
//		
//		try {
//			inquiryService.update(inquiry);
//		}catch(InquiryNotFoundException e) {
//			model.addAttribute("message", e);
//			return "error/CustomPage";
//		}
		
		model.addAttribute("inquiryList", list);
		model.addAttribute("title", "Inquiry Index");
		
		return "inquiry/index_boot";
	}
	
	@GetMapping("/form")	//URLでアクセスした場合
	public String form(InquiryForm inquiryForm ,
			Model model,
			@ModelAttribute("complete") String complete) {
		model.addAttribute("title", "Inquiry Form");
		return "inquiry/form_boot";
	}
	
	@PostMapping("/form")	//GoBackボタンを押してアクセスした場合
	public String formGoBack(InquiryForm inquiryForm ,Model model) {
		model.addAttribute("title", "Inquiry Form");
		return "inquiry/form_boot";
	}

	@PostMapping("/confirm")	//@Validated
	public String confirm(@Validated InquiryForm inquiryForm ,	
			BindingResult result,
			Model model) {
		//エラーのありなしで出力するページを判定する
		if(result.hasErrors()) {
			model.addAttribute("title","Inquiry Form");
			return "inquiry/form_boot";
		}
		model.addAttribute("title", "Confirm Page");
		return "inquiry/confirm_boot";
	}
	
	@PostMapping("/complete")	//もう一度Validatedで確認する（HTMLは書き換えることができるため）
	public String complete(@Validated InquiryForm inquiryForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			model.addAttribute("title","Inquiry Form");
			return "inquiry/form_boot";
		}
		
		//DB操作
		Inquiry inquiry  = new Inquiry();	//InquiryFormクラスからInquiryクラス（Entity）にデータを詰め替える
		inquiry.setName(inquiryForm.getName());	//テーブルが二つに跨っている時など返ってくる内容に相違があることが多いので絶対行う
		inquiry.setEmail(inquiryForm.getEmail());
		inquiry.setContents(inquiryForm.getContents());
		inquiry.setCreated(LocalDateTime.now());	//inquiryFormから値が返らないのでここで生成する
		
		inquiryService.save(inquiry);	//DB登録される
		
		redirectAttributes.addFlashAttribute("complete", "Registered!");
		return "redirect:/inquiry/form";
	}
	//controller内のメソッドで例外を補足する方法
	//１つのcontroller内で発生した同じ例外の名称に対して共通処理
//	@ExceptionHandler(InquiryNotFoundException.class)
//	public String handleException(InquiryNotFoundException e, Model model) {
//		model.addAttribute("message",e);
//		return "error/CustomPage";
//	}

}
