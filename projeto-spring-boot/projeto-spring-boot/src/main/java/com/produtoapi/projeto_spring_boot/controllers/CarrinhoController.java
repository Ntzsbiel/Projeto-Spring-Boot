package com.produtoapi.projeto_spring_boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.produtoapi.projeto_spring_boot.entities.Carrinho;
import com.produtoapi.projeto_spring_boot.services.CarrinhoService;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    //  Criar um novo carrinho
    @PostMapping
    public Carrinho criarCarrinho() {
        return carrinhoService.criar();
    }

    //  Buscar carrinho por ID
    @GetMapping("/{id}")
    public Carrinho buscarPorId(@PathVariable Integer id) {
        return carrinhoService.buscarPorId(id);
    }

    //  Listar todos os carrinhos
    @GetMapping
    public List<Carrinho> listarCarrinhos() {
        return carrinhoService.listar();
    }

    //  Finalizar carrinho
    @PutMapping("/{id}/finalizar")
    public Carrinho finalizar(@PathVariable Integer id) {
        return carrinhoService.finalizar(id);
    }

    //  Cancelar carrinho
    @PutMapping("/{id}/cancelar")
    public Carrinho cancelar(@PathVariable Integer id) {
        return carrinhoService.cancelar(id);
    }

    //  Calcular total do carrinho
    @GetMapping("/{id}/total")
    public String calcularTotal(@PathVariable Integer id) {
        return carrinhoService.calcularTotal(id).toString();
    }

}
