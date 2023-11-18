import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Team } from "../model/team";

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http: HttpClient) {}

  public getAllTeams(): Observable<Team[]> {
    return this.http.get<Team[]>(`http://localhost:8080/teams`);
  }

}
