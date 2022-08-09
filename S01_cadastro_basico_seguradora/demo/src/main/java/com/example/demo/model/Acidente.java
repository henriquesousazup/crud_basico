package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Acidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String observacoes;

    @Column(nullable = false)
    private LocalDateTime dateEHoraAcontecimento;

    @ManyToOne(optional = false)
    private Carro carro;

    @Deprecated
    /**
     * @deprecated construtor para uso exclusívo do hibernate
     */
    public Acidente() {
    }

    public Acidente(String cidade, String estado, String logradouro, String bairro, String cep, String observacoes, LocalDateTime dateEHoraAcontecimento, Carro carro) {
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.observacoes = observacoes;
        this.dateEHoraAcontecimento = dateEHoraAcontecimento;
        this.carro = carro;
    }

    public Long getId() {
        return id;
    }
}
