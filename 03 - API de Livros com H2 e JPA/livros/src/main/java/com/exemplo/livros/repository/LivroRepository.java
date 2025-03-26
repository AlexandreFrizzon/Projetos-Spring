package com.exemplo.livros.repository;

import com.exemplo.livros.model.livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<livro, Integer> {

}

