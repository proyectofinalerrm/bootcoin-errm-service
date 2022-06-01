package com.pe.bank.bootcoin.service;

import com.pe.bank.bootcoin.document.BootCoinDocument;
import com.pe.bank.bootcoin.dto.BootCoinDebitCardDTO;
import com.pe.bank.bootcoin.dto.BootCoinOperationDTO;
import com.pe.bank.bootcoin.dto.BootCoinResponseDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootCoinService {

	public Flux<BootCoinDocument> getAllBootCoin();
	
	public Mono<BootCoinDocument> getBootCoinById(String bootcoinId);
	
	public Mono<BootCoinDocument> saveBootCoin(BootCoinDocument bootcoinDocument);
	
	public Mono<BootCoinDocument> updateBootCoinById(BootCoinDocument bootcoinDocument, String bootcoinId);
	
	public Mono<BootCoinDocument> updateBootCoinByDebitCardId(BootCoinDocument updateWalletDocument,String debitCardId);
	
	public Mono<Void> deleteBootCoinById(String bootcoinId);
	
	public Mono<BootCoinResponseDTO> operationBootCoin(BootCoinResponseDTO bootcoinOperationDTO);
	
	public Mono<BootCoinResponseDTO> asociateDebitCard(BootCoinDebitCardDTO bootcoinDebitardDTO, String bootcoinId);
	
	public Mono<BootCoinDocument> findBootCoinPhoneById(Long id);
	
	//prueba
	public void sendBootCoinDocument(BootCoinOperationDTO bootcoinOperationDTO);
}
