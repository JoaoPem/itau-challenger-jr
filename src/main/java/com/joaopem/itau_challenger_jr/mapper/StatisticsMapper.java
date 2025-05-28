package com.joaopem.itau_challenger_jr.mapper;

import com.joaopem.itau_challenger_jr.dto.StatisticsResponseDTO;
import org.mapstruct.Mapper;

import java.util.DoubleSummaryStatistics;

@Mapper(componentModel = "spring")
public interface StatisticsMapper {

    StatisticsResponseDTO toDTO(DoubleSummaryStatistics doubleSummaryStatistics);
}
