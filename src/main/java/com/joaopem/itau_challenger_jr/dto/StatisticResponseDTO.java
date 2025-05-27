package com.joaopem.itau_challenger_jr.dto;

public record StatisticResponseDTO(

        long count,

        double sum,

        double avg,

        double min,

        double max

) {
}
