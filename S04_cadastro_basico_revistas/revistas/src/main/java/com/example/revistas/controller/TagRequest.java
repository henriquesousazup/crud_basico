package com.example.revistas.controller;

import com.example.revistas.model.Tag;

import javax.validation.constraints.NotBlank;

public class TagRequest {

    @NotBlank
    private String nome;

    public TagRequest() {
    }

    public TagRequest(String nome) {
        this.nome = nome;
    }

    public Tag toModel(){
        return new Tag(nome);
    }

    public String getNome() {
        return nome;
    }
}
