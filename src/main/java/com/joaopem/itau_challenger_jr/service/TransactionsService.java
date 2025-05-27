package com.joaopem.itau_challenger_jr.service;

import com.joaopem.itau_challenger_jr.dto.TransactionsRequestDTO;
import com.joaopem.itau_challenger_jr.mapper.TransactionsMapper;
import com.joaopem.itau_challenger_jr.model.Transaction;
import com.joaopem.itau_challenger_jr.validator.TransactionsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@RequiredArgsConstructor
public class TransactionsService {

    private final TransactionsMapper transactionsMapper;
    private final TransactionsValidator transactionsValidator;
    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction(TransactionsRequestDTO transactionsRequestDTO){
        transactionsValidator.validateTransaction(transactionsRequestDTO);
        Transaction transaction = transactionsMapper.toEntity(transactionsRequestDTO);
        transactions.add(transaction);
    }

    public void clearTransactions(){
        transactions.clear();
    }

}
