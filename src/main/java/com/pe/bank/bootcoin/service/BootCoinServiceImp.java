package com.pe.bank.bootcoin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import com.pe.bank.bootcoin.document.BootCoinDocument;
import com.pe.bank.bootcoin.dto.BootCoinDebitCardDTO;
import com.pe.bank.bootcoin.dto.BootCoinOperationDTO;
import com.pe.bank.bootcoin.dto.BootCoinResponseDTO;
import com.pe.bank.bootcoin.repository.BootCoinRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootCoinServiceImp implements BootCoinService{

	@Autowired
	BootCoinRepository bootCoinRepository;
	
	@Autowired
	StreamBridge streamBridge;
	
	//----- REDIS - INI -----
	
	//RedisTemplate redisTemplate;
	
	//private final ReactiveRedisOperations<String, BootCoinDocument> operations;
	
	// ----- REDIS - FIN -----
	
	@Override
	public Flux<BootCoinDocument> getAllBootCoin() {
		// TODO Auto-generated method stub
		return bootCoinRepository.findAll();
	}

	@Override
	public Mono<BootCoinDocument> getBootCoinById(String bootcoinId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<BootCoinDocument> saveBootCoin(BootCoinDocument bootcoinDocument) {
		// TODO Auto-generated method stub
		return bootCoinRepository.save(bootcoinDocument);
	}

	@Override
	public Mono<BootCoinDocument> updateBootCoinById(BootCoinDocument bootcoinDocument, String bootcoinId) {
		// TODO Auto-generated method stub
		return bootCoinRepository.findById(bootcoinId).flatMap(bootcoin -> {
			bootcoin.setDocumentNumber(bootcoinDocument.getDocumentNumber() != null ? bootcoinDocument.getDocumentNumber() : bootcoin.getDocumentNumber());
			bootcoin.setDocumentType(bootcoinDocument.getDocumentType() != null ? bootcoinDocument.getDocumentType() : bootcoin.getDocumentType());
			bootcoin.setPhoneNumber(bootcoinDocument.getPhoneNumber() != null ? bootcoinDocument.getPhoneNumber() : bootcoin.getPhoneNumber());
			bootcoin.setEmail(bootcoinDocument.getEmail() != null ? bootcoinDocument.getEmail() : bootcoin.getEmail());
			return bootCoinRepository.save(bootcoin);
		})
				
				;
	}

	@Override
	public Mono<BootCoinDocument> updateBootCoinByDebitCardId(BootCoinDocument updateWalletDocument,
			String debitCardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteBootCoinById(String bootcoinId) {
		// TODO Auto-generated method stub
		return bootCoinRepository.deleteById(bootcoinId);
	}

	@Override
	public Mono<BootCoinResponseDTO> operationBootCoin(BootCoinResponseDTO bootcoinOperationDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<BootCoinResponseDTO> asociateDebitCard(BootCoinDebitCardDTO bootcoinDebitardDTO, String bootcoinId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<BootCoinDocument> findBootCoinPhoneById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// pruebas
	
	public void sendBootCoinDocument(BootCoinOperationDTO bootcoinOperationDTO) {
		streamBridge.send("bootcoinerm-out-0", bootcoinOperationDTO);
	}
	

}
