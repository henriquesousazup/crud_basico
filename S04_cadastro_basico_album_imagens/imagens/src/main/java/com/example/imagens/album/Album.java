package com.example.imagens.album;

import com.example.imagens.imagem.Imagem;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @JoinTable(
            name = "album_imagem",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "imagem_id")
    )
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Imagem> imagens = new HashSet<>();

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime criadoEm;

    @Deprecated
    /**
     * @deprecated uso exclusivo do hibernate
     */
    public Album() {
    }

    public Album(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Imagem imagem) {
        this.imagens.add(imagem);
    }
}
