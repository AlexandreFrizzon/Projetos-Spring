package com.exercicios.exericio2.repository;

import org.springframework.stereotype.Repository;
import com.exercicios.exericio2.model.Cliente;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();
    private Long nextId = 1L;

    public Cliente salvar(Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> listarTodos() {
        return clientes;
    }

    public Cliente buscarPorId(Long id) {
        return clientes.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }
}
