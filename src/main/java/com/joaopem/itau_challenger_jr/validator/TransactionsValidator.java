package com.joaopem.itau_challenger_jr.validator;

import com.joaopem.itau_challenger_jr.dto.TransactionsRequestDTO;
import com.joaopem.itau_challenger_jr.exceptions.ValidateTransactionException;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class TransactionsValidator {

    public void validateTransaction(TransactionsRequestDTO transactionsRequestDTO){
        validateNull(transactionsRequestDTO);
        validatePositiveValue(transactionsRequestDTO);
        validateDateNotInFuture(transactionsRequestDTO);
    }

    private void validateNull(TransactionsRequestDTO transactionsRequestDTO){
        if (transactionsRequestDTO.value() == null || transactionsRequestDTO.dateTime() == null){
            throw new ValidateTransactionException("Value cannot be null");
        }
    }

    private void validatePositiveValue(TransactionsRequestDTO transactionsRequestDTO){
        if (transactionsRequestDTO.value() < 0){
            throw new ValidateTransactionException("Value must be greater than or equal to 0");
        }
    }

    private void validateDateNotInFuture(TransactionsRequestDTO transactionsRequestDTO){
        if (transactionsRequestDTO.dateTime().isAfter(OffsetDateTime.now())){
            throw new ValidateTransactionException("Transaction date cannot be in the future");
        }
    }
}
