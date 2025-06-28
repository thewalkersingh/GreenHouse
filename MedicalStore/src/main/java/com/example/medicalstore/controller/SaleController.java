package com.example.medicalstore.controller;
import com.example.medicalstore.model.Sale;
import com.example.medicalstore.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaleController {
	@Autowired
	private SaleService saleService;
	
	@GetMapping("/sales")
	public String getAllSales(Model model) {
		model.addAttribute("sales", saleService.getAllSales());
		return "sales";
	}
	
	@GetMapping("/sales/new")
	public String createSaleForm(Model model) {
		model.addAttribute("sale", new Sale());
		return "create_sale";
	}
	
	@PostMapping("/sales")
	public String saveSale(Sale sale) {
		saleService.saveSale(sale);
		return "redirect:/sales";
	}
}