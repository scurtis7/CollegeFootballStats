import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Line } from "../model/line";

@Injectable({
  providedIn: 'root'
})
export class LineService {

  constructor(private http: HttpClient) {
  }

  public getLines(year: string, week: string): Observable<Line[]> {
    return this.http.get<Line[]>(`http://localhost:8080/lines/year/` + year + `/week/` + week);
  }

}
