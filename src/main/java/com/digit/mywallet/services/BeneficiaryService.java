package com.digit.mywallet.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digit.mywallet.entities.BeneficiaryDetails;

import com.digit.mywallet.repositories.IBeneficiaryRepository;
import com.digit.mywallet.serviceInterface.IBeneficiaryService;
@Service
public class BeneficiaryService implements IBeneficiaryService{
    @Autowired
    IBeneficiaryRepository repository;

    public List<BeneficiaryDetails> getAllBeneficiaryDetails(){
        return repository.findAll();
    }

    public BeneficiaryDetails addBeneficiaryDetails(BeneficiaryDetails bd) {
        return repository.save(bd);
    }
    @Override
    public BeneficiaryDetails deleteBeneficiaryDetails(BeneficiaryDetails bd){
        BeneficiaryDetails bd1=repository.findByBeneficiaryMobileNumber(bd.getBeneficiaryMobileNumber());
        if(bd1!=null && bd1.getBeneficiaryName().equals(bd.getBeneficiaryName())) {
            repository.delete(bd1);
            System.out.println(" Deleted Successfully");
        }
        else
        {
            System.out.println("No Beneficiary found");
        }
        return bd1;
    }
    @Override
    public BeneficiaryDetails viewBeneficiaryDetails(String beneficiaryMobileNumber) {
        return repository.findByBeneficiaryMobileNumber(beneficiaryMobileNumber);
    }
    @Override
    public List<BeneficiaryDetails> viewAllBeneficiaryDetails() {
        return repository.findAll();
    }
}
