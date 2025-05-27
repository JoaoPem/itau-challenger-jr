package com.joaopem.itau_challenger_jr.controller.commom;

import com.joaopem.itau_challenger_jr.exceptions.ValidateTransactionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidateTransactionException.class)
    public ResponseEntity<Void> handleValidateTransactionException(){
        return ResponseEntity.unprocessableEntity().build();
    }
}
