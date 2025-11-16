package com.produtoapi.projeto_spring_boot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor          
@AllArgsConstructor 

public class Carrinho_itens {

   @Id	
   @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;	
	
   @Positive	
   @NotNull(message = "Adicione Item") 		
private Integer quantidade;

   @Positive
   @ManyToOne
   @JoinColumn(name = "produto_id")      
private Integer produto_id;

   @Positive
   @ManyToOne
   @NotNull(message = "Adicionar item")
   @JoinColumn(name = "carrinho_id")
private Integer carrinho_id;
	

	
}
