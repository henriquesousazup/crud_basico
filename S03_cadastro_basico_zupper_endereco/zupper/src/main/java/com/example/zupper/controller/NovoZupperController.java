package com.example.zupper.controller;

import com.example.zupper.model.Zupper;
import com.example.zupper.repository.ZupperRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/zuppers")
public class NovoZupperController {

    private final ZupperRepository repository;

    public NovoZupperController(ZupperRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ZupperRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Zupper novoZupper = request.toModel();
        repository.save(novoZupper);

        URI location = uriComponentsBuilder.path("/zuppers/{id}").buildAndExpand(novoZupper.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
