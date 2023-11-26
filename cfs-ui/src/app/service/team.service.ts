import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Team } from "../model/team";
import { Roster } from "../model/roster";
import { TeamName } from "../model/team-name";

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http: HttpClient) {}

  public getAllTeams(): Observable<Team[]> {
    return this.http.get<Team[]>(`http://localhost:8080/teams`);
  }

  public getRoster(year: string, team: string): Observable<Roster[]> {
    return this.http.get<Roster[]>(`http://localhost:8080/roster/year/` + year + `/team/` + team);
  }

  public getTeamNames(): Observable<TeamName[]> {
    return this.http.get<TeamName[]>(`http://localhost:8080/teams/names`);
  }

}
