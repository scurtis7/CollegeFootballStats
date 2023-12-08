package com.scurtis.cfs.controller;

import com.scurtis.cfs.dto.PortalPlayerDto;
import com.scurtis.cfs.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping(path = "player/portal/year/{year}")
    public Flux<PortalPlayerDto> getPlayersInPortalByYear(@PathVariable int year) {
        log.debug("PlayerController.getPlayersInPortalByYear()");
        return playerService.getPlayersInPortalByYear(year);
    }


}
