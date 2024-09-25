package com.marcelsistemapedidos.infrastructure.adapters.out.messaging;

import com.marcelsistemapedidos.application.ports.out.MensagemProducerPort;
import com.marcelsistemapedidos.domain.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService implements MensagemProducerPort {

    private static final String TOPICO_PEDIDOS = "topico-pedidos";

    private final KafkaTemplate<String, Pedido> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Pedido> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void enviarPedido(Pedido pedido) {
        kafkaTemplate.send(TOPICO_PEDIDOS, pedido.getId(), pedido);
    }
}
