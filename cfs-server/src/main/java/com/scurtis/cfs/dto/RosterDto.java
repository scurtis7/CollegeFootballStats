package com.scurtis.cfs.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RosterDto implements Comparable<RosterDto> {

    private String id;
    private String first_name;
    private String last_name;
    private String team;
    private int weight;
    private int height;
    private int jersey;
    private int year;
    private String position;
    private String home_city;
    private String home_state;
    private String home_country;
    private float home_latitude;
    private float home_longitude;
    private String home_county_fips;
    private List<Integer> recruit_ids;

    @Override
    public int compareTo(RosterDto other) {
        return getLast_name().compareTo(other.getLast_name());
    }

}
