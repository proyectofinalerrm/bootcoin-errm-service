package com.pe.bank.bootcoin.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.pe.bank.bootcoin.document.BootCoinDocument;


public interface BootCoinRepository extends ReactiveMongoRepository<BootCoinDocument, String>{

}
