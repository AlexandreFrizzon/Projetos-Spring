package com.livros.livroRest.controller;
import java.util.List;
import java.util.Optional;

import com.livros.livroRest.Model.Livro;
import com.livros.livroRest.Repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping()
    public List<Livro> listarLivro() {
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Livro> buscarLivroPorId(@PathVariable Long id) {
        return livroRepository.findById(id);
    }

    @PostMapping
    public Livro adicionarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @DeleteMapping("/{id}")
    public String deletarLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return "Produto removido com sucesso";
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro novoLivro) {
        return livroRepository.findById(id).map(produto -> {
            produto.setTitulo(novoLivro.getTitulo());
            return livroRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }
}
