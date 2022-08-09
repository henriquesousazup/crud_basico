package com.example.zupflix.palestra;

import com.example.zupflix.zupper.Zupper;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Palestra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String tema;

    @Column(nullable = false)
    private Integer minutos;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoExibicao tipoExibicao;

    @Column(nullable = false)
    private LocalDateTime dataEHoraExibicao;

    @JoinTable(
            name = "palestra_zupper",
            joinColumns = @JoinColumn(name = "palestra_id"),
            inverseJoinColumns = @JoinColumn(name = "zupper_id")
    )
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Zupper> palestrantes = new HashSet<>();

    @Deprecated
    /**
     * @deprecated uso exclusivo do hibernate
     */
    public Palestra() {
    }

    public Palestra(String titulo, String tema, Integer minutos, TipoExibicao tipoExibicao, LocalDateTime dataEHoraExibicao) {
        this.titulo = titulo;
        this.tema = tema;
        this.minutos = minutos;
        this.tipoExibicao = tipoExibicao;
        this.dataEHoraExibicao = dataEHoraExibicao;
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Zupper zupper) {
        this.palestrantes.add(zupper);
    }
}
