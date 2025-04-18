package com.example.jpql.controller;

import com.example.jpql.model.Produto;
import com.example.jpql.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @GetMapping
    public List<Produto> listar(){
        return produtoService.listarTodos();
    }

    @GetMapping("/acima")
    public List<Produto> acimaQue(@RequestParam double valor){
        return produtoService.buscarPorPrecoMaiorQue(valor);
    }
}
