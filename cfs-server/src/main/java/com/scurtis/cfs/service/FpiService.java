package com.scurtis.cfs.service;

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
public class FpiService {

    private final WebClient webClient;

    public Flux<Fpi> getFpiByYear(int year) {
        log.debug("FpiService.getFpiByYear() -> year = {}", year);
        return webClient.get()
            .uri("ratings/fpi?year=" + year)
            .retrieve()
            .bodyToFlux(Fpi.class);
    }

    public Flux<Sp> getSpByYear(int year) {
        log.debug("FpiService.getSpByYear() -> year = {}", year);
        return webClient.get()
            .uri("ratings/sp?year=" + year)
            .retrieve()
            .bodyToFlux(Sp.class);
    }



}
