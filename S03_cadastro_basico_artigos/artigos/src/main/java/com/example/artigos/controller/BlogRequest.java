package com.example.artigos.controller;

import com.example.artigos.model.Blog;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class BlogRequest {

    @NotBlank
    private String nome;

    private List<ArtigoRequest> artigos = new ArrayList<>();

    public BlogRequest() {
    }

    public BlogRequest(String nome) {
        this.nome = nome;
    }

    public Blog toModel() {
        Blog blog = new Blog(nome);
        artigos.forEach(a -> blog.adiciona(a.toModel(blog)));
        return blog;
    }

    public String getNome() {
        return nome;
    }
}
