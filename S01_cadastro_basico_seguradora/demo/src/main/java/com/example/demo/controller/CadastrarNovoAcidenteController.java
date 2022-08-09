package com.example.demo.controller;

import com.example.demo.model.Acidente;
import com.example.demo.model.Carro;
import com.example.demo.repository.AcidenteRepository;
import com.example.demo.repository.CarroRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("carros/{idCarro}/acidentes")
public class CadastrarNovoAcidenteController {

    private final CarroRepository carroRepository;
    private final AcidenteRepository acidenteRepository;

    public CadastrarNovoAcidenteController(CarroRepository carroRepository, AcidenteRepository acidenteRepository) {
        this.carroRepository = carroRepository;
        this.acidenteRepository = acidenteRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@PathVariable Long idCarro, @RequestBody @Valid AcidenteRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Carro carro = carroRepository.findById(idCarro)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não cadastrado no sistema"));

        Acidente novoAcidente = request.paraAcidente(carro);
        acidenteRepository.save(novoAcidente);

        URI location = uriComponentsBuilder.path("carros/{idCarro}/acidentes/{id}")
                .buildAndExpand(carro.getId(), novoAcidente.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
