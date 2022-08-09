package com.example.pessoa.pessoa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/pessoas")
public class DetalharPessoaController {

    private final PessoaRepository repository;

    public DetalharPessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<PessoaResponse> detalhar(@PathVariable Long id) {

        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada."));

        return ResponseEntity.ok(new PessoaResponse(pessoa));
    }

}
