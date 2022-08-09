package com.example.figurinhas.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Lob
    @Column(nullable = false, length = 500)
    private String descricao;

    @Column(nullable = false, length = 100)
    private Integer numeroPaginas;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "album")
    private List<Figurinha> figurinhas = new ArrayList<>();

    @Deprecated
    /**
     * @deprecated uso exclusivo do hibernate
     */
    public Album() {
    }

    public Album(String titulo, String descricao, Integer numeroPaginas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.numeroPaginas = numeroPaginas;
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Figurinha figurinha){
        figurinha.setAlbum(this);
        this.figurinhas.add(figurinha);
    }
}
