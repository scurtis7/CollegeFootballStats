package com.scurtis.cfs.controller;

import com.scurtis.cfs.dto.BetLineDto;
import com.scurtis.cfs.service.BetLineService;
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
@RequestMapping(value = "lines")
public class BetLineController {

    private final BetLineService betLineService;

    @GetMapping(path = "year/{year}/week/{week}")
    public Flux<BetLineDto> getBettingLinesByYearAndWeek(@PathVariable int year, @PathVariable int week) {
        return betLineService.getBettingLinesByYearAndWeek(year, week);
    }

}
