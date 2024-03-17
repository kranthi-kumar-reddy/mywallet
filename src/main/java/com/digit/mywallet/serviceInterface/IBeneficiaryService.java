package com.digit.mywallet.serviceInterface;

import java.util.List;
import com.digit.mywallet.entities.BeneficiaryDetails;

public interface IBeneficiaryService {
	List<BeneficiaryDetails> getAllBeneficiaryDetails();

	BeneficiaryDetails addBeneficiaryDetails(BeneficiaryDetails bd);

	BeneficiaryDetails deleteBeneficiaryDetails(BeneficiaryDetails bd);

	BeneficiaryDetails viewBeneficiaryDetails(String beneficiaryMobileNumber);

	List<BeneficiaryDetails> viewAllBeneficiaryDetails();
}
