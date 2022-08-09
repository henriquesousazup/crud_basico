package com.example.zupflix.zupper;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ZupperRequest {

    @NotBlank
    private String nome;

    @NotNull
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataAdmissao;

    @Email
    @NotBlank
    private String email;

    public ZupperRequest() {
    }

    public ZupperRequest(String nome, LocalDate dataAdmissao, String email) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.email = email;
    }

    public Zupper toModel() {
        return new Zupper(nome,dataAdmissao,email);
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public String getEmail() {
        return email;
    }
}
