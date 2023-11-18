package com.scurtis.cfs.converter;

import com.scurtis.cfs.dto.SpDto;
import com.scurtis.cfs.model.Sp;
import org.springframework.stereotype.Service;

@Service
public class SpConverter {

    public SpDto toDto(Sp sp) {
        SpDto dto = new SpDto();
        dto.setYear(sp.getYear());
        dto.setTeam(sp.getTeam());
        dto.setConference(sp.getConference());
        dto.setRating(sp.getRating());
        dto.setRanking(sp.getRanking());
        dto.setSecondOrderWins(sp.getSecondOrderWins());
        dto.setSos(sp.getSos());
        dto.setOffenseRanking(sp.getOffense().getRanking());
        dto.setOffenseRating(sp.getOffense().getRating());
        dto.setOffenseSuccess(sp.getOffense().getSuccess());
        dto.setOffenseExplosiveness(sp.getOffense().getExplosiveness());
        dto.setOffensePassing(sp.getOffense().getPassing());
        dto.setOffenseStandardDowns(sp.getOffense().getStandardDowns());
        dto.setOffensePassingDowns(sp.getOffense().getPassingDowns());
        dto.setOffensePace(sp.getOffense().getPace());
        dto.setDefenseRanking(sp.getDefense().getRanking());
        dto.setDefenseRating(sp.getDefense().getRating());
        dto.setDefenseSuccess(sp.getDefense().getSuccess());
        dto.setDefenseRushing(sp.getDefense().getRushing());
        dto.setDefensePassing(sp.getDefense().getPassing());
        dto.setDefenseStandardDowns(sp.getDefense().getStandardDowns());
        dto.setDefensePassingDowns(sp.getDefense().getPassingDowns());
        dto.setHavocTotal(sp.getDefense().getHavoc().getTotal());
        dto.setHavocFrontSeven(sp.getDefense().getHavoc().getFrontSeven());
        dto.setHavocDb(sp.getDefense().getHavoc().getDb());
        return dto;
    }
}
