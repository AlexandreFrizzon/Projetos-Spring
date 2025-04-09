package com.example.exercicio02.service.notificacoes;

public class NotificacaoEquipeInterna implements Notificador {
    public void notificar(String mensagem) {
        System.out.println("Notificando equipe interna: " + mensagem);

    }
}