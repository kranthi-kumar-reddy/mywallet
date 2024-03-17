package com.digit.mywallet.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 

import com.digit.mywallet.entities.BillPayment;

 

 

@Repository
public interface IBillPaymentRepository extends JpaRepository<BillPayment,Integer> {

 

}