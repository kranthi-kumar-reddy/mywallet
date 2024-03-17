package com.digit.mywallet.entities;
import java.time.LocalDate;





import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

 

 

import javax.validation.constraints.Positive;

 

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

 

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BillPayment {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int billId;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="walletId")
private Wallet wallet;

private String billType;

@Positive(message="Amount should be positive")
private double amount;

private LocalDate paymentDate;


}