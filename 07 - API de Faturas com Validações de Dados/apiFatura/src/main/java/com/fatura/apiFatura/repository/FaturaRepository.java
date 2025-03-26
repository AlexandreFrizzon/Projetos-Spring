package com.fatura.apiFatura.repository;

import com.fatura.apiFatura.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {
}

