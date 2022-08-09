package com.example.artigos.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataEHoraCriacao;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "blog")
    private List<Artigo> artigos = new ArrayList<>();

    @Deprecated
    /**
     * @deprecated uso exclusívo do hibernate
     */
    public Blog() {
    }

    public Blog(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Artigo artigo){
        artigo.setBlog(this);
        this.artigos.add(artigo);
    }
}
