package com.example.strategy.service;

import org.springframework.stereotype.Component;

@Component
public class SedexFrete implements FreteStrategy {
    @Override
    public double calcular(double peso){
        return peso * 1.5;
    }

    @Override
    public String tipo(){
        return "Sedex";
    }
}
