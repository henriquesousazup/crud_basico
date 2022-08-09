package com.example.pets.pet;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    // Definir que o valor a ser salvo é uma String
    @Enumerated(EnumType.STRING)
    private TipoPet tipo;

    @Column(nullable = false)
    private String raca;

    @Deprecated
    /**
     * @deprecated uso exclusivo para o hibernete
     */
    public Pet() {
    }

    public Pet(String nome, LocalDate dataNascimento, TipoPet tipo, String raca) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
        this.raca = raca;
    }

    public Long getId() {
        return id;
    }
}
