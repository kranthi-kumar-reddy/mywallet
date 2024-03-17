package com.digit.mywallet.repositories;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

 

import com.digit.mywallet.entities.Customer;

 

@Repository
public interface IUserRepository extends JpaRepository<Customer, Integer>{


    @Query(value = "select * from customer_details where mobile_number=?1 and password=?2",nativeQuery = true )
    Customer validateLogin(String MobileNumber,String password);

    //@Query(value = "select * from customer_details where mobile_number=?" ,nativeQuery = true)
    Customer findByMobileNumber(String MobileNumber);


}