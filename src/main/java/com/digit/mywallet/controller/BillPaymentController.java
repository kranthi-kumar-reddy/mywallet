package com.digit.mywallet.controller;

import java.time.LocalDate;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

 

import com.digit.mywallet.entities.BillPayment;
import com.digit.mywallet.repositories.IWalletRepository;
import com.digit.mywallet.services.BillPaymentService;

 

@Controller
public class BillPaymentController {

    @Autowired
    BillPaymentService service;
    
    @Autowired
    IWalletRepository walletService;
    

    @GetMapping("/viewallbills")
    public ModelAndView viewAllPayments(HttpSession session) {
    	if(session.getAttribute("customer1")!=null) {
        ModelAndView mv=new ModelAndView("billPayments");
        List<BillPayment> bill=service.getAllBillPayments();
        mv.addObject("bill",bill );
        return mv;}
    	else {
    		return new ModelAndView("login");
    	}
    }

    @GetMapping("/getbills")
    public List<BillPayment> getAllBillPayment()
    {
        return service.getAllBillPayments();
    }

    @PostMapping("/addbills/{walletId}/{customerId}")
    public String addBillPayment( @RequestParam("BillType") String billType, @RequestParam("amount") double amount, @RequestParam("paymentDate") String date,@PathVariable int walletId,@PathVariable int customerId,HttpSession session) {
    	if(session.getAttribute("customer1")!=null) {
    	BillPayment payment = new BillPayment();
    	payment.setAmount(amount);
    	payment.setBillType(billType);
    	payment.setPaymentDate(LocalDate.parse(date));
    	payment.setWallet(walletService.findById(walletId).get());
    	
    	service.addBillPayment(payment);
 
    	
    	return "redirect:/walletHome/"+customerId;
    	}
    	else {
    		return "redirect:/";
    	}
    	
    }

    @PostMapping("/viewbills")
    public BillPayment viewBillPayment(@RequestBody BillPayment payment) {
        return service.viewBillPayment(payment);    
    }

 

}