package com.pe.bank.bootcoin.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bootcoinerrm")
public class BootCoinDocument implements Serializable{

	@Id
	private String bootId;
	private String documentNumber;
	private String documentType;
	private String phoneNumber;
	private String email;
	private Double amount;
	//private String debitCardId;
}
