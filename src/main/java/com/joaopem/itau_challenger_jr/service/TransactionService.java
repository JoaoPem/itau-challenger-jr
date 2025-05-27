package com.joaopem.itau_challenger_jr.service;

import com.joaopem.itau_challenger_jr.dto.TransactionRequestDTO;
import com.joaopem.itau_challenger_jr.mapper.TransactionsMapper;
import com.joaopem.itau_challenger_jr.model.Transaction;
import com.joaopem.itau_challenger_jr.validator.TransactionsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionsMapper transactionsMapper;
    private final TransactionsValidator transactionsValidator;
    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction(TransactionRequestDTO transactionRequestDTO){
        transactionsValidator.validateTransaction(transactionRequestDTO);
        Transaction transaction = transactionsMapper.toEntity(transactionRequestDTO);
        transactions.add(transaction);
    }

    public void clearTransactions(){
        transactions.clear();
    }

    public DoubleSummaryStatistics getStatistics(){
        OffsetDateTime currentDateTime = OffsetDateTime.now();
        return transactions.stream().filter(
                transaction -> transaction.getDateTime().isAfter(currentDateTime.minusSeconds(60))
        ).mapToDouble(Transaction::getValue).summaryStatistics();
    }
}
