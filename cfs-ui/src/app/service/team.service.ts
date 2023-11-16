import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Team } from "../model/team";

// @ts-ignore
import * as teamJson from '../../assets/json/teams.json';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  teams: any = (teamJson as any).default;

  constructor(private http: HttpClient) {}

  public getAllTeams(): Observable<Team[]> {
    return this.http.get<Team[]>(`http://localhost:8080/teams`);
  }

  // public getAllTeams(): Team[] {
  //   return this.teams;
  // }

}
