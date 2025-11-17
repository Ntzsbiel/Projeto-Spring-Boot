package com.produtoapi.projeto_spring_boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtoapi.projeto_spring_boot.repositories.ProdutoRepository;

@Service

public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
}
