package com.adapter.service;

import org.springframework.stereotype.Service;

@Service("paypal")
public class PagamentoAdapter implements PagamentoService {

    private final PagamentoPaypal paypal;

    public PagamentoAdapter() {
        this.paypal = new PagamentoPaypal();
    }

    @Override
    public void processarPagamento(double valor) {
        paypal.pagarComPaypal(valor); // adaptando!
    }
}
