package com.exercicios.exericio2.repository;

import org.springframework.stereotype.Repository;
import com.exercicios.exericio2.model.Pedido;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {
    private final List<Pedido> pedidos = new ArrayList<>();
    private Long nextId = 1L;

    public Pedido salvar(Pedido pedido) {
        pedido.setId(nextId++);
        pedidos.add(pedido);
        return pedido;
    }

    public List<Pedido> listarTodos() {
        return pedidos;
    }

    public Pedido buscarPorId(Long id) {
        return pedidos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}