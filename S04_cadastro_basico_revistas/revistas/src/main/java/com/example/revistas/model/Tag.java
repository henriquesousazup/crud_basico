package com.example.revistas.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "tags")
    private Set<Revista> revistas = new HashSet<>();

    @Deprecated
    /**
     * @deprecated uso exclusivo do hibernate
     */
    public Tag() {
    }

    public Tag(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Revista revista){
        revista.adiciona(this);
        this.revistas.add(revista);
    }
}
