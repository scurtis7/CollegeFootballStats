import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Fpi } from "../model/fpi";
import { Sp } from "../model/sp";

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  constructor(private http: HttpClient) {
  }

  public getFpi(year: number): Observable<Fpi[]> {
    return this.http.get<Fpi[]>(`http://localhost:8080/ratings/fpi/year/` + year);
  }

  public getSp(year: number): Observable<Sp[]> {
    return this.http.get<Sp[]>(`http://localhost:8080/ratings/sp/year/` + year);
  }

}
