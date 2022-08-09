package com.example.zupflix.palestra;

import com.example.zupflix.zupper.Zupper;
import com.example.zupflix.zupper.ZupperRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class PalestraComZupperRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String tema;

    @Min(30)
    private Integer minutos;

    @NotNull
    private TipoExibicaoRequest tipoExibicao;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEHoraExibicao;

    @NotEmpty
    private Set<Long> palestrantes;

    public PalestraComZupperRequest() {
    }

    public PalestraComZupperRequest(String titulo, String tema, Integer minutos, TipoExibicaoRequest tipoExibicao, LocalDateTime dataEHoraExibicao, Set<Long> palestrantes) {
        this.titulo = titulo;
        this.tema = tema;
        this.minutos = minutos;
        this.tipoExibicao = tipoExibicao;
        this.dataEHoraExibicao = dataEHoraExibicao;
        this.palestrantes = palestrantes;
    }

    public Palestra toModel(ZupperRepository zupperRepository) {

        Set<Zupper> zuppersPalestrantes = palestrantes.stream()
                .map(id -> zupperRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Zupper não cadastrado.")))
                .collect(Collectors.toSet());

        Palestra palestra = new Palestra(titulo, tema, minutos, TipoExibicao.valueOf(tipoExibicao.name()), dataEHoraExibicao);
        zuppersPalestrantes.forEach(zupper -> palestra.adiciona(zupper));

        return palestra;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTema() {
        return tema;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public TipoExibicaoRequest getTipoExibicao() {
        return tipoExibicao;
    }

    public LocalDateTime getDataEHoraExibicao() {
        return dataEHoraExibicao;
    }

    public Set<Long> getPalestrantes() {
        return palestrantes;
    }
}
