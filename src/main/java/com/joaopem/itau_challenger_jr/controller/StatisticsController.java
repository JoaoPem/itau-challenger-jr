package com.joaopem.itau_challenger_jr.controller;

import com.joaopem.itau_challenger_jr.dto.StatisticsResponseDTO;
import com.joaopem.itau_challenger_jr.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping
    public ResponseEntity<StatisticsResponseDTO> getStatistics(){
        StatisticsResponseDTO statisticsResponseDTO = statisticsService.getStatistics();
        return ResponseEntity.ok(statisticsResponseDTO);
    }

}
