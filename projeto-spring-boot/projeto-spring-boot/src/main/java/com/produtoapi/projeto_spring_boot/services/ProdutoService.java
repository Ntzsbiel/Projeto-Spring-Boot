package com.produtoapi.projeto_spring_boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtoapi.projeto_spring_boot.entities.Categoria;
import com.produtoapi.projeto_spring_boot.entities.Produto;
import com.produtoapi.projeto_spring_boot.repositories.CategoriaRepository;
import com.produtoapi.projeto_spring_boot.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	// ---------------------------- LISTAR ----------------------------
	public List<Produto> procurarTodos() {
		return produtoRepository.findAll();
	}

	public Produto procurarPorId(Integer id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
	}

	// ---------------------------- CRIAR ----------------------------
	public Produto adicionarProduto(Produto produto) {

		// garantir que a categoria existe
		Categoria categoria = categoriaRepository.findById(produto.getCategoria().getId())
				.orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));

		produto.setCategoria(categoria);

		return produtoRepository.save(produto);
	}

	// ---------------------------- EDITAR ----------------------------
	public Produto editarProduto(Integer id, Produto produto) {

		Produto existente = produtoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

		// Atualiza os campos
		existente.setNome(produto.getNome());
		existente.setQuantidade(produto.getQuantidade());
		existente.setPreco(produto.getPreco());

		// Atualizar categoria 
		if (produto.getCategoria() != null) {
			Categoria categoria = categoriaRepository.findById(produto.getCategoria().getId())
					.orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
			existente.setCategoria(categoria);
		}

		return produtoRepository.save(existente);
	}

	// ---------------------------- EXCLUIR ----------------------------
	public void excluirProduto(Integer id) {
		Produto existente = produtoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
		produtoRepository.delete(existente);
	}

	// ----------------------- CONTROLE DE ESTOQUE -----------------------

	public void diminuirEstoque(Integer id, int qnt) {
		Produto p = procurarPorId(id);
		p.diminuirEstoque(qnt);
		produtoRepository.save(p);
	}

	public void aumentarEstoque(Integer id, int qnt) {
		Produto p = procurarPorId(id);
		p.aumentarEstoque(qnt);
		produtoRepository.save(p);
	}
}
