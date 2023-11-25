package com.scurtis.cfs.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BetLine {

    private int id;
    private int season;
    private String seasonType;
    private int week;
    private String startDate;
    private String homeTeam;
    private String homeConference;
    private int homeScore;
    private String awayTeam;
    private String awayConference;
    private int awayScore;
    private List<Line> lines;

    @Getter
    @Setter
    public static class Line {

        private String provider;
        private String spread;
        private String formattedSpread;
        private String spreadOpen;
        private String overUnder;
        private String overUnderOpen;
        private int homeMoneyline;
        private int awayMoneyline;

    }

}
