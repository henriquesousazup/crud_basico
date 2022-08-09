package com.example.artigos.model;

import javax.persistence.*;

@Entity
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Lob
    @Column(nullable = false, length = 10000)
    private String corpo;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoArtigo tipo;

    @ManyToOne(optional = false)
    private Blog blog;

    @Deprecated
    /**
     * @deprecated para uso exclusivo do hibernate
     */
    public Artigo() {
    }

    public Artigo(String titulo, String corpo, TipoArtigo tipo, Blog blog) {
        this.titulo = titulo;
        this.corpo = corpo;
        this.tipo = tipo;
        this.blog = blog;
    }

    public Long getId() {
        return id;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
