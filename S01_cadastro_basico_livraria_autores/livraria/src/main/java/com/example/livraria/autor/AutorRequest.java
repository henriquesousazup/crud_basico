package com.example.livraria.autor;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorRequest {

    @NotBlank
    @Length(max = 120)
    private String nome;

    @NotBlank
    @Email
    @Length(max = 120)
    private String email;

    @NotBlank
    @Length(max = 2500)
    private String descricao;

    @NotBlank
    @CPF
    private String cpf;

    public AutorRequest() {
    }

    public AutorRequest(String nome, String email, String descricao, String cpf) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.cpf = cpf;
    }

    public Autor paraAutor() {
        return new Autor(nome, email, descricao, cpf);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCpf() {
        return cpf;
    }
}
