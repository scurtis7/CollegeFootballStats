import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from "@angular/material/sort";
import { MatTableDataSource } from "@angular/material/table";
import { Team } from "../../model/team/team";
import { RatingService } from "../../service/rating.service";

@Component({
  selector: 'app-fpi',
  templateUrl: './fpi.component.html',
  styleUrls: ['./fpi.component.scss']
})
export class FpiComponent implements OnInit, AfterViewInit {

  @ViewChild(MatSort) sort: MatSort;
  selectedYear: number;

  displayedColumns: string[] = ['team', 'conference', 'fpi', 'averageWinProbability', 'strengthOfSchedule', 'gameControl'];
  dataSource: MatTableDataSource<Team> = new MatTableDataSource<Team>();

  private teamsAll: Team[];
  private teams: Team[];
  years = ['2024', '2023', '2022', '2021', '2020', '2019', '2018', '2017', '2016', '2015'];

  isLoading = false;

  constructor(private ratingService: RatingService) {
  }

  ngOnInit(): void {
    this.selectedYear = 2023;
    this.getFpiList();
  }

  ngAfterViewInit(): void {
    this.resetDatasource();
  }

  resetDatasource() {
    this.dataSource.data = this.teams;
    this.dataSource.sort = this.sort;
  }

  selectYear() {
    this.getFpiList();
  }

  private getFpiList() {
    this.isLoading = true;
    this.ratingService.getFpi(this.selectedYear)
      .subscribe((response: any) => {
        this.teamsAll = response;
        this.teams = this.teamsAll;
        this.dataSource.data = this.teams;
        this.isLoading = false;
      });
  }



}
