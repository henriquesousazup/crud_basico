package com.example.pessoa.pessoa;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String apelido;

    @Column(nullable = false)
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate dataNascimento, String apelido, String cpf) {
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
