package com.scurtis.cfs.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamDto {

    private int id;
    private String school;
    private String mascot;
    private String abbreviation;
    private String alt_name1;
    private String alt_name2;
    private String alt_name3;
    private String classification;
    private String conference;
    private String division;
    private String color;
    private String alt_color;
    private List<String> logos;
    private String twitter;
    private Integer locId;
    private String stadiumName;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String timezone;
    private Double latitude;
    private Double longitude;
    private String elevation;
    private Integer capacity;
    private Integer yearConstructed;
    private Boolean grass;
    private Boolean dome;

}
