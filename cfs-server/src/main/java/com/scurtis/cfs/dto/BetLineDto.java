package com.scurtis.cfs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BetLineDto {

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

    private String espnSpread;
    private String espnFormattedSpread;
    private String espnSpreadOpen;
    private String espnOverUnder;
    private String espnOverUnderOpen;
    private int espnHomeMoneyLine;
    private int espnAwayMoneyLine;

    private String draftKingsSpread;
    private String draftKingsFormattedSpread;
    private String draftKingsSpreadOpen;
    private String draftKingsOverUnder;
    private String draftKingsOverUnderOpen;
    private int draftKingsHomeMoneyLine;
    private int draftKingsAwayMoneyLine;

    private String bovadaSpread;
    private String bovadaFormattedSpread;
    private String bovadaSpreadOpen;
    private String bovadaOverUnder;
    private String bovadaOverUnderOpen;
    private int bovadaHomeMoneyLine;
    private int bovadaAwayMoneyLine;

}
