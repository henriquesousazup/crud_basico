package com.example.pedido.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;

}
