package com.scurtis.cfs.service;

import com.scurtis.cfs.converter.FpiConverter;
import com.scurtis.cfs.converter.SpConverter;
import com.scurtis.cfs.dto.FpiDto;
import com.scurtis.cfs.dto.SpDto;
import com.scurtis.cfs.model.Fpi;
import com.scurtis.cfs.model.Sp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class RatingService {

    private final WebClient webClient;
    private final FpiConverter fpiConverter;
    private final SpConverter spConverter;

    public Flux<FpiDto> getFpiByYear(int year) {
        log.debug("RatingService.getFpiByYear() -> year = {}", year);
        return webClient.get()
            .uri("ratings/fpi?year=" + year)
            .retrieve()
            .bodyToFlux(Fpi.class)
            .map(fpiConverter::toDto);
    }

    public Flux<SpDto> getSpByYear(int year) {
        log.debug("RatingService.getSpByYear() -> year = {}", year);
        return webClient.get()
            .uri("ratings/sp?year=" + year)
            .retrieve()
            .bodyToFlux(Sp.class)
            .map(spConverter::toDto);
    }

}
