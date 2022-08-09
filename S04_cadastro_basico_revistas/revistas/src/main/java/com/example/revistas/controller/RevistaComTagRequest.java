package com.example.revistas.controller;

import com.example.revistas.model.Revista;
import com.example.revistas.model.Tag;
import com.example.revistas.repository.TagRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RevistaComTagRequest {

    @NotBlank
    @Length(max = 120)
    private String titulo;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDePublicacao;

    @NotEmpty
    @Size(min = 1)
    private Set<Long> tags = new HashSet<>();

    public RevistaComTagRequest() {
    }

    public RevistaComTagRequest(String titulo, LocalDate dataDePublicacao, Set<Long> tags) {
        this.titulo = titulo;
        this.dataDePublicacao = dataDePublicacao;
        this.tags = tags;
    }

    public Revista toModel(TagRepository tagRepository) {

        Set<Tag> tags = this.tags.stream()
                .map(id -> tagRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Tag não cadastrada")))
                .collect(Collectors.toSet());

        Revista revista = new Revista(titulo, dataDePublicacao);
        tags.forEach(t -> revista.adiciona(t));

        return revista;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public Set<Long> getTags() {
        return tags;
    }
}
