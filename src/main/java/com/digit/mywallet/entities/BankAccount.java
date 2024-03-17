package com.digit.mywallet.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.web.servlet.view.RedirectView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BankAccount {
	@Id
	@NotNull
	@Digits(integer = 11, fraction = 0, message = "Account number should be 11 digits")
	private long accountNo;
	@NotNull
	@NotEmpty(message = "IFSC code cannot be empty")
	@Pattern(regexp = "[A-Z]{4}\\d{7}", message = "IFSC code should be in the format ABCD1234567")
	private String ifscCode;
	@NotEmpty(message = "Bank name cannot be empty")
	private String bankname;
	@PositiveOrZero(message = "Balance must be a positive value")
	private double balance;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "wallet_id")
	private Wallet wallet;

}
