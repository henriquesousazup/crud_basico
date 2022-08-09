package com.example.demo.controller;

import com.example.demo.model.Carro;
import com.example.demo.model.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class CarroRequest {

    @NotBlank
    private String placa;

    @NotBlank
    @Length(min = 11, max = 11)
    private String renavam;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String chassi;

    @NotNull
    @Positive
    private Integer ano;

    @NotNull
    @Positive
    private BigDecimal valor;

    public CarroRequest() {
    }

    public CarroRequest(String placa, String renavam, String marca, String modelo, String chassi, Integer ano, BigDecimal valor) {
        this.placa = placa;
        this.renavam = renavam;
        this.marca = marca;
        this.modelo = modelo;
        this.chassi = chassi;
        this.ano = ano;
        this.valor = valor;
    }

    public Carro paraCarro(Cliente cliente){
        return new Carro(placa, renavam, marca, modelo, chassi, ano, valor, cliente);
    }

    public String getPlaca() {
        return placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public Integer getAno() {
        return ano;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
