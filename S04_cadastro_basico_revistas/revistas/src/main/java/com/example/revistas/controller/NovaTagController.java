package com.example.revistas.controller;

import com.example.revistas.model.Tag;
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
@RequestMapping("/tags")
public class NovaTagController {

    private final TagRepository tagRepository;

    public NovaTagController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid TagRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Tag novaTag = request.toModel();
        tagRepository.save(novaTag);

        URI location = uriComponentsBuilder.path("/tags/{id}").buildAndExpand(novaTag.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
