package com.boleto.apiBoleto.service;

import com.boleto.apiBoleto.model.BoletoBancario;
import com.boleto.apiBoleto.repository.BoletoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletoService {
    private final BoletoRepository boletoRepository;
    public BoletoService(BoletoRepository boletoRepository) {
        this.boletoRepository = boletoRepository;
    }

    public List<BoletoBancario>listarTodos(){
        return boletoRepository.findAll();
    }

    public Optional<BoletoBancario> buscarPorId(Long id){
        return boletoRepository.findById(id);
    }

    public BoletoBancario salvar(BoletoBancario boleto){
        return boletoRepository.save(boleto);
    }

    public void deletar(Long id){
        boletoRepository.deleteById(id);
    }
}
