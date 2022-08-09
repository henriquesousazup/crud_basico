package com.example.games.game;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pessoas")
public class CadastrarPessoaEJogoController {

    private final PessoaRepository pessoaRepository;
    private final JogoRepository jogoRepository;

    public CadastrarPessoaEJogoController(PessoaRepository pessoaRepository, JogoRepository jogoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.jogoRepository = jogoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid PessoaComJogoRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Pessoa pessoa = request.paraPessoa(jogoRepository);
        pessoaRepository.save(pessoa);

        URI location = uriComponentsBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
