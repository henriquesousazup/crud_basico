package com.example.demo.controller;

import com.example.demo.model.Acidente;
import com.example.demo.model.Carro;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

public class AcidenteRequest {

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cep;

    @NotBlank
    private String observacoes;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dateEHoraAcontecimento;

    public AcidenteRequest() {
    }

    public AcidenteRequest(String cidade, String estado, String logradouro, String bairro, String cep, String observacoes, LocalDateTime dateEHoraAcontecimento) {
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.observacoes = observacoes;
        this.dateEHoraAcontecimento = dateEHoraAcontecimento;
    }

    public Acidente paraAcidente(Carro carro){
        return new Acidente(cidade,estado,logradouro,bairro,cep,observacoes,dateEHoraAcontecimento,carro);
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public LocalDateTime getDateEHoraAcontecimento() {
        return dateEHoraAcontecimento;
    }
}
