package com.digit.mywallet.serviceInterface;

 

import com.digit.mywallet.entities.Customer;

 

public interface IUserService {

 

Customer validateLogin(String MobileNumber,String password);

void customerRegistration(Customer customer);

 

}

 