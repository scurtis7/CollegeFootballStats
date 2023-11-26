import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from "@angular/material/sort";
import { MatTableDataSource } from "@angular/material/table";
import { Roster } from "../../model/roster";
import { TeamService } from "../../service/team.service";
import { TeamName } from "../../model/team-name";

@Component({
  selector: 'app-roster',
  templateUrl: './roster.component.html',
  styleUrls: ['./roster.component.scss']
})
export class RosterComponent implements OnInit, AfterViewInit {

  @ViewChild(MatSort) sort: MatSort;
  searchValue = '';
  selectedYear = '2023';
  selectedTeam = '';

  displayedColumns: string[] = ['jersey', 'first_name', 'last_name', 'position', 'year', 'height', 'weight'];
  dataSource: MatTableDataSource<Roster> = new MatTableDataSource<Roster>();

  private playersAll: Roster[];
  private players: Roster[];
  years: string[] = [];
  teams: TeamName[] = [];

  isLoading = false;

  constructor(private teamService: TeamService) {
  }

  ngOnInit(): void {
    this.getYears();
    this.getTeamNames();
  }

  ngAfterViewInit(): void {
    this.resetDatasource();
  }

  resetDatasource() {
    this.dataSource.data = this.players;
    this.searchValue = '';
    this.dataSource.filter = this.searchValue;
    this.dataSource.sort = this.sort;
  }

  selectYear() {
    this.getRoster();
  }

  selectTeam() {
    this.getRoster();
  }

  searchEvent(event: Event) {
    this.searchValue = ((event.target as HTMLInputElement).value).trim().toLowerCase();
    this.dataSource.filter = this.searchValue;
    this.dataSource.sort = this.sort;
  }

  private getRoster() {
    this.isLoading = true;
    this.teamService.getRoster(this.selectedYear, this.selectedTeam)
      .subscribe((response: any) => {
        this.playersAll = response;
        this.players = this.playersAll;
        this.dataSource.data = this.players;
        this.isLoading = false;
      });
  }

  private getYears() {
    // this.selectedYear = '2023';
    this.years = ['2024', '2023', '2022', '2021', '2020', '2019', '2018', '2017', '2016', '2015'];
  }

  private getTeamNames() {
    this.isLoading = true;
    this.teamService.getTeamNames()
      .subscribe((response: any) => {
        this.teams = response;
        this.isLoading = false;
      });
  }

}
