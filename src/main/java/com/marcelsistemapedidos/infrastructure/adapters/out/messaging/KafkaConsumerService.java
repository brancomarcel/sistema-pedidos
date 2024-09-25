package com.marcelsistemapedidos.infrastructure.adapters.out.messaging;

import com.marcelsistemapedidos.application.ports.out.PedidoRepositoryPort;
import com.marcelsistemapedidos.domain.enums.StatusPedido;
import com.marcelsistemapedidos.domain.exception.PedidoNaoEncontradoException;
import com.marcelsistemapedidos.domain.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaConsumerService {

    private final PedidoRepositoryPort pedidoRepository;

    @Autowired
    public KafkaConsumerService(PedidoRepositoryPort pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @KafkaListener(topics = "topico-pedidos", groupId = "grupo-pedidos", containerFactory = "kafkaListenerContainerFactory")
    public void consumirPedido(Pedido pedido) {
        final var pedidoAtualizado = pedidoRepository.buscarPorId(pedido.getId())
                .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado: " + pedido.getId()));

        pedidoAtualizado.setStatus(StatusPedido.ENVIADO_TRANSPORTADORA);
        pedidoRepository.salvar(pedidoAtualizado);
    }
}
