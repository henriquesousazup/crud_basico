package com.example.avaliacao.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String bootcamp;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime dataEHoraCadastro;

    @Deprecated
    /**
     * @deprecated para uso exclusivo do Hibernate
     */
    public Aluno() {
    }

    public Aluno(String nome, String email, String bootcamp) {
        this.nome = nome;
        this.email = email;
        this.bootcamp = bootcamp;
    }

    public Long getId() {
        return id;
    }
}
