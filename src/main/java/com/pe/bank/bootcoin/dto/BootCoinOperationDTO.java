package com.pe.bank.bootcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootCoinOperationDTO {

	private Double amount;
	private Long sourcePhoneNumber;
	private Long destinationPhoneNumber;
	private String sourcebootcoinId;
	private String destinationbootcointId;
	private String message;
}
