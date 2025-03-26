package com.exercicios.exericio2.repository;

import org.springframework.stereotype.Repository;
import com.exercicios.exericio2.model.Produto;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepository {
    private final List<Produto> produtos = new ArrayList<>();
    private Long nextId = 1L;

    public Produto salvar(Produto produto) {
        produto.setId(nextId++);
        produtos.add(produto);
        return produto;
    }

    public List<Produto> listarTodos() {
        return produtos;
    }

    public Produto buscarPorId(Long id) {
        return produtos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
