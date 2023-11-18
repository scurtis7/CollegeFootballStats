package com.scurtis.cfs.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fpi {

    private int year;
    private String team;
    private String conference;
    private double fpi;
    private ResumeRanks resumeRanks;
    private Efficiencies efficiencies;

    @Getter
    @Setter
    public static class ResumeRanks {
        private int strengthOfRecord;
        private int fpi;
        private int averageWinProbability;
        private int strengthOfSchedule;
        private int remainingStrengthOfSchedule;
        private int gameControl;
    }

    @Getter
    @Setter
    public static class Efficiencies {
        private double overall;
        private double offense;
        private double defense;
        private double specialTeams;
    }

}
