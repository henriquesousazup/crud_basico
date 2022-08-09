package com.example.figurinhas.controller;

import com.example.figurinhas.model.Album;
import com.example.figurinhas.model.Figurinha;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class AlbumRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    @Length(max = 500)
    private String descricao;

    @NotNull
    @Positive
    @Min(10)
    @Max(100)
    private Integer numeroPaginas;

    @Valid
    @NotEmpty
    private List<FigurinhaRequest> figurinhas;

    public AlbumRequest() {
    }

    public AlbumRequest(String titulo, String descricao, Integer numeroPaginas, List<Figurinha> figurinhas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.numeroPaginas = numeroPaginas;
    }

    public Album toModel() {
        Album album = new Album(titulo, descricao, numeroPaginas);
        figurinhas.forEach(f -> album.adiciona(f.toModel()));

        return album;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public List<FigurinhaRequest> getFigurinhas() {
        return figurinhas;
    }
}
