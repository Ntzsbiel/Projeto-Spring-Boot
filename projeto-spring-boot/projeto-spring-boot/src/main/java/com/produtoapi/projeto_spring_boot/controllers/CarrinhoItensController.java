package com.produtoapi.projeto_spring_boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.produtoapi.projeto_spring_boot.entities.CarrinhoItens;
import com.produtoapi.projeto_spring_boot.services.CarrinhoItensService;

@RestController
@RequestMapping("/carrinho-itens")
public class CarrinhoItensController {

    @Autowired
    private CarrinhoItensService carrinhoItensService;


    // 📌 1. Listar todos os itens
    @GetMapping
    public ResponseEntity<List<CarrinhoItens>> listarTodos() {
        return ResponseEntity.ok(carrinhoItensService.listar());
    }


    // 📌 2. Buscar item por ID
    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoItens> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(carrinhoItensService.buscarPorId(id));
    }


    // 📌 3. Adicionar item em um carrinho
    @PostMapping("/adicionar")
    public ResponseEntity<CarrinhoItens> adicionar(
            @RequestParam Integer idCarrinho,
            @RequestParam Integer idProduto,
            @RequestParam Integer quantidade) {

        CarrinhoItens item = carrinhoItensService.adicionar(idCarrinho, idProduto, quantidade);
        return ResponseEntity.ok(item);
    }


    // 📌 4. Atualizar quantidade de um item
    @PutMapping("/{idItem}/quantidade")
    public ResponseEntity<CarrinhoItens> atualizarQuantidade(
            @PathVariable Integer idItem,
            @RequestParam Integer quantidade) {

        CarrinhoItens atualizado = carrinhoItensService.atualizarQuantidade(idItem, quantidade);
        return ResponseEntity.ok(atualizado);
    }


    // 📌 5. Remover item
    @DeleteMapping("/{idItem}")
    public ResponseEntity<Void> remover(@PathVariable Integer idItem) {

        carrinhoItensService.remover(idItem);
        return ResponseEntity.noContent().build();
    }


    // 📌 6. Listar itens por carrinho específico
    @GetMapping("/carrinho/{idCarrinho}")
    public ResponseEntity<List<CarrinhoItens>> listarPorCarrinho(@PathVariable Integer idCarrinho) {

        return ResponseEntity.ok(carrinhoItensService.listarPorCarrinho(idCarrinho));
    }
}
