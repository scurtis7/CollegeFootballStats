package com.scurtis.cfs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamNameDto implements Comparable<TeamNameDto> {
    private int id;
    private String name;
    private String abbreviation;

    @Override
    public int compareTo(TeamNameDto other) {
        return getName().compareTo(other.getName());
    }

}
