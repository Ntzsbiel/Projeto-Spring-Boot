package com.produtoapi.projeto_spring_boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtoapi.projeto_spring_boot.entities.Categoria;
import com.produtoapi.projeto_spring_boot.repositories.CategoriaRepository;


@Service

public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriarepo;
	
	public List<Categoria> procuraTodos()
	{
		return categoriarepo.findAll(); 
	}
	
	public Categoria procurarPorId(Integer id)
	{
		return categoriarepo.findById(id).get();
	}

	public String adicionarCategoria(Categoria categoria)
	{
		categoriarepo.save(categoria);
		return " Categoria adicionada com sucesso !";
	}
	
	public String editarCategoria(Integer id, Categoria categoria)
	{
		Categoria response = categoriarepo.findById(id).get();
		
		response.setId(categoria.getId());
		response.setNome(categoria.getNome());
		
		categoriarepo.save(response);
		return " Categoria editada com sucesso! ";
	}	
	public void excluirCategoria(Integer id)
	{
		Categoria response = categoriarepo.findById(id).get();
		categoriarepo.delete(response);
	}
		
		
	}

