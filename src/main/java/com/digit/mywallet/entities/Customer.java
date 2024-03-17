package com.digit.mywallet.entities;



import javax.persistence.CascadeType;





import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

import javax.persistence.Table;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Pattern;

import javax.validation.constraints.Size;





import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;



@Entity

@Data

@NoArgsConstructor

@AllArgsConstructor

@Table(name = "customer_details")

public class Customer {

	@Id

	@NotNull

	@GeneratedValue(strategy = GenerationType.AUTO)

	int customerId;

	@NotBlank(message = "Name should not blank")

	@NotNull(message = "Name should be not null")

	@Size(min = 3, message = "Name should be atleast 3 charecters")

	private String name;

	@NotNull(message = "Mobile number should be not null")

	@NotBlank(message = "Mobile number should be not blank")

	@Pattern(regexp = "[6789][0-9]{9}",message = "Give proper mobile number")

	private String mobileNumber;

	@NotBlank(message = "password should not be blank")

	@NotNull(message = "Password should be not null")

	@Pattern(regexp ="^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{4,}$",message = "Password is not Strong please enter Strong password")

	private String password;

	@OneToOne(cascade = CascadeType.ALL)

	@JoinColumn(name="wallet_id")

	private Wallet wallet;



}

