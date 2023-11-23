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

    /**
     * According to an ESPN article here: https://www.espn.com/blog/statsinfo/post/_/id/122612/an-inside-look-at-college-fpi
     * FPI is a predictive rating system designed to measure team strength and project performance going forward.
     * The ultimate goal of FPI is not to rank teams 1 through 128; rather, it is to correctly predict games and season outcomes.
     * If Vegas ever published the power rankings it uses to set its lines, they would likely look quite a lot like FPI.
     * FPI is not a prediction but a probability.
     *
     * @param year required football season year
     * @return FPI Rankings for the given year
     */
    public Flux<FpiDto> getFpiByYear(int year) {
        log.debug("RatingService.getFpiByYear() -> year = {}", year);
        return webClient.get()
            .uri("ratings/fpi?year=" + year)
            .retrieve()
            .bodyToFlux(Fpi.class)
            .map(fpiConverter::toDto)
            .sort();
    }

    /**
     * According to an ESPN article here: https://www.espn.com/college-football/insider/story/_/id/38823946/college-football-2023-week-10-sp+-rankings-takeaways
     * What is SP+? In a single sentence, it's a tempo- and opponent-adjusted measure of college football efficiency. I created the system at Football Outsiders
     * in 2008, and as my experience with both college football and its stats has grown, I have made quite a few tweaks to the system.
     * Bill Connelly, ESPN Staff Writer
     * @param year required football season year
     * @return SP+ Rankings for the given year
     */
    public Flux<SpDto> getSpByYear(int year) {
        log.debug("RatingService.getSpByYear() -> year = {}", year);
        return webClient.get()
            .uri("ratings/sp?year=" + year)
            .retrieve()
            .bodyToFlux(Sp.class)
            .map(spConverter::toDto)
            .sort();
    }

}
