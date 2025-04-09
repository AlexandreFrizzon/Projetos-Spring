package com.example.exercicio02.service;

public class TransportadoraAdapter implements FreteStrategy {
    private TransportadoraExternaAPI api = new TransportadoraExternaAPI();

    @Override
    public double calcularFrete(double peso) {
        return api.calcularPreco(peso);
    }
}
