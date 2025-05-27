package com.joaopem.itau_challenger_jr.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionRequestDTO(

        @NotNull(message = "Value must not be null.")
        //@DecimalMin(value = "0.0", inclusive = true, message = "Value must be greater than or equal to 0.")
        Double value,

        @NotNull(message = "Date and time must not be null.")
        //@PastOrPresent(message = "Transaction date and time must not be in the future.")
        OffsetDateTime dateTime

) {
}
