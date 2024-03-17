package com.digit.mywallet.controller;



import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digit.mywallet.entities.Customer;
import com.digit.mywallet.entities.Transaction;

import com.digit.mywallet.entities.Wallet;
import com.digit.mywallet.repositories.IUserRepository;
import com.digit.mywallet.repositories.IWalletRepository;
import com.digit.mywallet.services.TransactionService;
import com.digit.mywallet.services.UserService;
import com.digit.mywallet.services.WalletService;



@Controller

public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@Autowired
	IWalletRepository walletService;

	@Autowired
	IUserRepository userService;








	@GetMapping("/viewTransactionsByWalletId/{id}")

	public ModelAndView getAllTransactions(@PathVariable int id){



		List<Transaction> tranList = transactionService.viewAllTransactions(transactionService.getWalletByWalletId(id));

		ModelAndView mv = new ModelAndView("indexOfTransactions");

		mv.addObject("trans", tranList);

		return mv;

	}





	@GetMapping("/transaction/{amount}/{description}/{transactionType}/{walletId}/{customerId}")

	public String addTransaction(@PathVariable BigDecimal amount,@PathVariable String description,@PathVariable String transactionType,@PathVariable int walletId,@PathVariable int customerId) {
		Wallet wallet = transactionService.getWalletByWalletId(walletId);
		

		Transaction transaction = new Transaction();
		transaction.setAmount(amount.longValue());
		transaction.setDescription(description);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionType(transactionType);
		transaction.setWallet(wallet);

		transactionService.addTransaction(transaction);

		Customer customer = userService.findById(customerId).get();

		return "redirect:/walletHome/"+customer.getCustomerId();

	}



	//@GetMapping("/viewTransactions")
	//
	//public String viewAllTransactions(@RequestBody Wallet wallet){
	//
	// 
	//
	//return "redirect:/viewTransactionsByWalletId/"+wallet.getWalletId();
	//
	// 
	//
	//}



	@GetMapping("/getTransByDate/{walletId}")
    
	public ModelAndView viewTransactionsByDate(@RequestParam("transaction-start") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate from,@RequestParam("transaction-end") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate to,@PathVariable("walletId") int walletId){

		 

		System.out.println(from+"...."+to);

		List<Transaction> transactions = transactionService.viewTransactionsByDate(from, to, walletId);

		ModelAndView viewPage = new ModelAndView("indexOfTransactions");

		viewPage.addObject("trans",transactions);

		return viewPage;

		 

		 

		}
	
	
	
	
	
	
	
	
	
	
	
//	public ModelAndView viewTransactionsByDate(@RequestParam("transaction-start") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate from,@RequestParam("transaction-end") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate to){
//
//		System.out.println(from+"...."+to);
//		List<Transaction> transactions =  service.viewTransactionsByDate(from, to);
//		ModelAndView viewPage = new ModelAndView("indexOfTransactions");
//		viewPage.addObject("trans",transactions);
//		return viewPage;
//
//
//	}



	@GetMapping("/getTransByType/{type}")

	public List<Transaction> viewAllTransactions(@PathVariable String type){

		return transactionService.viewAllTransactions(type);

	}











}

