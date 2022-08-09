package com.example.livraria.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid LivroRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Livro novoLivro = request.paraLivro();
        repository.save(novoLivro);

        URI location = uriComponentsBuilder.path("/livros/{id}").buildAndExpand(novoLivro.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
