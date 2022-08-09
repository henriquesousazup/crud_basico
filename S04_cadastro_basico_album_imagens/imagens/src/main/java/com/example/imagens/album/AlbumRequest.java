package com.example.imagens.album;

import javax.validation.constraints.NotBlank;

public class AlbumRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    public AlbumRequest() {
    }

    public AlbumRequest(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Album toModel() {
        return new Album(titulo, descricao);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}
