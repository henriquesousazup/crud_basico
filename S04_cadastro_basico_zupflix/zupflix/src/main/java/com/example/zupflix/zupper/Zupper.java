package com.example.zupflix.zupper;

import com.example.zupflix.palestra.Palestra;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Zupper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataAdmissao;

    @Column(nullable = false)
    private String email;

    @ManyToMany(mappedBy = "palestrantes")
    private Set<Palestra> palestras = new HashSet<>();

    @Deprecated
    /**
     * @deprecated uso exclusivo do hibernate
     */
    public Zupper() {
    }

    public Zupper(String nome, LocalDate dataAdmissao, String email) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Palestra palestra) {
        palestra.adiciona(this);
        this.palestras.add(palestra);
    }
}
