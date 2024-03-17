package com.digit.mywallet.serviceInterface;

import java.math.BigDecimal;

import java.util.List;

import com.digit.mywallet.entities.BankAccount;
import com.digit.mywallet.entities.Customer;



public interface IWalletService {
    Customer showBalance(String mobileno);
    void fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount);
    Customer depositAmount(String mobileNo,BigDecimal amount);
    List<Customer>  getList();
	Customer createAccountCustomer(Customer customer);
	Customer createAccount(String name, String mobileNumber, BigDecimal amount);
//	Customer updateAccount(Customer customer, int id);
	Customer updateAccount(String name, String mobileNumber, String password, int id);
	Customer addMoney(int walletId, double amount);
	//BankAccount bankAccountCreation();
	
}
