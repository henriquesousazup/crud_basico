package com.example.livraria.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @Length(min = 200, max = 4000)
    private String titulo;

    @NotBlank
    @Length(min = 200, max = 4000)
    private String descricao;

    @NotNull
    @Past
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @NotBlank
    @ISBN
    private String isbn;

    public LivroRequest() {
    }

    public Livro paraLivro() {
        return new Livro(titulo, descricao, dataPublicacao, isbn);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
