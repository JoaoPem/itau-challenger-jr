package com.joaopem.itau_challenger_jr.mapper;

import com.joaopem.itau_challenger_jr.dto.StatisticsResponseDTO;
import org.mapstruct.Mapper;

import java.util.DoubleSummaryStatistics;

@Mapper(componentModel = "spring")
public interface StatisticsMapper {

    default StatisticsResponseDTO toDTO(DoubleSummaryStatistics doubleSummaryStatistics) {
        return new StatisticsResponseDTO(
                doubleSummaryStatistics.getCount(),
                doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getAverage(),
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getMax()
        );
    }
}
