package com.produtoapi.projeto_spring_boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtoapi.projeto_spring_boot.entities.Carrinho;
import com.produtoapi.projeto_spring_boot.entities.CarrinhoItens;
import com.produtoapi.projeto_spring_boot.entities.Produto;
import com.produtoapi.projeto_spring_boot.repositories.CarrinhoItensRepository;
import com.produtoapi.projeto_spring_boot.repositories.CarrinhoRepository;
import com.produtoapi.projeto_spring_boot.repositories.ProdutoRepository;

@Service
public class CarrinhoItensService {

	
// Entidades que serão utilizadas para manipular CarrinhoItens
	
	@Autowired
	private CarrinhoItensRepository carrinhoItensRepo;

	@Autowired
	private ProdutoRepository produtoRepo;

	@Autowired
	private CarrinhoRepository carrinhoRepo;

	// --------------------- LISTAGENS ------------------------

	// Lista todos os itens do carrinho (todos os carrinhos)
	public List<CarrinhoItens> listar() {
		return carrinhoItensRepo.findAll();
	}

	// Lista todos os itens de um carrinho específico
	public List<CarrinhoItens> listarPorCarrinho(Integer idCarrinho) {
		return carrinhoItensRepo.findByCarrinhoId(idCarrinho);
	}

	// Busca item pelo id
	public CarrinhoItens buscarPorId(Integer idItem) {
		return carrinhoItensRepo.findById(idItem)
				.orElseThrow(() -> new RuntimeException("Item do carrinho não encontrado!"));
	}

	// ======================== C R U D ====================

	// Adiciona um novo item ao carrinho
	public CarrinhoItens adicionar(Integer idCarrinho, Integer idProduto, Integer quantidade) {

		// 1° Busca carrinho
		Carrinho carrinho = carrinhoRepo
				.findById(idCarrinho)
				.orElseThrow(() -> new RuntimeException("Carrinho não encontrado!"));

		
		// 2° Busca produto
		Produto produto = produtoRepo
				.findById(idProduto)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

		
		// 3° Cria o item do carrinho
		CarrinhoItens item = new CarrinhoItens();
		item.setCarrinho(carrinho);
		item.setProduto(produto);
		item.setQuantidade(quantidade);

		
		// 4° Salva no banco
		return carrinhoItensRepo.save(item);
	}

	// Atualiza a quantidade de um item
	public CarrinhoItens atualizarQuantidade(Integer idItem, Integer novaQuantidade) {

		CarrinhoItens item = buscarPorId(idItem);

		item.setQuantidade(novaQuantidade);

		return carrinhoItensRepo.save(item);
	}

	// Remove item do carrinho
	public void remover(Integer idItem) {

		CarrinhoItens item = buscarPorId(idItem);

		carrinhoItensRepo.delete(item);
	}
}
