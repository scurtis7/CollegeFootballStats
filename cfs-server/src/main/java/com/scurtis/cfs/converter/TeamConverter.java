package com.scurtis.cfs.converter;

import com.scurtis.cfs.dto.TeamDto;
import com.scurtis.cfs.dto.TeamNameDto;
import com.scurtis.cfs.model.Team;
import org.springframework.stereotype.Service;

@Service
public class TeamConverter {

    public TeamDto toDto(Team team) {
        TeamDto dto = new TeamDto();
        dto.setId(team.getId());
        dto.setSchool(team.getSchool());
        dto.setMascot(team.getMascot());
        dto.setAbbreviation(team.getAbbreviation());
        dto.setAlt_name1(team.getAlt_name1());
        dto.setAlt_name2(team.getAlt_name2());
        dto.setAlt_name3(team.getAlt_name3());
        dto.setClassification(team.getClassification());
        dto.setConference(team.getConference());
        dto.setDivision(team.getDivision());
        dto.setColor(team.getColor());
        dto.setAlt_color(team.getAlt_color());
        dto.setLogos(team.getLogos());
        dto.setTwitter(team.getTwitter());
        dto.setLocId(team.getLocation().getVenue_id());
        dto.setStadiumName(team.getLocation().getName());
        dto.setCity(team.getLocation().getCity());
        dto.setState(team.getLocation().getState());
        dto.setZip(team.getLocation().getZip());
        dto.setCountry(team.getLocation().getCountry_code());
        dto.setTimezone(team.getLocation().getTimezone());
        dto.setLatitude(team.getLocation().getLatitude());
        dto.setLongitude(team.getLocation().getLongitude());
        dto.setElevation(team.getLocation().getElevation());
        dto.setCapacity(team.getLocation().getCapacity());
        dto.setYearConstructed(team.getLocation().getYear_constructed());
        dto.setGrass(team.getLocation().getGrass());
        dto.setDome(team.getLocation().getDome());
        return dto;
    }

    public TeamNameDto toTeamName(Team team) {
        TeamNameDto dto = new TeamNameDto();
        dto.setId(team.getId());
        dto.setName(team.getSchool());
        dto.setAbbreviation(team.getAbbreviation());
        return dto;
    }

}
