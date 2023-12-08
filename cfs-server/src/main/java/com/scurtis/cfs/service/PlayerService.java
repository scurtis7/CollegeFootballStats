package com.scurtis.cfs.service;

import com.scurtis.cfs.converter.PortalPlayerConverter;
import com.scurtis.cfs.dto.PortalPlayerDto;
import com.scurtis.cfs.model.PortalPlayer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerService {

    private final WebClient webClient;
    private final PortalPlayerConverter portalPlayerConverter;

    public Flux<PortalPlayerDto> getPlayersInPortalByYear(int year) {
        log.debug("PlayerService.getPlayersInPortalByYear() -> year: {}", year);
        return webClient.get()
            .uri("player/portal?year=" + year)
            .retrieve()
            .bodyToFlux(PortalPlayer.class)
            .map(portalPlayerConverter::toDto);
    }


}
