package com.digit.mywallet.repositories;

 

import java.time.LocalDate;

import java.util.List;

 

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

 

import org.springframework.stereotype.Repository;

 

import com.digit.mywallet.entities.Transaction;

 

@Repository

public interface ITransactionRepository extends JpaRepository<Transaction, Integer>{

 

@Query(value="select * from transaction where wallet_id=?",nativeQuery=true)
public List<Transaction> viewAllTransactions(int id);

 

@Query(value="select * from transaction where transaction_date >= ?1 and transaction_date <= ?2 and wallet_id= ?3 ",nativeQuery = true)

public List<Transaction> viewTransactionsByDate(LocalDate from, LocalDate to,int walletId);;

 

 

@Query(value="select * from transaction where transaction_type=?",nativeQuery = true)
public List<Transaction> viewAllTransactions(String type);

 

 

}
