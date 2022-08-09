package com.example.figurinhas.controller;

import com.example.figurinhas.model.Figurinha;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class FigurinhaRequest {

    @NotNull
    @Max(100)
    @Positive
    private Integer pagina;

    @NotBlank
    private String descricao;

    public FigurinhaRequest() {
    }

    public FigurinhaRequest(Integer pagina, String descricao) {
        this.pagina = pagina;
        this.descricao = descricao;
    }

    public Figurinha toModel() {
        return new Figurinha(pagina, descricao);
    }

    public Integer getPagina() {
        return pagina;
    }

    public String getDescricao() {
        return descricao;
    }
}
