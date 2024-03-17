package com.digit.mywallet.services;

 

import java.time.LocalDate;

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

 

import com.digit.mywallet.entities.Transaction;

import com.digit.mywallet.entities.Wallet;

import com.digit.mywallet.repositories.ITransactionRepository;
import com.digit.mywallet.repositories.IWalletRepository;
import com.digit.mywallet.serviceInterface.ITransactionService;

import lombok.RequiredArgsConstructor;

 

@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionService {

private final ITransactionRepository repository;

private final IWalletRepository walletRepository;

 

@Override

public Transaction addTransaction(Transaction tran) {

 

return repository.save(tran);

}

 

@Override

public List<Transaction> viewAllTransactions(Wallet wallet) {

return repository.viewAllTransactions(wallet.getWalletId());

 

}


@Override

public List<Transaction> viewTransactionsByDate(LocalDate from, LocalDate to,int walletId) {

 

return repository.viewTransactionsByDate(from, to, walletId);

}

 

 

@Override

public List<Transaction> viewAllTransactions(String type) {

 

return repository.viewAllTransactions(type);

}

 

public List<Transaction> findAllTransactions() {

// TODO Auto-generated method stub

return repository.findAll();

}



public Wallet getWalletByWalletId(int id) {
	return walletRepository.findById(id).get();
}

 

}

 

