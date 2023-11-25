package com.scurtis.cfs.converter;

import com.scurtis.cfs.dto.BetLineDto;
import com.scurtis.cfs.model.BetLine;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BetLineConverter {

    public BetLineDto toDto(BetLine betLine) {
        BetLineDto dto = new BetLineDto();
        dto.setId(betLine.getId());
        dto.setSeason(betLine.getSeason());
        dto.setSeasonType(betLine.getSeasonType());
        dto.setWeek(betLine.getWeek());
        dto.setStartDate(betLine.getStartDate());
        dto.setHomeTeam(betLine.getHomeTeam());
        dto.setHomeConference(betLine.getHomeConference());
        dto.setHomeScore(betLine.getHomeScore());
        dto.setAwayTeam(betLine.getAwayTeam());
        dto.setAwayConference(betLine.getAwayConference());
        dto.setAwayScore(betLine.getAwayScore());
        setProviders(dto, betLine.getLines());
        return dto;
    }

    private void setProviders(BetLineDto dto, List<BetLine.Line> lines) {
        for (BetLine.Line line : lines) {
            if (line.getProvider().equalsIgnoreCase("ESPN Bet")) {
                dto.setEspnSpread(line.getSpread());
                dto.setEspnFormattedSpread(line.getFormattedSpread());
                dto.setEspnSpreadOpen(line.getSpreadOpen());
                dto.setEspnOverUnder(line.getOverUnder());
                dto.setEspnOverUnderOpen(line.getOverUnderOpen());
                dto.setEspnHomeMoneyLine(line.getHomeMoneyline());
                dto.setEspnAwayMoneyLine(line.getAwayMoneyline());
            } else if (line.getProvider().equalsIgnoreCase("DraftKings")) {
                dto.setDraftKingsSpread(line.getSpread());
                dto.setDraftKingsFormattedSpread(line.getFormattedSpread());
                dto.setDraftKingsSpreadOpen(line.getSpreadOpen());
                dto.setDraftKingsOverUnder(line.getOverUnder());
                dto.setDraftKingsOverUnderOpen(line.getOverUnderOpen());
                dto.setDraftKingsHomeMoneyLine(line.getHomeMoneyline());
                dto.setDraftKingsAwayMoneyLine(line.getAwayMoneyline());
            } else if (line.getProvider().equalsIgnoreCase("Bovada")) {
                dto.setBovadaSpread(line.getSpread());
                dto.setBovadaFormattedSpread(line.getFormattedSpread());
                dto.setBovadaSpreadOpen(line.getSpreadOpen());
                dto.setBovadaOverUnder(line.getOverUnder());
                dto.setBovadaOverUnderOpen(line.getOverUnderOpen());
                dto.setBovadaHomeMoneyLine(line.getHomeMoneyline());
                dto.setBovadaAwayMoneyLine(line.getAwayMoneyline());
            } else {
                log.error("Unknown betting line provider: {}", line.getProvider());
            }
        }
    }

}
