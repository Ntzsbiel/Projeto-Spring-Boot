package com.produtoapi.projeto_spring_boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.produtoapi.projeto_spring_boot.entities.Categoria;
import com.produtoapi.projeto_spring_boot.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // GET - listar todas as categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> procurarTodos() {
        return ResponseEntity.ok(categoriaService.procuraTodos());
    }

    // GET - procurar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> procurarPorId(@PathVariable Integer id) {
        Categoria categoria = categoriaService.procurarPorId(id);
        return ResponseEntity.ok(categoria);
    }

    // POST - adicionar categoria
    @PostMapping
    public ResponseEntity<String> adicionarCategoria(@Validated @RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.adicionarCategoria(categoria));
    }

    // PUT - editar categoria
    @PutMapping("/{id}")
    public ResponseEntity<String> editarCategoria(
        @PathVariable Integer id, 
        @Validated @RequestBody Categoria categoria) {

        return ResponseEntity.ok(categoriaService.editarCategoria(id, categoria));
    }

    // DELETE - excluir categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCategoria(@PathVariable Integer id) {
        categoriaService.excluirCategoria(id);
        return ResponseEntity.ok("Categoria excluída com sucesso!");
    }
}
