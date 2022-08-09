package com.example.pets.pet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/pets/{id}")
public class DeletarPetController {

    private final PetRepository repository;

    public DeletarPetController(PetRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        Pet pet = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não cadastrado."));

        repository.delete(pet);

        return ResponseEntity.noContent().build();
    }
}
