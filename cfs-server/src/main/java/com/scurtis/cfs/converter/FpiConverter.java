package com.scurtis.cfs.converter;

import com.scurtis.cfs.dto.FpiDto;
import com.scurtis.cfs.model.Fpi;
import org.springframework.stereotype.Service;

@Service
public class FpiConverter {

    public FpiDto toDto(Fpi fpi) {
        FpiDto dto = new FpiDto();
        dto.setYear(fpi.getYear());
        dto.setTeam(fpi.getTeam());
        dto.setConference(fpi.getConference());
        dto.setFpi(fpi.getFpi());
        dto.setStrengthOfRecord(fpi.getResumeRanks().getStrengthOfRecord());
        dto.setResumeFpi(fpi.getResumeRanks().getFpi());
        dto.setAverageWinProbability(fpi.getResumeRanks().getAverageWinProbability());
        dto.setStrengthOfSchedule(fpi.getResumeRanks().getStrengthOfSchedule());
        dto.setRemainingStrengthOfSchedule(fpi.getResumeRanks().getRemainingStrengthOfSchedule());
        dto.setGameControl(fpi.getResumeRanks().getGameControl());
        dto.setOverallEfficiency(fpi.getEfficiencies().getOverall());
        dto.setOffenseEfficiency(fpi.getEfficiencies().getOffense());
        dto.setDefenseEfficiency(fpi.getEfficiencies().getDefense());
        dto.setSpecialTeamsEfficiency(fpi.getEfficiencies().getSpecialTeams());
        return dto;
    }

}
