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

    // ------------------------------------------------------------
    // 📌 1. LISTAGEM
    // ------------------------------------------------------------

    // Listar todos os itens de todos os carrinhos
    @GetMapping
    public ResponseEntity<List<CarrinhoItens>> listarTodos() {
        return ResponseEntity.ok(carrinhoItensService.listar());
    }

    // Listar itens de um carrinho específico
    @GetMapping("/carrinho/{idCarrinho}")
    public ResponseEntity<List<CarrinhoItens>> listarPorCarrinho(@PathVariable Integer idCarrinho) {
        return ResponseEntity.ok(carrinhoItensService.listarPorCarrinho(idCarrinho));
    }

    // ------------------------------------------------------------
    // 📌 2. CRIAÇÃO / ADIÇÃO
    // ------------------------------------------------------------

    // Adicionar item ao carrinho
    @PostMapping("/adicionar")
    public ResponseEntity<CarrinhoItens> adicionar(
            @RequestParam("idCarrinho") Integer idCarrinho,
            @RequestParam("idProduto") Integer idProduto,
            @RequestParam("quantidade") Integer quantidade) {

        CarrinhoItens item = carrinhoItensService.adicionar(idCarrinho, idProduto, quantidade);
        return ResponseEntity.ok(item);
    }

    // ------------------------------------------------------------
    // 📌 3. ATUALIZAÇÃO
    // ------------------------------------------------------------

    @PutMapping("/{idItem}/quantidade")
    public ResponseEntity<CarrinhoItens> atualizarQuantidade(
            @PathVariable Integer idItem,
            @RequestParam("quantidade") Integer quantidade) {

        CarrinhoItens atualizado = carrinhoItensService.atualizarQuantidade(idItem, quantidade);
        return ResponseEntity.ok(atualizado);
    }

    // ------------------------------------------------------------
    // 📌 4. REMOÇÃO
    // ------------------------------------------------------------

    @DeleteMapping("/{idItem}")
    public ResponseEntity<Void> remover(@PathVariable Integer idItem) {
        carrinhoItensService.remover(idItem);
        return ResponseEntity.noContent().build();
    }

    // ------------------------------------------------------------
    // 📌 5. CONSULTA POR ID (FICA SEMPRE NO FINAL)
    // ------------------------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoItens> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(carrinhoItensService.buscarPorId(id));
    }
}
