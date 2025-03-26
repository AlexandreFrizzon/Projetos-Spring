package br.com.apirestController.apirest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @GetMapping("/{id}")
    public String buscarUsuario(@PathVariable int id){
        return "Usuário com ID: " + id;
    }
}
