package com.produtoapi.projeto_spring_boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtoapi.projeto_spring_boot.repositories.CarrinhoRepository;

@Service

public class CarrinhoService {

	@Autowired
	private CarrinhoRepository repository;
	
}
