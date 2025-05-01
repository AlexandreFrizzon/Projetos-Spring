package com.imagens.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImagemService {
    private final Path pastaImagens = Paths.get("imagens");

    public ImagemService() {
        try {
            Files.createDirectories(pastaImagens);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar pasta para salvar imagens", e);
        }
    }

    public String salvarImagem(MultipartFile arquivo) {
        try{
            String nomeOriginal = StringUtils.cleanPath(arquivo.getOriginalFilename());
            Path caminho = pastaImagens.resolve(nomeOriginal);
            Files.copy(arquivo.getInputStream(),caminho, StandardCopyOption.REPLACE_EXISTING);
            return nomeOriginal;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar imagem", e);
        }
    }

    public Resource carregarImagem(String nomeArquivo) {
        try{
            Path caminho = pastaImagens.resolve(nomeArquivo);
            Resource resource = new UrlResource(caminho.toUri());
            if (resource.exists() && resource.isReadable()){
                return resource;
            } else{
                throw new RuntimeException("Imagem não encontrada");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Erro ao carregar a imagem", e);
        }
    }

}