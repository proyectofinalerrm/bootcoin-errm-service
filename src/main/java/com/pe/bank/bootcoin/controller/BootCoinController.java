package com.pe.bank.bootcoin.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.bank.bootcoin.document.BootCoinDocument;
import com.pe.bank.bootcoin.dto.BootCoinOperationDTO;
import com.pe.bank.bootcoin.service.BootCoinService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/v1")
public class BootCoinController {

	BootCoinService bootcoinService;
	
	@GetMapping("/getAllBootCoin")
	public Flux<BootCoinDocument> getAllBootCoin(){
		return bootcoinService.getAllBootCoin();
	}
	
	@PostMapping("/saveBootCoin")
	public Mono<BootCoinDocument> saveBootCoin(@RequestBody BootCoinDocument bootcoinDocument){
		return bootcoinService.saveBootCoin(bootcoinDocument);
	}
	
	@PutMapping("/updateBootCoinById/{bootcoinId}")
	public Mono<BootCoinDocument> updateBootCoinById(@RequestBody BootCoinDocument bootcoinDocument, @PathVariable String bootcoinId){
		return bootcoinService.updateBootCoinById(bootcoinDocument, bootcoinId);
	}
	
	@DeleteMapping("/deleteBootCoinById/{bootcoinId}")
	public Mono<Void> deleteBootCoinById(String bootcoinId){
		return bootcoinService.deleteBootCoinById(bootcoinId);
	}
	
	// pruebas
	@PostMapping("/sendBootCoin")
	public void send(@RequestBody BootCoinOperationDTO bootcoinOperationDTO) {
		this.bootcoinService.sendBootCoinDocument(bootcoinOperationDTO);
	}
}
