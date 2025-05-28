package com.joaopem.itau_challenger_jr.service;

import com.joaopem.itau_challenger_jr.dto.StatisticsResponseDTO;
import com.joaopem.itau_challenger_jr.mapper.StatisticsMapper;
import com.joaopem.itau_challenger_jr.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final TransactionsService transactionsService;
    private final StatisticsMapper statisticsMapper;

    public StatisticsResponseDTO getStatistics(){
        List<Transaction> recentTransactions = transactionsService.getRecentTransactions();

        DoubleSummaryStatistics doubleSummaryStatistics = recentTransactions
                .stream()
                .mapToDouble(Transaction::getValue)
                .summaryStatistics();

        return statisticsMapper.toDTO(doubleSummaryStatistics);
    }
}
