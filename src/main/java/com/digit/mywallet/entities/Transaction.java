package com.digit.mywallet.entities;

 

import java.time.LocalDate;

 

import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.PastOrPresent;

import javax.validation.constraints.Positive;

import javax.validation.constraints.Size;

 

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

 

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Transaction {

 

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int transactionId;


@NotNull(message = "transactionType should not be empty")
private String transactionType;

 

@PastOrPresent
private LocalDate transactionDate;

 

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="wallet_id")
private Wallet wallet;

 

@Positive(message = "Amount must be positive")
private double amount;

 
@Size(max=255,message = "Description should not extend the 255 characters")
private String description;

}

 

