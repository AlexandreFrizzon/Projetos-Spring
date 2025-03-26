package com.fatura.apiFatura.service;


import com.fatura.apiFatura.model.Fatura;
import com.fatura.apiFatura.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {
    private final FaturaRepository faturaRepository;

    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public List<Fatura> listarTodos(){
        return faturaRepository.findAll();
    }

    public Fatura salvar(Fatura fatura){
        return faturaRepository.save(fatura);
    }
}
