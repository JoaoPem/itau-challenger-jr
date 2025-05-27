package com.joaopem.itau_challenger_jr.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Transaction {
    private double value;

    private OffsetDateTime dateTime;
}
