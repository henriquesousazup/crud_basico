package com.example.livraria.autor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@RestController
@RequestMapping("autores/{id}")
public class DeletarAutorController {

    private final AutorRepository repository;

    public DeletarAutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        Autor autor = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album não encontrado."));

        repository.delete(autor);

        return ResponseEntity.noContent().build();
    }
}
