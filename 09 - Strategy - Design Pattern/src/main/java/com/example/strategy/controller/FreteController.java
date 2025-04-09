package com.example.strategy.controller;

import com.example.strategy.service.FreteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fretes")
public class FreteController {
    private final FreteService freteService;

    public FreteController(FreteService freteService) {
        this.freteService = freteService;
    }

    @GetMapping
    public String calcularFrete(@RequestParam String tipo, @RequestParam double peso){
        double valor = freteService.calcular(tipo, peso);
        return "Frete (" + tipo + ") para " + peso + "Kg: " + valor;
    }
}
