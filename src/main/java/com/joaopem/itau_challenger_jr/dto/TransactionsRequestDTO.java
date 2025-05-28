package com.joaopem.itau_challenger_jr.dto;

import java.time.OffsetDateTime;

public record TransactionsRequestDTO(

        Double value,

        OffsetDateTime dateTime

) {
}
