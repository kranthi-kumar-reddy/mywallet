package com.digit.mywallet.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.digit.mywallet.entities.BankAccount;
import com.digit.mywallet.entities.Wallet;
import com.digit.mywallet.repositories.IAccountRepository;
import com.digit.mywallet.repositories.IWalletRepository;
import com.digit.mywallet.serviceInterface.IAccountService;

@Controller
@ResponseBody
public class BankAccountController {
	@Autowired
	IAccountService service;
	@Autowired
	IAccountRepository r;
	@Autowired
	IWalletRepository repo;

	@GetMapping("/viewAll/{id}")
	public ModelAndView viewAllBankAccounts(@PathVariable int id, HttpSession session) {
		if(session.getAttribute("customer1")!=null) {
		ModelAndView mv = new ModelAndView("viewAllAccount");
		Wallet wallet=repo.findById(id).get();
		session.setAttribute("wallet", wallet);
		List<BankAccount> bankAccount = service.viewAllAccounts(repo.findById(id).get());
		if(!bankAccount.isEmpty()) {
		mv.addObject("bankAccount", bankAccount);		
		}
		else {		
			BankAccount bank = new BankAccount();
		    mv.setViewName("addAccount");
		    mv.addObject("bank",bank);
	
			
		}
		return mv;
		}
		else {
			return new ModelAndView("login");
		}
		
		
	}

	@GetMapping("/addAccount")
	public ModelAndView addingAccount(HttpSession session) {
		BankAccount bankAccount = new BankAccount();
		ModelAndView mv = new ModelAndView("addAccount");
		mv.addObject("bank", bankAccount);
		return mv;
	}

	@PostMapping("/add-acc/{id}")
	public RedirectView addAccount(@ModelAttribute BankAccount bacc, HttpSession session,@PathVariable int id) {
		
		Wallet wallet = repo.findById(id).get();
		bacc.setWallet(wallet);
		service.addAccount(bacc);
		String url = "/viewAll/" + wallet.getWalletId();
		return new RedirectView(url);
	}

	@RequestMapping("/remove-account/{id}")
	public RedirectView removeAccount(@PathVariable long id, HttpSession session) {
		Wallet wallet = (Wallet) session.getAttribute("wallet");
		int id2 = wallet.getWalletId();
		service.removeAccount(id);
		String url = "/viewAll/" + id2;
		return new RedirectView(url);
	}

	@GetMapping("/view-account")
	public BankAccount viewAccount(@RequestBody Wallet wallet) {
		return service.viewAccount(wallet);
	}

	@GetMapping("/view-a")
	public String viewAllAccounts(@RequestBody Wallet wallet) {
		return "redirect:/" + wallet.getWalletId();
	}
}
