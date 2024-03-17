package com.digit.mywallet.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digit.mywallet.entities.Customer;
import com.digit.mywallet.services.WalletService;

//import com.digit.mywallet.services.WalletService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WalletController {
	
	private final WalletService walletService;
	
	@GetMapping("/walletHome/{id}")
	public ModelAndView walletHomePage(@PathVariable int id,HttpSession session) {
		if(session.getAttribute("customer1")!=null) {
		ModelAndView homeView = new ModelAndView("homeView");
		session.setAttribute("customer",walletService.findCustomerById(id) );
		session.setAttribute("wallet", walletService.findCustomerById(id).getWallet());
		homeView.addObject("wallet",walletService.findCustomerById(id).getWallet());
		homeView.addObject("customer",walletService.findCustomerById(id));
		
		
		return homeView;
		}
		else {
			return new ModelAndView("login");
		}
		
	}
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam("name") String name,@RequestParam("mobileNumber") String mobileNumber,@RequestParam("amount") BigDecimal amount ){
		
		Customer customer = walletService.createAccount(name, mobileNumber, amount);
		return "redirect:/walletHome/"+customer.getCustomerId();
		
	}
	
	@PostMapping("/create")
	public Customer createCustomer(@RequestBody Customer customer) {
		return walletService.createAccountCustomer(customer);
	}
	
	
	@GetMapping("/showBalance/{mobileNumber}")
	public Customer showBalance(@PathVariable String mobileNumber) {
		return walletService.showBalance(mobileNumber);
	}
	
	@PostMapping("/fundTransfer/{walletId}")
	public String fundTransfer(@RequestParam("sourceMobileNo") String sourceMobileNo,@RequestParam("targetMobileNo") String targetMobileNo,@RequestParam("amount") BigDecimal amount,@RequestParam("transactionType") String transactionType,@RequestParam("description") String description,@PathVariable int walletId ,HttpSession session) {
		if(session.getAttribute("customer1")!=null) {
		System.out.println(description);
		walletService.fundTransfer(sourceMobileNo, targetMobileNo, amount);
		Customer customer = walletService.showBalance(sourceMobileNo);
		return "redirect:/transaction/"+amount+"/"+description.toString()+"/"+transactionType+"/"+walletId+"/"+customer.getCustomerId();
		}
		else {
			return "redirect:/";
		}
		
	}
		
		@PostMapping("/depositAmount")

		public String depositAmount(@RequestParam("mobileNumber") String mobileNo,@RequestParam("amount") BigDecimal amount,HttpSession session) {

		Customer target_customer = walletService.showBalance(mobileNo);

		Customer source_customer = (Customer)session.getAttribute("customer");
		if(source_customer.getCustomerId()==target_customer.getCustomerId())
		{

		walletService.depositAmount(mobileNo, amount);

		}
		return "redirect:/walletHome/"+source_customer.getCustomerId();

		}
		
		

	@GetMapping("/getAll")
	public List<Customer> getList(){
		return walletService.getList();
	}
	
	@GetMapping("/update1")
	public String sendToUpdatePage()
	{
		return "update";
	}
	
	
	@PostMapping("/updateAccount/{id}")
	public String updateAccount(@RequestParam("name") String name,@RequestParam("mobileNumber") String mobileNumber,@RequestParam("password") String password ,@PathVariable int id, HttpSession session) {
		if(session.getAttribute("customer1")!=null){
		Customer customer= walletService.updateAccount(name,mobileNumber,password,id);
		session.setAttribute("customer1", customer);
		return "redirect:/walletHome/"+walletService.showBalance(mobileNumber).getCustomerId();}
		else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/depositAmount/{customerId}")
	public String addMoneyToWallet(@PathVariable int customerId,@RequestParam("amount") double amount,HttpSession session) {
		if(session.getAttribute("customer1")!=null) {
		walletService.addMoney(customerId, amount);
		return "redirect:/walletHome/"+customerId;}
		else {
			return "redirect:/";
		}
	}
	
	
	

}
