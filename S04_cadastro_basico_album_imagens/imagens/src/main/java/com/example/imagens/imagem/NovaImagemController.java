package com.example.imagens.imagem;

import com.example.imagens.album.Album;
import com.example.imagens.album.AlbumRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/albuns/{idAlbum}/imagens")
public class NovaImagemController {

    private final ImagemRepository imagemRepository;
    private final AlbumRepository albumRepository;


    public NovaImagemController(ImagemRepository imagemRepository, AlbumRepository albumRepository) {
        this.imagemRepository = imagemRepository;
        this.albumRepository = albumRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@PathVariable Long idAlbum, @RequestBody @Valid ImagemRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Album album = albumRepository.findById(idAlbum)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album não cadastrado."));

        Imagem novaImagem = request.toModel(album);
        imagemRepository.save(novaImagem);

        URI location = uriComponentsBuilder.path("/albuns/{idAlbum}/imagens/{id}").buildAndExpand(album.getId(), novaImagem.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
