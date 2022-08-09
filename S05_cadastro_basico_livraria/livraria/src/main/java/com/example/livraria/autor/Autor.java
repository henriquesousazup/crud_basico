package com.example.livraria.autor;

import javax.persistence.*;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 2500)
    @Lob
    private String descricao;

    @Deprecated
    /**
     * @deprecated uso exclusido do hibernate
     */
    public Autor() {
    }

    public Autor(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }
}