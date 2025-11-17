package com.produtoapi.projeto_spring_boot.entities;

<<<<<<< HEAD
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data                       // Gera getters, setters, toString, equals e hashCode
@NoArgsConstructor          // Construtor vazio
@AllArgsConstructor         // Construtor com todos os atributos


public class Carrinho {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_carrinho;
	
	private LocalDate data;
	
	private String status;
	
	
	//
	
	public void adicionarItem(Produto produto, Integer qnt )
	{
	
		Carrinho_itens item = new Carrinho_itens();
		item.setProduto(produto);
		item.setProduto(qnt);
		item.setcarrinho(this);
		itens.add(carrinho);
		
	}
	public void removerItem(id_item)
    {
		
	}
	public void atualizarQuantidade(int id_item, int qnt)
	{
		
	}
	public List<CarrinhoItem>void listarItens()
	{
		
	}
	
	public BigDecimal calcularTotal()
	{
		
	}
	
	public void finalizar()
	{
		this.status = " Finalizado ";
	}
	
	public void cancelar()
	{
		this.status = " Cancelado ";
	}

}