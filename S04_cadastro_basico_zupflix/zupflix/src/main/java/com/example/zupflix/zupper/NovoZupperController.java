package com.example.zupflix.zupper;

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

    private final ZupperRepository zupperRepository;

    public NovoZupperController(ZupperRepository zupperRepository) {
        this.zupperRepository = zupperRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ZupperRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Zupper novoZupper = request.toModel();
        zupperRepository.save(novoZupper);

        URI location = uriComponentsBuilder.path("/zuppers/{id}").buildAndExpand(novoZupper.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
