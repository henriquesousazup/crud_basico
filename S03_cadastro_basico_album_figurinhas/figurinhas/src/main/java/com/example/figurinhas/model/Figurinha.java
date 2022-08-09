package com.example.figurinhas.model;

import javax.persistence.*;

@Entity
public class Figurinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer pagina;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne(optional = false)
    private Album album;

    @Deprecated
    /**
     * @deprecated uso exclusivo do hibernate
     */
    public Figurinha() {
    }

    public Figurinha(Integer pagina, String descricao) {
        this.pagina = pagina;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
