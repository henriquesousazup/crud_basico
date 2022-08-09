package com.example.zupper.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Zupper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CargoEnum cargo;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "zupper")
    private List<Endereco> enderecos = new ArrayList<>();

    @Deprecated
    /**
     * @deprecated para uso exclusivo do hibernate
     */
    public Zupper() {
    }

    public Zupper(String nome, String email, CargoEnum cargo) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Endereco endereco) {
        endereco.setZupper(this);
        this.enderecos.add(endereco);
    }
}
