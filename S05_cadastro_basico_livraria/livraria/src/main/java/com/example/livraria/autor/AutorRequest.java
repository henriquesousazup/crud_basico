package com.example.livraria.autor;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class AutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Length(max = 2500)
    private String descricao;

    public AutorRequest() {
    }

    public AutorRequest(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(nome, descricao);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
