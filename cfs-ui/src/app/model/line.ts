export class Line {
  id: number;
  season: number;
  seasonType: string;
  week: number;
  startDate: string;
  homeTeam: string;
  homeConference: string;
  homeScore: number;
  awayTeam: string;
  awayConference: string;
  awayScore: number;

  espnSpread: string;
  espnFormattedSpread: string;
  espnSpreadOpen: string;
  espnOverUnder: string;
  espnOverUnderOpen: string;
  espnHomeMoneyLine: number;
  espnAwayMoneyLine: number;

  draftKingsSpread: string;
  draftKingsFormattedSpread: string;
  draftKingsSpreadOpen: string;
  draftKingsOverUnder: string;
  draftKingsOverUnderOpen: string;
  draftKingsHomeMoneyLine: number;
  draftKingsAwayMoneyLine: number;

  bovadaSpread: string;
  bovadaFormattedSpread: string;
  bovadaSpreadOpen: string;
  bovadaOverUnder: string;
  bovadaOverUnderOpen: string;
  bovadaHomeMoneyLine: number;
  bovadaAwayMoneyLine: number;

}
