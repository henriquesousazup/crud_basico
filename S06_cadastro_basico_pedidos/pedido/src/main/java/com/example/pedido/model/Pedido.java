package com.example.pedido.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private BigDecimal total;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "pedido")
    private List<ItemDePedido> itens;

}
