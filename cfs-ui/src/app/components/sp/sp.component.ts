import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from "@angular/material/sort";
import { MatTableDataSource } from "@angular/material/table";
import { Team } from "../../model/team";
import { RatingService } from "../../service/rating.service";

@Component({
  selector: 'app-sp',
  templateUrl: './sp.component.html',
  styleUrls: ['./sp.component.scss']
})
export class SpComponent implements OnInit, AfterViewInit {

  @ViewChild(MatSort) sort: MatSort;
  selectedYear: number;

  displayedColumns: string[] = ['row', 'team', 'conference', 'rating', 'ranking', 'secondOrderWins', 'sos', 'offenseRating', 'offenseRanking', 'defenseRating', 'defenseRanking', 'havocTotal'];
  dataSource: MatTableDataSource<Team> = new MatTableDataSource<Team>();

  private teamsAll: Team[];
  private teams: Team[];
  years = ['2024', '2023', '2022', '2021', '2020', '2019', '2018', '2017', '2016', '2015'];

  isLoading = false;

  constructor(private ratingService: RatingService) {
  }

  ngOnInit(): void {
    this.selectedYear = 2023;
    this.getSpList();
  }

  ngAfterViewInit(): void {
    this.resetDatasource();
  }

  resetDatasource() {
    this.dataSource.data = this.teams;
    this.dataSource.sort = this.sort;
  }

  selectYear() {
    this.getSpList();
  }

  private getSpList() {
    this.isLoading = true;
    this.ratingService.getSp(this.selectedYear)
      .subscribe((response: any) => {
        this.teamsAll = response;
        this.teams = this.teamsAll;
        this.dataSource.data = this.teams;
        this.isLoading = false;
      });
  }

}
