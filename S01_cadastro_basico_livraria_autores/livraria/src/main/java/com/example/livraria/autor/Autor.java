package com.example.livraria.autor;

import javax.persistence.*;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false, length = 120)
    private String email;

    @Lob
    @Column(nullable = false, length = 2500)
    private String descricao;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Deprecated
    /**
     * @deprecated construtor para uso exclusido do hibernate
     */
    public Autor() {
    }

    public Autor(String nome, String email, String descricao, String cpf) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }
}
