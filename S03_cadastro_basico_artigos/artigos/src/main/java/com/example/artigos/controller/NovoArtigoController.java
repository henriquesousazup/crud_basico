package com.example.artigos.controller;

import com.example.artigos.model.Artigo;
import com.example.artigos.model.Blog;
import com.example.artigos.repository.ArtigoRepository;
import com.example.artigos.repository.BlogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("blogs/{idBlog}/artigos")
public class NovoArtigoController {

    private final ArtigoRepository artigoRepository;
    private final BlogRepository blogRepository;

    public NovoArtigoController(ArtigoRepository artigoRepository, BlogRepository blogRepository) {
        this.artigoRepository = artigoRepository;
        this.blogRepository = blogRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastra(@PathVariable Long idBlog, @RequestBody @Valid ArtigoRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Blog blog = blogRepository.findById(idBlog).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog não cadastrado no sistema"));

        Artigo novoArtigo = request.toModel(blog);
        artigoRepository.save(novoArtigo);

        URI location = uriComponentsBuilder.path("blogs/{idBlog}/artigos/{id}").buildAndExpand(blog.getId(), novoArtigo.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
