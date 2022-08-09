package com.example.artigos.controller;

import com.example.artigos.model.Blog;
import com.example.artigos.repository.BlogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/blogs")
public class NovoBlogController {

    private final BlogRepository blogRepository;

    public NovoBlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid BlogRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Blog novoBlog = request.toModel();
        blogRepository.save(novoBlog);

        URI location = uriComponentsBuilder.path("/blogs/{id}").buildAndExpand(novoBlog.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
