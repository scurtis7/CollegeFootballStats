package com.scurtis.cfs.controller;

import com.scurtis.cfs.model.Team;
import com.scurtis.cfs.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "teams")
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public Flux<Team> getAllTeams() {
        log.debug("getAllTeams()");
        return teamService.getAllTeams();
    }

}
