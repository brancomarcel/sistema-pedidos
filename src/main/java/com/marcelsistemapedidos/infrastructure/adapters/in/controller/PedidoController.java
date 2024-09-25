package com.marcelsistemapedidos.infrastructure.adapters.in.controller;

import com.marcelsistemapedidos.application.ports.in.ConsultarPedidoUseCase;
import com.marcelsistemapedidos.application.ports.in.CriarPedidoUseCase;
import com.marcelsistemapedidos.domain.model.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final CriarPedidoUseCase criarPedidoUseCase;
    private final ConsultarPedidoUseCase consultarPedidoUseCase;

    public PedidoController(CriarPedidoUseCase criarPedidoUseCase, ConsultarPedidoUseCase consultarPedidoUseCase) {
        this.criarPedidoUseCase = criarPedidoUseCase;
        this.consultarPedidoUseCase = consultarPedidoUseCase;
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = criarPedidoUseCase.criarPedido(pedido);
        return ResponseEntity.ok(novoPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> consultarPedido(@PathVariable String id) {
        Optional<Pedido> pedido = consultarPedidoUseCase.consultarPedido(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
