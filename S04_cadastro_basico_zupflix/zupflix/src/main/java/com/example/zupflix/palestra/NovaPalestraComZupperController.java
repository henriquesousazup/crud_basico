package com.example.zupflix.palestra;

import com.example.zupflix.zupper.ZupperRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/palestras")
public class NovaPalestraComZupperController {

    private final PalestraRepository palestraRepository;
    private final ZupperRepository zupperRepository;

    public NovaPalestraComZupperController(PalestraRepository palestraRepository, ZupperRepository zupperRepository) {
        this.palestraRepository = palestraRepository;
        this.zupperRepository = zupperRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid PalestraComZupperRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Palestra novaPalestra = request.toModel(zupperRepository);
        palestraRepository.save(novaPalestra);

        URI location = uriComponentsBuilder.path("/palestras/{id}").buildAndExpand(novaPalestra.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
