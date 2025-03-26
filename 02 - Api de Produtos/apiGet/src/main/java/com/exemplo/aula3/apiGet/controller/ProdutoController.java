package com.exemplo.aula3.apiGet.controller;

import com.exemplo.aula3.apiGet.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @GetMapping
    public List<Produto> listarProdutos(){
        return List.of(
                new Produto(1L,"Notebook", 3500.00),
                new Produto(2L, "Mouse Gamer", 1500.00),
                new Produto(3L, "Teclado", 800.00)
        );
    }
}
