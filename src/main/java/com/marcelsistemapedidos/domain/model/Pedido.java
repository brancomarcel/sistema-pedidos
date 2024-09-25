package com.marcelsistemapedidos.domain.model;

import com.marcelsistemapedidos.domain.enums.StatusPedido;

public class Pedido {

    private String id;
    private String descricao;
    private StatusPedido status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
