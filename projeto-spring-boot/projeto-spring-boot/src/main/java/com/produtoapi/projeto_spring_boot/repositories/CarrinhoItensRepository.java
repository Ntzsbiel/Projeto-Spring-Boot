package com.produtoapi.projeto_spring_boot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtoapi.projeto_spring_boot.entities.CarrinhoItens;

public interface CarrinhoItensRepository extends JpaRepository<CarrinhoItens, Integer> {
    List<CarrinhoItens> findByCarrinhoId(Integer carrinhoId);
}
