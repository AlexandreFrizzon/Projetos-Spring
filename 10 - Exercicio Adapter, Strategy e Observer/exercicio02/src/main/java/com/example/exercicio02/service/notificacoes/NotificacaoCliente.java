package com.example.exercicio02.service.notificacoes;

public class NotificacaoCliente implements Notificador {
    public void notificar(String mensagem) {
        System.out.println("Notificando cliente: " + mensagem);
    }
}

