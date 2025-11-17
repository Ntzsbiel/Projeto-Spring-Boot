package com.produtoapi.projeto_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtoapi.projeto_spring_boot.entities.CarrinhoItens;

@Repository

public interface CarrinhoItensRepository extends JpaRepository<CarrinhoItens, Integer> {

}
