package com.joaopem.itau_challenger_jr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

//@Data
@Getter
@Setter
@AllArgsConstructor
public class Transaction {

    private double value;

    private OffsetDateTime dateTime;

}
