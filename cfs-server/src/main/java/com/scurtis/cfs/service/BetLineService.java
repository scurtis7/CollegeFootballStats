package com.scurtis.cfs.service;

import com.scurtis.cfs.converter.BetLineConverter;
import com.scurtis.cfs.dto.BetLineDto;
import com.scurtis.cfs.model.BetLine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class BetLineService {

    private final WebClient webClient;
    private final BetLineConverter betLineConverter;

    public Flux<BetLineDto> getBettingLinesByYearAndWeek(int year, int week) {
        log.debug("BetLineService.getBettingLinesByYearAndWeek() -> year:{}  week:{}", year, week);
        return webClient.get()
            .uri("lines?year=" + year + "&week=" + week)
            .retrieve()
            .bodyToFlux(BetLine.class)
            .map(betLineConverter::toDto);
    }

}
