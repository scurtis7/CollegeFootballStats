package com.scurtis.cfs.controller;

import com.scurtis.cfs.model.Fpi;
import com.scurtis.cfs.model.Sp;
import com.scurtis.cfs.service.FpiService;
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

    private final FpiService fpiService;

    @GetMapping(path = "fpi/year/{year}")
    public Flux<Fpi> getFpiByYear(@PathVariable int year) {
        return fpiService.getFpiByYear(year);
    }

    @GetMapping(path = "sp/year/{year}")
    public Flux<Sp> getSpByYear(@PathVariable int year) {
        return fpiService.getSpByYear(year);
    }

}
