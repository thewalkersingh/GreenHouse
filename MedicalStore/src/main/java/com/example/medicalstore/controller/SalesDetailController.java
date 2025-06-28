package com.example.medicalstore.controller;
import com.example.medicalstore.model.SalesDetail;
import com.example.medicalstore.service.SalesDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SalesDetailController {
	@Autowired
	private SalesDetailService salesDetailService;
	
	@GetMapping("/salesdetails")
	public String getAllSalesDetails(Model model) {
		model.addAttribute("salesDetails", salesDetailService.getAllSalesDetails());
		return "salesdetails";
	}
	
	@GetMapping("/salesdetails/new")
	public String createSalesDetailForm(Model model) {
		model.addAttribute("salesDetail", new SalesDetail());
		return "create_salesdetail";
	}
	
	@PostMapping("/salesdetails")
	public String saveSalesDetail(SalesDetail salesDetail) {
		salesDetailService.saveSalesDetail(salesDetail);
		return "redirect:/salesdetails";
	}
}