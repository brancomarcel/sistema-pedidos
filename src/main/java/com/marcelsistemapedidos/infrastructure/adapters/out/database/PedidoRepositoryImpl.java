package com.marcelsistemapedidos.infrastructure.adapters.out.database;

import com.marcelsistemapedidos.application.ports.out.PedidoRepositoryPort;
import com.marcelsistemapedidos.domain.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PedidoRepositoryImpl implements PedidoRepositoryPort {

    private final SpringDataMongoPedidoRepository repository;

    @Autowired
    public PedidoRepositoryImpl(SpringDataMongoPedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        return repository.save(pedido);
    }

    @Override
    public Optional<Pedido> buscarPorId(String id) {
        return repository.findById(id);
    }

}
