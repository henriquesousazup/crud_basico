package com.example.avaliacao.controller;

import com.example.avaliacao.model.Aluno;
import com.example.avaliacao.model.Avaliacao;

import javax.validation.constraints.NotBlank;

public class AvaliacaoRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String atividade;

    public AvaliacaoRequest() {
    }

    public AvaliacaoRequest(String titulo, String atividade) {
        this.titulo = titulo;
        this.atividade = atividade;
    }

    public Avaliacao paraAvaliacao(Aluno aluno) {
        return new Avaliacao(titulo, atividade, aluno);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAtividade() {
        return atividade;
    }
}
