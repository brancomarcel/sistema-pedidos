package com.marcelsistemapedidos.application.ports.out;

import com.marcelsistemapedidos.domain.model.Pedido;

public interface MensagemProducerPort {
    void enviarPedido(Pedido pedido);
}
