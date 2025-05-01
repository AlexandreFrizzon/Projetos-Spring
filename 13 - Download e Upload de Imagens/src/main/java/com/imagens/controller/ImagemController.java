package com.imagens.controller;

import com.imagens.service.ImagemService;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/imagens")
public class ImagemController {
    private final ImagemService service;

    public ImagemController(ImagemService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("arquivo") MultipartFile file) {
        String nomeSalvo = service.salvarImagem(file);
        return ResponseEntity.ok("Imagem Salva com nome: " + nomeSalvo);
    }

    @GetMapping("/download/{nome}")
    public ResponseEntity<Resource> download(@PathVariable("nome") String nome) {
        Resource imagem = service.carregarImagem(nome);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attacment; filename=\"" + imagem.getFilename() + "\"")
                .body(imagem);
    }
}
