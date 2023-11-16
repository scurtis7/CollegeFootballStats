package com.scurtis.cfs.service;

import com.scurtis.cfs.model.Team;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamService {

    private final WebClient webClient;

    public Flux<Team> getAllTeams() {
        log.debug("TeamService.getAllTeams()");
        return webClient.get()
            .uri("teams")
            .retrieve()
            .bodyToFlux(Team.class);
    }

}
