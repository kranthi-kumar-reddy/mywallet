package com.digit.mywallet.services;




import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.digit.mywallet.entities.BillPayment;
import com.digit.mywallet.repositories.IBillPaymentRepository;
import com.digit.mywallet.serviceInterface.IBillPaymentService;

 

@Service
public class BillPaymentService implements IBillPaymentService{
    @Autowired
    IBillPaymentRepository repository;
    public List<BillPayment>  getAllBillPayments(){

        return repository.findAll();
    }

    public BillPayment addBillPayment( BillPayment payment) {

        return repository.save(payment);
    }
public BillPayment viewBillPayment( BillPayment payment) {

 

        return payment;

    }
}