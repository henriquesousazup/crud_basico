package com.example.games.game;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.stream.Collectors;

public class PessoaComJogoRequest {

    @NotBlank
    private String nome;

    private Set<Long> jogos;

    public PessoaComJogoRequest(String nome, Set<Long> jogos) {
        this.nome = nome;
        this.jogos = jogos;
    }

    public PessoaComJogoRequest() {
    }

    public Pessoa paraPessoa(JogoRepository jogoRepository) {
        Set<Jogo> games = jogos.stream().map(id -> jogoRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não cadastrado")))
                .collect(Collectors.toSet());

        Pessoa pessoa = new Pessoa(nome);
        pessoa.adicionar(games);

        return pessoa;
    }

    public String getNome() {
        return nome;
    }

    public Set<Long> getJogos() {
        return jogos;
    }
}
