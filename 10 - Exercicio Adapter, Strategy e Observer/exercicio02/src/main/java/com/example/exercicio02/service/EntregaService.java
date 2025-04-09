package com.example.exercicio02.service;
import com.example.exercicio02.service.notificacoes.Notificador;

import java.util.ArrayList;
import java.util.List;

public class EntregaService {
    private List<Notificador> observadores = new ArrayList<>();

    public void adicionarObservador(Notificador obs) {
        observadores.add(obs);
    }

    public void processarEntrega(double peso, FreteStrategy strategy) {
        double valor = strategy.calcularFrete(peso);

        for (Notificador obs : observadores) {
            obs.notificar("Entrega processada. Valor do frete: R$ " + valor);
        }
    }
}
