package com.example.games.game;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String link;

    @ManyToMany(mappedBy = "jogos")
    private Set<Pessoa> players = new HashSet<>();

    public Jogo(String nome, String descricao, String link) {
        this.nome = nome;
        this.descricao = descricao;
        this.link = link;
    }

    @Deprecated
    /**
     * @deprecated construtor para uso exclusivo do Hibernate
     */
    public Jogo() {
    }

    public Long getId() {
        return id;
    }

    public void adicionar(Pessoa pessoa) {
        this.players.add(pessoa);
    }
}
