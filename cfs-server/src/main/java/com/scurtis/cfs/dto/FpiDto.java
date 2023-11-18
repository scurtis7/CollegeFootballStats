package com.scurtis.cfs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FpiDto {

    private int year;
    private String team;
    private String conference;
    private double fpi;
    private int strengthOfRecord;
    private int resumeFpi;
    private int averageWinProbability;
    private int strengthOfSchedule;
    private int remainingStrengthOfSchedule;
    private int gameControl;
    private double overallEfficiency;
    private double offenseEfficiency;
    private double defenseEfficiency;
    private double specialTeamsEfficiency;

}
