package com.example.avaliacao.model;

import javax.persistence.*;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String atividade;

    @ManyToOne(optional = false)
    private Aluno aluno;

    @Deprecated
    /**
     * @deprecated uso exclusivo para o Hibernate
     */
    public Avaliacao() {
    }

    public Avaliacao(String titulo, String atividade, Aluno aluno) {
        this.titulo = titulo;
        this.atividade = atividade;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }
}
