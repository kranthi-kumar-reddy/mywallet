package com.digit.mywallet.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryDetails {
	@NonNull
	@Size(min = 3, message = "Name cannot have less than 3 characters length")
	@NotBlank
	private String beneficiaryName;
	@Id
	@NonNull
	@NotBlank
	@Pattern(regexp = "[6789][0-9]{9}", message = "cannot start with 0 to 5,allowed length is 10 chars")
	private String beneficiaryMobileNumber;
}
