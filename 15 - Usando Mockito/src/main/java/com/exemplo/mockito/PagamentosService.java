package com.exemplo.mockito;

import org.springframework.stereotype.Service;

@Service
public class PagamentosService {
    public boolean processarPagamento (double valor) {
        System.out.println("Processando Pagamentos de R$" + valor);
        return true;
    }
}
