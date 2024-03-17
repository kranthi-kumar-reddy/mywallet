package com.digit.mywallet.entities;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="wallet_table")
public class Wallet {
	
	public Wallet(BigDecimal amount) {
		this.amount=amount;
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
    private int walletId;
	
	
	@PositiveOrZero(message="Balance must be positive value")
    private BigDecimal amount;
	

}