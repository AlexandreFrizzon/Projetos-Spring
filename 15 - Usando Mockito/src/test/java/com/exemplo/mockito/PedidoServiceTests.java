package com.exemplo.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTests {
    @Mock
    private PagamentosService pagamentosService;

    @InjectMocks
    private PedidoService pedidoService;

    @Test
    void deveConfirmarPedidoComPagamentoAprovado(){
        Mockito.when(pagamentosService.processarPagamento(100.0)).thenReturn(true);
        String resultado = pedidoService.realizarPedido(100.0);
        assertEquals("Pedido confirmado", resultado);
    }

    @Test
    void deveConfirmarPedidoComPagamentoReprovado(){
        Mockito.when(pagamentosService.processarPagamento(50.0)).thenReturn(false);
        String resultado = pedidoService.realizarPedido(50.0);
        assertEquals("Pedido falhou", resultado);
    }

    @Test
    void deveChamarProcessamentoDePagamento(){
        Mockito.when(pagamentosService.processarPagamento(Mockito.anyDouble())).thenReturn(true);
        pedidoService.realizarPedido(200.0);
        Mockito.verify(pagamentosService, Mockito.times(1)).processarPagamento(200.0);
    }

}
