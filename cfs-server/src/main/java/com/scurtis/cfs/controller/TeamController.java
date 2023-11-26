package com.scurtis.cfs.controller;

import com.scurtis.cfs.dto.BetLineDto;
import com.scurtis.cfs.dto.RosterDto;
import com.scurtis.cfs.dto.TeamDto;
import com.scurtis.cfs.dto.TeamNameDto;
import com.scurtis.cfs.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping(path = "teams")
    public Flux<TeamDto> getAllTeams() {
        log.debug("getAllTeams()");
        return teamService.getAllTeams();
    }

    @GetMapping(path = "roster/year/{year}/team/{team}")
    public Flux<RosterDto> getRosterByYearAndTeam(@PathVariable int year, @PathVariable String team) {
        log.debug("getRosterByYearAndTeam()");
        return teamService.getRosterByYearAndTeam(year, team);
    }

    @GetMapping(path = "teams/names")
    public Flux<TeamNameDto> getTeamNames() {
        log.debug("getTeamNames()");
        return teamService.getTeamNames();
    }

}
