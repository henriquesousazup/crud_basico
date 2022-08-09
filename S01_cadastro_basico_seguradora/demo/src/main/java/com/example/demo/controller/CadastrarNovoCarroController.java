package com.example.demo.controller;

import com.example.demo.model.Carro;
import com.example.demo.model.Cliente;
import com.example.demo.repository.CarroRepository;
import com.example.demo.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("clientes/{idCliente}/carros")
public class CadastrarNovoCarroController {

    private final ClienteRepository clienteRepository;
    private final CarroRepository carroRepository;

    public CadastrarNovoCarroController(ClienteRepository clienteRepository, CarroRepository carroRepository) {
        this.clienteRepository = clienteRepository;
        this.carroRepository = carroRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@PathVariable Long idCliente, @RequestBody @Valid CarroRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não cadasrto do cliente para o ID informado"));

        Carro novoCarro = request.paraCarro(cliente);
        carroRepository.save(novoCarro);

        URI location = uriComponentsBuilder.path("clientes/{idCliente}/carros/{id}")
                .buildAndExpand(cliente.getId(), novoCarro.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
