package com.marcelsistemapedidos.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PedidoNaoEncontradoExceptionHandler {
    @ExceptionHandler
    public ResponseEntity pedidoNaoEncontradoHandle(PedidoNaoEncontradoException pedidoNaoEncontradoException){
        var details = new ExceptionDetails(HttpStatus.BAD_REQUEST.value(), pedidoNaoEncontradoException.getMessage());

        return new ResponseEntity(details, HttpStatus.BAD_REQUEST);
    }
}
