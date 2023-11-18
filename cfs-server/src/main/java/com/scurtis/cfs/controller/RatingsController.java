package com.scurtis.cfs.controller;

import com.scurtis.cfs.dto.FpiDto;
import com.scurtis.cfs.dto.SpDto;
import com.scurtis.cfs.service.RatingService;
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
@RequestMapping(value = "ratings")
public class RatingsController {

    private final RatingService ratingService;

    @GetMapping(path = "fpi/year/{year}")
    public Flux<FpiDto> getFpiByYear(@PathVariable int year) {
        return ratingService.getFpiByYear(year);
    }

    @GetMapping(path = "sp/year/{year}")
    public Flux<SpDto> getSpByYear(@PathVariable int year) {
        return ratingService.getSpByYear(year);
    }

}
