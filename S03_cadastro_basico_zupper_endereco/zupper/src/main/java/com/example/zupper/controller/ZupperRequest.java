package com.example.zupper.controller;

import com.example.zupper.model.CargoEnum;
import com.example.zupper.model.Endereco;
import com.example.zupper.model.Zupper;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class ZupperRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private CargoEnumRequest cargo;

    @Valid
    @NotEmpty
    @Size(min = 2)
    private List<EnderecoRequest> enderecos = new ArrayList<>();

    public ZupperRequest() {
    }

    public ZupperRequest(String nome, String email, CargoEnumRequest cargo, List<EnderecoRequest> enderecos) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.enderecos = enderecos;
    }

    public Zupper toModel() {
        Zupper zupper = new Zupper(nome, email, CargoEnum.valueOf(cargo.name()));
        enderecos.forEach(e -> zupper.adiciona(e.toModel(zupper)));

        return zupper;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public CargoEnumRequest getCargo() {
        return cargo;
    }

    public List<EnderecoRequest> getEnderecos() {
        return enderecos;
    }
}
