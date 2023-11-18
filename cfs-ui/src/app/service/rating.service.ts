import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Fpi } from "../model/rating/fpi";

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  constructor(private http: HttpClient) {
  }

  public getFpi(year: number): Observable<Fpi[]> {
    return this.http.get<Fpi[]>(`http://localhost:8080/ratings/fpi/year/` + year);
  }

}
