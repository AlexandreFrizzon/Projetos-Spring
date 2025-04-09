package com.example.strategy.service;

import org.springframework.stereotype.Component;

@Component
public class TransportadoraFrete implements FreteStrategy {
    @Override
    public double calcular(double peso){
        return peso * 1.3 + 11;
    }

    @Override
    public String tipo(){
        return "Transportadora";
    }
}
