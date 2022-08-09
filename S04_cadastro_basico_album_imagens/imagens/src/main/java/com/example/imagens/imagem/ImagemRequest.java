package com.example.imagens.imagem;

import com.example.imagens.album.Album;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ImagemRequest {

    @NotBlank
    private String descricao;

    @NotBlank
    private String link;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime criadoEm;

    public ImagemRequest() {
    }

    public ImagemRequest(String descricao, String link, LocalDateTime criadoEm) {
        this.descricao = descricao;
        this.link = link;
        this.criadoEm = criadoEm;
    }

    public Imagem toModel(Album album) {
        Imagem imagem = new Imagem(descricao, link, criadoEm);
        imagem.adiciona(album);
        return imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLink() {
        return link;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}
