package com.example.demo.controller;

import com.example.demo.model.Cliente;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ClienteRequest {

    @NotBlank
    @Length(max = 25)
    private String nome;

    @NotBlank
    @Length(max = 25)
    private String sobrenome;

    @CPF
    @NotBlank
    private String cpf;

    @Positive
    @NotNull
    private Integer rg;

    @NotBlank
    @Length(min = 30, max = 200)
    private String endereco;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min = 14, max = 14)
    private String telefone;

    public ClienteRequest() {
    }

    public Cliente paraCliente() {
        return new Cliente(nome, sobrenome, cpf, rg, endereco, email,telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
