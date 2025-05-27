package com.joaopem.itau_challenger_jr.mapper;

import com.joaopem.itau_challenger_jr.dto.TransactionsRequestDTO;
import com.joaopem.itau_challenger_jr.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionsMapper {

    Transaction toEntity(TransactionsRequestDTO transactionsRequestDTO);
}