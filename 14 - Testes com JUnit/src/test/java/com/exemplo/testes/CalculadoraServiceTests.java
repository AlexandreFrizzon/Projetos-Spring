package com.exemplo.testes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculadoraServiceTests {

    @Autowired
    private CalculadoraService calculadoraService;

    @Test
    void somar(){
        int resultado = calculadoraService.somar(2, 3);
        assertEquals(5, resultado);
    }

    @Test
    void dividir(){
        double resultado = calculadoraService.dividir(27, 9);
        assertEquals(3.0, resultado);
    }

    @Test
    void excecao(){
        assertThrows(IllegalArgumentException.class, ()-> {
            calculadoraService.dividir(5, 0);
        });
    }

    @Test
    void subtrair(){
        int resultado = calculadoraService.subtrair(22, 8);
        assertEquals(14, resultado);
    }

    @Test
    void multiplicar(){
        int resultado = calculadoraService.multiplicar(10, 10);
        assertEquals(100, resultado);
    }

}
