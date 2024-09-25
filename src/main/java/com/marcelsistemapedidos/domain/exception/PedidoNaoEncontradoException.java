package com.marcelsistemapedidos.domain.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
