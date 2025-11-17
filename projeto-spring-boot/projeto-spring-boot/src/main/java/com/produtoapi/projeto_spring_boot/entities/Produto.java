package com.produtoapi.projeto_spring_boot.entities;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data                       
@NoArgsConstructor          
@AllArgsConstructor         
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@NotNull(message = "A quantidade deve ser informada")
	@PositiveOrZero
	private Integer quantidade;
	
	@NotNull(message = "Seu preço não pode ser vazio ou menor que 0")
	@Positive
	private BigDecimal preco;
	
	@ManyToOne
	@NotNull(message = "A categoria do produto é obrigatória")
    @JoinColumn(name = "categoria_id") 
    private Categoria categoria; 
	
	
    // ------------------ MÉTODOS DE REGRA DE NEGÓCIO ------------
	
	public Integer verEstoque() {
	    return this.quantidade;
	}

    public void diminuirEstoque(int qnt) {
        if (qnt <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        if (qnt > this.quantidade) {
            throw new IllegalStateException("Estoque insuficiente.");
        }
        this.quantidade -= qnt;
    }

    public void aumentarEstoque(int qnt) {
        if (qnt <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        this.quantidade += qnt;
    }

	public BigDecimal getPreco() {
		// TODO Auto-generated method stub
		return null;
	}
	

}