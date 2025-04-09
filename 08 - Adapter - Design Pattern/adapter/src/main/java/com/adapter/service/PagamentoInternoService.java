package com.adapter.service;

import org.springframework.stereotype.Service;

@Service("interno")
public class PagamentoInternoService implements PagamentoService {

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento interno realizado: R$ " + valor);
    }
}
