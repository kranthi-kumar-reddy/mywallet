package com.digit.mywallet.serviceInterface;

import java.util.List;
import com.digit.mywallet.entities.BankAccount;
import com.digit.mywallet.entities.Wallet;

public interface IAccountService {
	Wallet addAccount(BankAccount bacc);

	void removeAccount(long id);

	BankAccount viewAccount(Wallet wallet);

	List<BankAccount> viewAllAccounts(Wallet wallet);
// List<BankAccount> findAllBankAccounts();



}
