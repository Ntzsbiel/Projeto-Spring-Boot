package com.produtoapi.projeto_spring_boot.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Gera getters, setters, toString, equals e hashCode
@NoArgsConstructor // Construtor vazio
@AllArgsConstructor // Construtor com todos os atributos

public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_carrinho;

	private LocalDate data;

	private String status;

	private List<CarrinhoItens> itens = new ArrayList<>();

	//

	public void adicionarItem(Produto produto, Integer qnt) {

		CarrinhoItens item = new CarrinhoItens();
		item.setProduto(produto);
		item.setQuantidade(qnt);
		item.setCarrinho(this);
		itens.add(item);

	}

	public void removerItem(Integer idItem) {
		for (CarrinhoItens item : itens)
			if (item.getId().equals(idItem)) {
				itens.remove(idItem);
				break;
			}
	}

	public void atualizarQuantidade(int idItem, int qnt) {
		for (CarrinhoItens item : itens) {
			if (item.getId().equals(idItem)) {
				item.setQuantidade(qnt);
				break;
			}
		}
	}

	public List<CarrinhoItens> listarItens() {

		return itens;
	}

	public BigDecimal calcularTotal() {

		BigDecimal total = BigDecimal.ZERO;

		for (CarrinhoItens item : itens) {
			BigDecimal preco = item.getProduto().getPreco();
			BigDecimal qtde = BigDecimal.valueOf(item.getQuantidade());
			BigDecimal subTotal = preco.multiply(qtde);
			total = total.add(subTotal);
		}
		return total;
	}

	public void finalizar() {
		this.status = " Finalizado ";
		this.data = LocalDate.now();
	}

	public void cancelar() {
		this.status = " Cancelado ";
	}

}