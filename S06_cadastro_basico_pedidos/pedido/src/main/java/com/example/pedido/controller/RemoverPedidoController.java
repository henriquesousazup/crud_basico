package com.example.pedido.controller;

import com.example.pedido.model.Pedido;
import com.example.pedido.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/pedidos/{idPedido}")
public class RemoverPedidoController {

    private final PedidoRepository repository;

    public RemoverPedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long idPedido) {

        Pedido pedido = repository.findById(idPedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }
}
