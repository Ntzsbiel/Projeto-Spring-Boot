package com.produtoapi.projeto_spring_boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtoapi.projeto_spring_boot.entities.Carrinho;
import com.produtoapi.projeto_spring_boot.entities.Produto;
import com.produtoapi.projeto_spring_boot.repositories.CarrinhoRepository;
import com.produtoapi.projeto_spring_boot.repositories.ProdutoRepository;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepo;

    @Autowired
    private ProdutoRepository produtoRepo;


    // Criar carrinho vazio
    public Carrinho criar() {
        Carrinho c = new Carrinho();
        c.setStatus("ABERTO");
        return carrinhoRepo.save(c);
    }


    // Buscar carrinho pelo ID
    public Carrinho buscarPorId(Integer id) {
        return carrinhoRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Carrinho não encontrado!"));
    }


    // Listar todos
    public List<Carrinho> listar() {
        return carrinhoRepo.findAll();
    }


    // Adicionar item ao carrinho
    public Carrinho adicionarItem(Integer idCarrinho, Integer idProduto, Integer quantidade) {

        Carrinho carrinho = buscarPorId(idCarrinho);

        Produto produto = produtoRepo
        		.findById(idProduto)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        // chama a lógica que está dentro da entidade
        carrinho.adicionarItem(produto, quantidade);

        return carrinhoRepo.save(carrinho);
    }


    //  Remover item
    public Carrinho removerItem(Integer idCarrinho, Integer idItem) {

        Carrinho carrinho = buscarPorId(idCarrinho);
        carrinho.removerItem(idItem);

        return carrinhoRepo.save(carrinho);
    }


    //  Atualizar quantidade
    public Carrinho atualizarQuantidade(Integer idCarrinho, Integer idItem, Integer novaQuantidade) {

        Carrinho carrinho = buscarPorId(idCarrinho);
        carrinho.atualizarQuantidade(idItem, novaQuantidade);

        return carrinhoRepo.save(carrinho);
    }


    // Finalizar
    public Carrinho finalizar(Integer idCarrinho) {

        Carrinho carrinho = buscarPorId(idCarrinho);
        carrinho.finalizar();

        return carrinhoRepo.save(carrinho);
    }


    //  Cancelar todo o carrinho
    public Carrinho cancelar(Integer idCarrinho) {

        Carrinho carrinho = buscarPorId(idCarrinho);
        carrinho.cancelar();

        return carrinhoRepo.save(carrinho);
    }


    //  Calcular total
    public String calcularTotal(Integer idCarrinho) {
        Carrinho carrinho = buscarPorId(idCarrinho);

        return "Valor total: R$ " + carrinho.calcularTotal();
    }
}
