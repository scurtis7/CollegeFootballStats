package com.scurtis.cfs.converter;

import com.scurtis.cfs.dto.RosterDto;
import com.scurtis.cfs.model.Roster;
import org.springframework.stereotype.Service;

@Service
public class RosterConverter {

    public RosterDto toDto(Roster roster) {
        RosterDto dto = new RosterDto();
        dto.setId(roster.getId());
        dto.setFirst_name(roster.getFirst_name());
        dto.setLast_name(roster.getLast_name());
        dto.setTeam(roster.getTeam());
        dto.setWeight(roster.getWeight());
        dto.setHeight(roster.getHeight());
        dto.setJersey(roster.getJersey());
        dto.setYear(roster.getYear());
        dto.setPosition(roster.getPosition());
        dto.setHome_city(roster.getHome_city());
        dto.setHome_state(roster.getHome_state());
        dto.setHome_country(roster.getHome_country());
        dto.setHome_latitude(roster.getHome_latitude());
        dto.setHome_longitude(roster.getHome_longitude());
        dto.setHome_county_fips(roster.getHome_county_fips());
        dto.setRecruit_ids(roster.getRecruit_ids());
        return dto;
    }

}
