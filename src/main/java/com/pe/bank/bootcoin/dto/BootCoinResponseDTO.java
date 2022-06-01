package com.pe.bank.bootcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootCoinResponseDTO {

	private String messageCode;
	private String messageDescription;
}
