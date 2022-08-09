package com.example.revistas.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Revista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(nullable = false)
    private LocalDate dataDePublicacao;

    @JoinTable(
            name = "revista_tag",
            joinColumns = @JoinColumn(name = "revista_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Tag> tags = new HashSet<>();

    @Deprecated
    /**
     * @deprecated uso exclusivo do hibernate
     */
    public Revista() {
    }

    public Revista(String titulo, LocalDate dataDePublicacao) {
        this.titulo = titulo;
        this.dataDePublicacao = dataDePublicacao;
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Tag tag) {
        this.tags.add(tag);
    }
}
