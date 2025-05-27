package com.joaopem.itau_challenger_jr.validator;

import com.joaopem.itau_challenger_jr.dto.TransactionRequestDTO;
import com.joaopem.itau_challenger_jr.exceptions.ValidateTransactionException;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class TransactionsValidator {

    public void validateTransaction(TransactionRequestDTO transactionRequestDTO){
        validatePositiveValue(transactionRequestDTO);
        validateDateNotInFuture(transactionRequestDTO);
    }

    private void validateRequiredFields(TransactionRequestDTO transactionRequestDTO){

    }

    private void validatePositiveValue(TransactionRequestDTO transactionRequestDTO){
        if (transactionRequestDTO.value() < 0){
            throw new ValidateTransactionException("Value must be greater than or equal to 0");
        }
    }

    private void validateDateNotInFuture(TransactionRequestDTO transactionRequestDTO){
        if (transactionRequestDTO.dateTime().isAfter(OffsetDateTime.now())){
            throw new ValidateTransactionException("Transaction date cannot be in the future");
        }
    }
}
