package com.boleto.apiBoleto.controller;

import com.boleto.apiBoleto.model.BoletoBancario;
import com.boleto.apiBoleto.service.BoletoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boletos")
public class BoletoController {
    private final BoletoService boletoService;
    public BoletoController(BoletoService boletoService) {
        this.boletoService = boletoService;
    }

    @GetMapping
    public List<BoletoBancario> listarBoletos(){
        return boletoService.listarTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BoletoBancario>buscarBoleto(@PathVariable Long id){
        Optional<BoletoBancario> boleto = boletoService.buscarPorId(id);
        return boleto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BoletoBancario>criarBoleto(@Valid @RequestBody BoletoBancario boleto){
        BoletoBancario novoBoleto = boletoService.salvar(boleto);
        return ResponseEntity.ok(novoBoleto);
    }

    @DeleteMapping
    public ResponseEntity<Void>deletarBoleto(@PathVariable Long id){
        if (boletoService.buscarPorId(id).isPresent()){
            boletoService.deletar(id);
        }
        return ResponseEntity.notFound().build();
    }
}
