package com.exercicios.exericio2.controller;

import java.util.List;
import com.exercicios.exericio2.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.exercicios.exericio2.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.salvar(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.listarTodos();
    }
}