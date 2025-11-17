package com.produtoapi.projeto_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtoapi.projeto_spring_boot.entities.Carrinho;

@Repository

public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {

}
