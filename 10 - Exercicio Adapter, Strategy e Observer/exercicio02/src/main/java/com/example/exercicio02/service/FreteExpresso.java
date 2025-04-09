package com.example.exercicio02.service;

public class FreteExpresso implements FreteStrategy {
    @Override
    public double calcularFrete(double peso) {
        return peso * 10.0;
    }
}
