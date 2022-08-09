package com.example.artigos.controller;

import com.example.artigos.model.Artigo;
import com.example.artigos.model.Blog;
import com.example.artigos.model.TipoArtigo;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ArtigoRequest {

    @NotBlank
    @Length(max = 200)
    private String titulo;

    @NotBlank
    @Length(max = 10000)
    private String corpo;

    @NotNull
    private TipoArtigoRequest tipo;

    public ArtigoRequest() {
    }

    public ArtigoRequest(String titulo, String corpo, TipoArtigoRequest tipo) {
        this.titulo = titulo;
        this.corpo = corpo;
        this.tipo = tipo;
    }

    public Artigo toModel(Blog blog) {
        return new Artigo(titulo, corpo, TipoArtigo.valueOf(tipo.name()), blog);
    }


    public String getTitulo() {
        return titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public TipoArtigoRequest getTipo() {
        return tipo;
    }
}
