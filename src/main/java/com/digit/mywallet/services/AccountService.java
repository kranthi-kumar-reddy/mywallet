package com.digit.mywallet.services;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digit.mywallet.entities.BankAccount;
import com.digit.mywallet.entities.Wallet;
import com.digit.mywallet.repositories.IAccountRepository;
import com.digit.mywallet.serviceInterface.IAccountService;

@Service
public class AccountService implements IAccountService{
	@Autowired
	IAccountRepository repository;
	@Override
	public Wallet addAccount(BankAccount bacc) {
		repository.save(bacc);
		return bacc.getWallet();
	}
	@Override
	public void removeAccount(long id) {
		repository.deleteAccount(id);
	}

	@Override
	public BankAccount viewAccount(Wallet wallet) {


		BankAccount bankAccount= repository.viewAccount(wallet.getWalletId());
		if(bankAccount==null)
		{
			System.out.println("null");
			return null;
		}
		else {
			return bankAccount;
		}
	}

	@Override
	public List<BankAccount> viewAllAccounts(Wallet wallet) {
		return repository.viewAllAccounts(wallet.getWalletId());
	}
	// @Override
	// public List<BankAccount> findAllBankAccounts() {
	//
	// return repository.findAll();
	// }

}
