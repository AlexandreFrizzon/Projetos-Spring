package com.example.exercicio02.service;

public class FreteEconomico implements FreteStrategy {
    @Override
    public double calcularFrete(double peso) {
        return peso * 5.0;
    }
}