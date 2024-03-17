package com.digit.mywallet.services;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;



import com.digit.mywallet.entities.Customer;

import com.digit.mywallet.repositories.IUserRepository;

import com.digit.mywallet.serviceInterface.IUserService;

@Service
@Transactional
public class UserService implements IUserService{

	@Autowired
	IUserRepository userrepository;

	@Override
	public Customer validateLogin(String MobileNumber, String password) {

		 return userrepository.findByMobileNumber(MobileNumber);
	}

	@Override
	public void customerRegistration(Customer customer) {

		if(customer!=null){

			userrepository.save(customer);
		}

		else {

		}
	}

}

