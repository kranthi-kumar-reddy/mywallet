package com.digit.mywallet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.digit.mywallet.entities.BeneficiaryDetails;

import com.digit.mywallet.services.BeneficiaryService;

@Controller
public class BeneficiaryDetailsController {

	@Autowired
	BeneficiaryService service;

	@GetMapping("/add-beneficiary")
	public ModelAndView addBeneficiaryDetails() {
		ModelAndView mv = new ModelAndView("add-beneficiary");
		mv.addObject("beneficiary", new BeneficiaryDetails());
		return mv;
	}

	@PostMapping("/save-beneficiary")
	public String addBeneficiaryDetails(@ModelAttribute BeneficiaryDetails bd) {
	
		service.addBeneficiaryDetails(bd);

		return "redirect:/viewall";
	}

	@GetMapping("/view/{beneficiaryMobileNumber}")
	public ModelAndView viewBeneficiaryDetails(@PathVariable String beneficiaryMobileNumber) {
		ModelAndView mv = new ModelAndView("view");
		BeneficiaryDetails bd = service.viewBeneficiaryDetails(beneficiaryMobileNumber);
		mv.addObject("beneficiary", bd);
		return mv;
	}

	@GetMapping("/viewall")
	public ModelAndView viewAllBeneficiaryDetails(HttpSession session) {
		if(session.getAttribute("customer1")!=null) {
		List<BeneficiaryDetails> bd = service.getAllBeneficiaryDetails();
		ModelAndView mv = new ModelAndView("viewall");
		mv.addObject("beneficiary", bd);
		return mv;}
		else
		{
			return new ModelAndView("login");
		}
	}

	@GetMapping("/delete-beneficiary/{mobileNumber}")
	public String deleteBeneficiaryDetails(@PathVariable String mobileNumber) {
		service.deleteBeneficiaryDetails(service.viewBeneficiaryDetails(mobileNumber));
		return "redirect:/viewall";
	}
}
