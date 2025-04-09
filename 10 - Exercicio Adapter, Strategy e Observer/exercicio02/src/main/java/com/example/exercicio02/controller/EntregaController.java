package com.example.exercicio02.controller;

import com.example.exercicio02.service.*;

import com.example.exercicio02.service.notificacoes.NotificacaoCliente;
import com.example.exercicio02.service.notificacoes.NotificacaoEquipeInterna;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @PostMapping
    public ResponseEntity<String> processarEntrega(@RequestBody EntregaDto request) {

        CalculadoraFrete calculadora = new CalculadoraFrete();
        switch (request.getModalidade().toLowerCase()) {
            case "expresso":
                calculadora.setEstrategia(new FreteExpresso());
                break;
            case "economico":
                calculadora.setEstrategia(new FreteEconomico());
                break;
            case "terceirizada":
                calculadora.setEstrategia(new FreteTransportadoraTerceira());
                break;
            default:
                return ResponseEntity.badRequest().body("Modalidade inválida");
        }

        EntregaService entregaService = new EntregaService();
        entregaService.adicionarObservador(new NotificacaoCliente());
        entregaService.adicionarObservador(new NotificacaoEquipeInterna());

        entregaService.processarEntrega(request.getPeso(), calculadora.estrategia);

        return ResponseEntity.ok("Entrega processada com sucesso!");
    }
}
