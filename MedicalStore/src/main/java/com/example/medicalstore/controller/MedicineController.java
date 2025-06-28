package com.example.medicalstore.controller;
import com.example.medicalstore.model.Medicine;
import com.example.medicalstore.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/medicines")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("")
	public String getAllMedicines(Model model) {
		List<Medicine> medicines = medicineService.getAllMedicines();
		model.addAttribute("medicines", medicines);
		return "medicines";
	}
	
	@GetMapping("/new")
	public String createMedicineForm(Model model) {
		model.addAttribute("medicine", new Medicine());
		return "create_medicine";
	}
	
	@PostMapping("")
	public String saveMedicine(@ModelAttribute("medicine") Medicine medicine) {
		medicineService.saveMedicine(medicine);
		return "redirect:/medicines";
	}
}