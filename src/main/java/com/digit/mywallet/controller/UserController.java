package com.digit.mywallet.controller;



import javax.servlet.http.HttpSession;

import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;
import com.digit.mywallet.entities.Customer;
import com.digit.mywallet.exceptions.UserNotFoundException;
import com.digit.mywallet.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;

	@GetMapping("/register")
	public ModelAndView LoginPage() {
		System.out.println("done");

		Customer customer=new Customer();

		ModelAndView mv=new ModelAndView("registration");

		mv.addObject("cust",customer);

		return mv;
	}

	@PostMapping("/insert")
	public String insert(@Valid @ModelAttribute("cust") Customer customer,BindingResult bindingResult ,@RequestParam String repassword){

		if(bindingResult.hasErrors()||!repassword.trim().equals(customer.getPassword().trim())){

			return "registration";
		}

		userservice.customerRegistration(customer);

		System.out.println("success");

		return "redirect:/";

	}

	@GetMapping("/")
	public String loginRedirect(){

		return "login";
	}

	@PostMapping("/signIn")
	public String login(@RequestParam String mobileNo,@RequestParam String password ,HttpSession session){

		Customer customer= userservice.validateLogin(mobileNo, password);

		if(customer!=null){

			if(customer.getPassword().trim().equals(password.trim()))
			{   
				session.setAttribute("customer1", customer);
				if(customer.getWallet()!=null)
				{
				   return "redirect:/walletHome/"+customer.getCustomerId();
				}
				return "wallet";
			}
			else {
				
				Exception e=new UserNotFoundException("user not found. Please try again");
				System.out.println(e.getMessage());
				session.setAttribute("exception", e.getMessage());
				
				// mv.addObject("exception" ,e);
				return "redirect:/errorHandler";
			}
		}

		else{
			//session.setAttribute("customer", customer);
			return "redirect:/register";
		}
	}
	
	@GetMapping("/logout")
	public String logoutuser(HttpSession session){
		
		session.invalidate();
	    return "redirect:/";
		
	}
	
	
	
	//#######################################################################################
	
	
	
	
	@GetMapping("/errorHandler")
	public ModelAndView errorPage() {
		ModelAndView mv = new ModelAndView("error");
		return mv;
	}

}

