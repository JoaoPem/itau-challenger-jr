package com.joaopem.itau_challenger_jr.dto;

public record StatisticsResponseDTO(

        long count,

        double sum,

        double avg,

        double min,

        double max

) {
}