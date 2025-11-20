package com.produtoapi.projeto_spring_boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.produtoapi.projeto_spring_boot.entities.Produto;
import com.produtoapi.projeto_spring_boot.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    // ---------------------- LISTAR ----------------------
    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return ResponseEntity.ok(produtoService.procurarTodos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(produtoService.procurarPorId(id));
    }


    // ---------------------- CRIAR ----------------------
    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        Produto novo = produtoService.adicionarProduto(produto);
        return ResponseEntity.ok(novo);
    }


    // ---------------------- EDITAR ----------------------
    @PutMapping("/{id}")
    public ResponseEntity<Produto> editar(
            @PathVariable Integer id,
            @RequestBody Produto produto
    ) {
        Produto atualizado = produtoService.editarProduto(id, produto);
        return ResponseEntity.ok(atualizado);
    }


    // ---------------------- EXCLUIR ----------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }


    // ---------------------- FUNÇÕES DO ESTOQUE ----------------------
    @PutMapping("/{id}/estoque/aumentar/{qnt}")
    public ResponseEntity<Void> aumentarEstoque(
            @PathVariable Integer id,
            @PathVariable int qnt
    ) {
        produtoService.aumentarEstoque(id, qnt);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}/estoque/diminuir/{qnt}")
    public ResponseEntity<Void> diminuirEstoque(
            @PathVariable Integer id,
            @PathVariable int qnt
    ) {
        produtoService.diminuirEstoque(id, qnt);
        return ResponseEntity.ok().build();
    }
}
