package com.example.pessoa.pessoa;

import java.time.LocalDate;

public class PessoaResponse {

    private final String nome;
    private final LocalDate dataNascimento;
    private final String apelido;
    private final String cpf;

    public PessoaResponse(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.apelido = pessoa.getApelido();
        this.cpf = pessoa.getCpf();
    }

    public PessoaResponse(String nome, LocalDate dataNascimento, String apelido, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.apelido = apelido;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getApelido() {
        return apelido;
    }

    public String getCpf() {
        return cpf;
    }
}
