package com.example.jpql.service;

import com.example.jpql.model.Produto;
import com.example.jpql.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public List<Produto> buscarPorPrecoMaiorQue(double valor){
        return produtoRepository.buscarProdutosCaros(valor);
    }
}
