package br.com.apirestController.apirest.service;

import org.springframework.stereotype.Service;

@Service
public class ContadorService {
    private int contador = 0;
    public int incrementar(){
        return ++contador;
    }
    public int getContador(){
        return contador;
    }
}
