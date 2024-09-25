package com.marcelsistemapedidos.application.ports.in;

import com.marcelsistemapedidos.domain.model.Pedido;

public interface CriarPedidoUseCase {
    Pedido criarPedido(Pedido pedido);
}
