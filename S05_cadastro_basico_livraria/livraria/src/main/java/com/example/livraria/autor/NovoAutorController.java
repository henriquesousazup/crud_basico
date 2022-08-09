package com.example.livraria.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class NovoAutorController {

    private final AutorRepository repository;

    public NovoAutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid AutorRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Autor novoAutor = request.toModel();
        repository.save(novoAutor);

        URI location = uriComponentsBuilder.path("/autores/{id}").buildAndExpand(novoAutor.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
