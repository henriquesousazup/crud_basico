package com.example.pets.pet;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class PetRequest {

    @NotBlank
    private String nome;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull
    private TipoPetRequest tipo;

    @NotBlank
    private String raca;

    public PetRequest() {
    }

    public PetRequest(String nome, LocalDate dataNascimento, TipoPetRequest tipo, String raca) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
        this.raca = raca;
    }

    public Pet paraPet() {
        return new Pet(nome, dataNascimento, TipoPet.valueOf(tipo.name()), raca);
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public TipoPetRequest getTipo() {
        return tipo;
    }

    public String getRaca() {
        return raca;
    }
}
