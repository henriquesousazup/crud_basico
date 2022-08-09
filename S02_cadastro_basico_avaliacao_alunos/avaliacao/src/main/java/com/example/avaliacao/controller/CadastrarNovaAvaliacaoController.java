package com.example.avaliacao.controller;

import com.example.avaliacao.model.Aluno;
import com.example.avaliacao.model.Avaliacao;
import com.example.avaliacao.repository.AlunoRepository;
import com.example.avaliacao.repository.AvaliacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/alunos/{idAluno}/avaliacoes")
public class CadastrarNovaAvaliacaoController {

    private final AlunoRepository alunoRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    public CadastrarNovaAvaliacaoController(AlunoRepository alunoRepository, AvaliacaoRepository avaliacaoRepository) {
        this.alunoRepository = alunoRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@PathVariable Long idAluno, @RequestBody @Valid AvaliacaoRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não cadastrado no sistema."));

        Avaliacao novaAvaliacao = request.paraAvaliacao(aluno);
        avaliacaoRepository.save(novaAvaliacao);

        URI location = uriComponentsBuilder.path("/alunos/{idAluno}/avaliacoes/{id}").buildAndExpand(aluno.getId(), novaAvaliacao.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
