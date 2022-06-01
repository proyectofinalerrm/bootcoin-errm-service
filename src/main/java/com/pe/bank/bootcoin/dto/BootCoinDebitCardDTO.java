package com.pe.bank.bootcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootCoinDebitCardDTO {

	private String debitCardId;
	private Double amount;
}
