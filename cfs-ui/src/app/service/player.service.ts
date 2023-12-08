import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Roster } from "../model/roster";
import { PortalPlayer } from "../model/portal-player";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) { }

  public getPortalPlayersByYear(year: string): Observable<PortalPlayer[]> {
    return this.http.get<PortalPlayer[]>(`http://localhost:8080/player/portal/year/` + year);
  }

}
