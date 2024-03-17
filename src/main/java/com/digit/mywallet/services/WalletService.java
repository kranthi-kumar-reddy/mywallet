package com.digit.mywallet.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;

import com.digit.mywallet.entities.BankAccount;
import com.digit.mywallet.entities.Customer;
import com.digit.mywallet.entities.Wallet;
import com.digit.mywallet.repositories.IAccountRepository;
import com.digit.mywallet.repositories.IUserRepository;
import com.digit.mywallet.repositories.IWalletRepository;
import com.digit.mywallet.serviceInterface.IWalletService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class WalletService implements IWalletService {
	
	private final IWalletRepository walletRepository;
	
	private final IUserRepository userRepository;
	
	private final IAccountRepository accountRepository;
	
	public Customer findCustomerById(int id) {
		return userRepository.findById(id).get();
	}
	

	@Override
	public Customer createAccountCustomer(Customer customer) {
		return userRepository.save(customer);
	}
	
	
	

	
	
	@Override
	public Customer showBalance(String mobileno) {
		return userRepository.findByMobileNumber(mobileno);
	}

	@Override
	public void fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		Customer sourceCustomer=showBalance(sourceMobileNo);
		Customer targetCustomer=showBalance(targetMobileNo);
		if(sourceCustomer!=null&&targetCustomer!=null)
		{
		  BigDecimal sourceAmount=sourceCustomer.getWallet().getAmount();
		  BigDecimal targetAmount=targetCustomer.getWallet().getAmount();
		  if(sourceAmount.longValue()>amount.longValue())
		  {
			 sourceCustomer.getWallet().setAmount(BigDecimal.valueOf(sourceAmount.longValue()-amount.longValue()));
			 targetCustomer.getWallet().setAmount(BigDecimal.valueOf(targetAmount.longValue()+amount.longValue()));
			 
			 userRepository.save(sourceCustomer);
			 userRepository.save(targetCustomer);
		  }
		}
		
		System.out.println("Funds transferred Successfully");
		
	}

	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		Customer customer=showBalance(mobileNo);
		List<BankAccount> account=accountRepository.getAccount(customer.getWallet().getWalletId());
		BankAccount maxAccount=account.get(0);
		double balance=maxAccount.getBalance();
		for(BankAccount accounts:account)
		{
			if(balance>accounts.getBalance())
			{
				maxAccount=accounts;
				balance=maxAccount.getBalance();
				
			}
		}
		maxAccount.setBalance(maxAccount.getBalance()+amount.longValue());
		accountRepository.save(maxAccount);
		
		return customer;
		

		
		
		
	}

	@Override
	public List<Customer> getList() {
		
		return userRepository.findAll();
	}

//	@Override
//	public Customer updateAccount(Customer customer,int id) {
//      Customer customer1=findCustomerById(id);
//      customer1.setMobileNumber(customer.getMobileNumber());
//      customer1.setName(customer.getName());
//      customer1.setPassword(customer.getPassword());
//      return userRepository.save(customer1);
//		
//	}

	@Override
	public Customer addMoney(int customerId, double amount) {
	  Wallet wallet = findCustomerById(customerId).getWallet();
	List <BankAccount> accounts=accountRepository.getAccount(wallet.getWalletId());
	for(int i=0;i<accounts.size();i++)
	{
		if(accounts.get(i).getBalance()>amount)
		{
			accounts.get(i).setBalance(accounts.get(i).getBalance()-amount);
			accounts.get(i).getWallet().setAmount(   BigDecimal.valueOf(accounts.get(i).getWallet().getAmount().longValue()+amount));
			accountRepository.save(accounts.get(i));
			walletRepository.save(accounts.get(i).getWallet());
			break;
		}
	} 
	  return userRepository.findById(customerId).get();
	
	}


	@Override
	public Customer createAccount(String name,String mobileNumber,BigDecimal amount) {
		Customer customer;
		if((customer = showBalance(mobileNumber))!=null) {
			Wallet wallet = new Wallet();
		    wallet.setAmount(amount);
		    customer.setWallet(wallet);
		   // walletRepository.save(wallet);
		    userRepository.save(customer);
		   
		}
		return customer;
	}

    
	@Override
	public Customer updateAccount(String name, String mobileNumber, String password, int id) {
		Customer customer = findCustomerById(id);
		customer.setName(name);
		customer.setMobileNumber(mobileNumber);
		customer.setPassword(password);
		return userRepository.save(customer);
		
	}


	







}