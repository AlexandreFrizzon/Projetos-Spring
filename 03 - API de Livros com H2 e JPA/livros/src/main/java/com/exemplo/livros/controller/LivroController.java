package com.exemplo.livros.controller;

import com.exemplo.livros.model.livro;
import com.exemplo.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<livro> cadastrar(@RequestBody livro livro) {
        livro livroCadastrado = livroRepository.save(livro);
        return ResponseEntity.status(201).body(livroCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<livro>> listar() {
        return ResponseEntity.status(200).body(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<livro> buscar(@PathVariable Integer id) {
        return ResponseEntity.of(livroRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<livro> atualizar(@PathVariable Integer id, @RequestBody livro livro) {
        if (livroRepository.existsById(id)) {
            livro.setId(id);
            return ResponseEntity.ok(livroRepository.save(livro));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
