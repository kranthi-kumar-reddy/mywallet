package com.digit.mywallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.digit.mywallet.entities.BeneficiaryDetails;

@Repository
public interface IBeneficiaryRepository extends JpaRepository<BeneficiaryDetails, Integer> {
	BeneficiaryDetails findByBeneficiaryMobileNumber(String beneficiaryMobileNumber);

}
