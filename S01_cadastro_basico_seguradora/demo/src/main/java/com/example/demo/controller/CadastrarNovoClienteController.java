package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class CadastrarNovoClienteController {

    private final ClienteRepository repository;

    public CadastrarNovoClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ClienteRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Cliente novoCliente = request.paraCliente();
        repository.save(novoCliente);

        URI location = uriComponentsBuilder.path("/clientes/{id}")
                .buildAndExpand(novoCliente.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
