package com.example.zupper.controller;

import com.example.zupper.model.Endereco;
import com.example.zupper.model.Zupper;
import com.example.zupper.repository.EnderecoRepository;
import com.example.zupper.repository.ZupperRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/zuppers/{idZupper}/enderecos")
public class NovoEnderecoController {

    private final EnderecoRepository enderecoRepository;
    private final ZupperRepository zupperRepository;

    public NovoEnderecoController(EnderecoRepository enderecoRepository, ZupperRepository zupperRepository) {
        this.enderecoRepository = enderecoRepository;
        this.zupperRepository = zupperRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@PathVariable Long idZupper, @RequestBody @Valid EnderecoRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Zupper zupper = zupperRepository.findById(idZupper).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zupper não encontrado."));

        Endereco novosEndereco = request.toModel(zupper);
        enderecoRepository.save(novosEndereco);

        URI location = uriComponentsBuilder.path("zuppers/{idZupper}/enderecos/{id}").buildAndExpand(zupper.getId(),novosEndereco.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
