package com.marcelsistemapedidos.application.service;

import com.marcelsistemapedidos.application.ports.in.ConsultarPedidoUseCase;
import com.marcelsistemapedidos.application.ports.in.CriarPedidoUseCase;
import com.marcelsistemapedidos.application.ports.out.MensagemProducerPort;
import com.marcelsistemapedidos.application.ports.out.PedidoRepositoryPort;
import com.marcelsistemapedidos.domain.enums.StatusPedido;
import com.marcelsistemapedidos.domain.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PedidoService implements CriarPedidoUseCase, ConsultarPedidoUseCase {

    private final PedidoRepositoryPort pedidoRepository;
    private final MensagemProducerPort mensagemProducer;

    public PedidoService(PedidoRepositoryPort pedidoRepository, MensagemProducerPort mensagemProducer) {
        this.pedidoRepository = pedidoRepository;
        this.mensagemProducer = mensagemProducer;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        pedido.setStatus(StatusPedido.AGUARDANDO_ENVIO);
        Pedido pedidoSalvo = pedidoRepository.salvar(pedido);
        mensagemProducer.enviarPedido(pedidoSalvo);
        return pedidoSalvo;
    }

    @Override
    public Optional<Pedido> consultarPedido(String id) {
        return pedidoRepository.buscarPorId(id);
    }
}
