package com.example.figurinhas.controller;

import com.example.figurinhas.model.Album;
import com.example.figurinhas.repository.AlbumRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/albuns")
public class NovoAlbumController {

    private final AlbumRepository albumRepository;

    public NovoAlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid AlbumRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Album novoAlbum = request.toModel();
        albumRepository.save(novoAlbum);

        URI location = uriComponentsBuilder.path("/albuns/{id}").buildAndExpand(novoAlbum.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
