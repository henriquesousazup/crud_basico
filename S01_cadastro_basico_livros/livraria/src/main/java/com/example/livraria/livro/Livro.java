package com.example.livraria.livro;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 4000)
    private String titulo;

    @Column(nullable = false, length = 4000)
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataPublicacao;

    @Column(nullable = false, length = 13)
    private String isbn;

    @Deprecated
    /**
     * @deprecated construtor para uso do hibernate
     */
    public Livro() {
    }

    public Livro(String titulo, String descricao, LocalDate dataPublicacao, String isbn) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }
}
