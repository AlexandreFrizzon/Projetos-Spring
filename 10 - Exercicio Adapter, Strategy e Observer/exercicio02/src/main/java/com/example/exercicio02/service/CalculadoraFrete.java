package com.example.exercicio02.service;

public class CalculadoraFrete {
    public FreteStrategy estrategia;

    public void setEstrategia(FreteStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(double peso) {
        return estrategia.calcularFrete(peso);
    }
}
