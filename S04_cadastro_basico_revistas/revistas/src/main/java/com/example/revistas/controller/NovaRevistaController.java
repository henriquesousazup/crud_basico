package com.example.revistas.controller;

import com.example.revistas.model.Revista;
import com.example.revistas.repository.RevistaRepository;
import com.example.revistas.repository.TagRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/revistas")
public class NovaRevistaController {

    private final RevistaRepository revistaRepository;
    private final TagRepository tagRepository;

    public NovaRevistaController(RevistaRepository revistaRepository, TagRepository tagRepository) {
        this.revistaRepository = revistaRepository;
        this.tagRepository = tagRepository;
    }

    @PostMapping
    private ResponseEntity<Void> cadastrar(@RequestBody @Valid RevistaComTagRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Revista novaRevista = request.toModel(tagRepository);
        revistaRepository.save(novaRevista);

        URI location = uriComponentsBuilder.path("/revistas/{id}").buildAndExpand(novaRevista.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
