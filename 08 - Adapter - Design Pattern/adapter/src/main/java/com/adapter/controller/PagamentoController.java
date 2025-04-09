package com.adapter.controller;

import com.adapter.service.PagamentoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(@Qualifier("paypal") PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public String pagar(@RequestParam double valor) {
        pagamentoService.processarPagamento(valor);
        return "Pagamento processado com sucesso!";
    }
}
