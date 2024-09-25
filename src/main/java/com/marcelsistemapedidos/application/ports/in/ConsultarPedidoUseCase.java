package com.marcelsistemapedidos.application.ports.in;

import com.marcelsistemapedidos.domain.model.Pedido;

import java.util.Optional;

public interface ConsultarPedidoUseCase {
        Optional<Pedido> consultarPedido(String id);

}
