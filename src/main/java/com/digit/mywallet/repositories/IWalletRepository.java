package com.digit.mywallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digit.mywallet.entities.Customer;
import com.digit.mywallet.entities.Wallet;

public interface IWalletRepository extends JpaRepository<Wallet, Integer> {
    
	@Query(value="select * from customer_details where mobile_number = ?1",nativeQuery=true)
	public Customer findOne(String mobileNo);
}
