package com.joaopem.itau_challenger_jr.controller;

import com.joaopem.itau_challenger_jr.dto.TransactionsRequestDTO;
import com.joaopem.itau_challenger_jr.service.TransactionsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionsController {

    private final TransactionsService transactionsService;

    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody @Valid TransactionsRequestDTO transactionRequestDTO){
        transactionsService.addTransaction(transactionRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransactions(){
        transactionsService.clearTransactions();
        return ResponseEntity.ok().build();
    }

}
