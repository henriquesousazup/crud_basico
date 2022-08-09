package com.example.pedido.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemDePedido {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Produto produto;

    private Integer quantidade;

    @ManyToOne(optional = false)
    private Pedido pedido;

}
