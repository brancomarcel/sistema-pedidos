package com.marcelsistemapedidos.infrastructure.adapters.out.database;

import com.marcelsistemapedidos.domain.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataMongoPedidoRepository extends MongoRepository<Pedido, String> {
}
