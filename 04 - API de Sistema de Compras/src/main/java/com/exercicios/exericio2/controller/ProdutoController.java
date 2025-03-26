package com.exercicios.exericio2.controller;

import com.exercicios.exericio2.model.Produto;
import com.exercicios.exericio2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoRepository.salvar(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.listarTodos();
    }
}
