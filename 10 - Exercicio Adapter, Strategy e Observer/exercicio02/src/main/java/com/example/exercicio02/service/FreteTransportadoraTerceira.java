package com.example.exercicio02.service;

public class FreteTransportadoraTerceira implements FreteStrategy {
    @Override
    public double calcularFrete(double peso) {
        return peso * 7.5;
    }
}
