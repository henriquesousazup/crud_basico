package com.example.imagens.imagem;

import com.example.imagens.album.Album;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private LocalDateTime criadoEm;

    @ManyToMany(mappedBy = "imagens")
    private Set<Album> albuns = new HashSet<>();

    @Deprecated
    /**
     * @deprecated uso exclusívo do hibernate
     */
    public Imagem() {
    }

    public Imagem(String descricao, String link, LocalDateTime criadoEm) {
        this.descricao = descricao;
        this.link = link;
        this.criadoEm = criadoEm;
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Album album) {
        album.adiciona(this);
        this.albuns.add(album);
    }
}
