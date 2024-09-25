package com.marcelsistemapedidos.application.ports.out;

import com.marcelsistemapedidos.domain.model.Pedido;

import java.util.Optional;

public interface PedidoRepositoryPort {
    Pedido salvar(Pedido pedido);
    Optional<Pedido> buscarPorId(String id);
}
