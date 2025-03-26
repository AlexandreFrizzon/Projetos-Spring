package com.exercicios.exericio2.controller;

import com.exercicios.exericio2.model.Cliente;
import com.exercicios.exericio2.model.Pedido;
import com.exercicios.exericio2.model.Produto;
import com.exercicios.exericio2.repository.ClienteRepository;
import com.exercicios.exericio2.repository.PedidoRepository;
import com.exercicios.exericio2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Pedido criarPedido(@RequestParam Long clienteId, @RequestBody List<Long> produtosIds) {
        Cliente cliente = clienteRepository.buscarPorId(clienteId);
        List<Produto> produtos = produtosIds.stream()
                .map(produtoRepository::buscarPorId)
                .collect(Collectors.toList());

        Pedido pedido = new Pedido(null, cliente, produtos);
        return pedidoRepository.salvar(pedido);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoRepository.listarTodos();
    }

    @GetMapping("/{id}")
    public Pedido buscarPedido(@PathVariable Long id) {
        return pedidoRepository.buscarPorId(id);
    }

    @GetMapping("/{id}/valor-total")
    public double calcularValorTotal(@PathVariable Long id) {
        Pedido pedido = pedidoRepository.buscarPorId(id);
        if (pedido != null) {
            return pedido.calcularValorTotal();
        }
        return 0;
    }
}


