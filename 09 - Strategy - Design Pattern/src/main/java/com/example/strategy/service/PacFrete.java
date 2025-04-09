package com.example.strategy.service;

import org.springframework.stereotype.Component;

@Component
public class PacFrete implements FreteStrategy{
    @Override
    public double calcular(double peso){
        return peso * 1.0;
    }

    @Override
    public String tipo(){
        return "Pac";
    }
}
