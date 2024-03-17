package com.digit.mywallet.serviceInterface;

 

import java.time.LocalDate;

import java.util.List;

 

import com.digit.mywallet.entities.Transaction;

import com.digit.mywallet.entities.Wallet;

 

public interface ITransactionService {

 

public Transaction addTransaction(Transaction tran);

public List<Transaction> viewAllTransactions(Wallet wallet);

public List<Transaction> viewTransactionsByDate(LocalDate from,LocalDate to,int walletId);

public List<Transaction> viewAllTransactions(String type);

}