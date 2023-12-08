import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from "@angular/material/table";
import { Team } from "../../model/team";
import { TeamService } from "../../service/team.service";
import { MatSort } from "@angular/material/sort";

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.scss']
})
export class TeamsComponent implements OnInit, AfterViewInit {

  @ViewChild(MatSort) sort: MatSort;
  searchValue = '';
  selectedConference = 'All';

  displayedColumns: string[] = ['school', 'abbreviation', 'conference', 'classification', 'city', 'state'];
  dataSource: MatTableDataSource<Team> = new MatTableDataSource<Team>();

  private teamsAll: Team[];
  private teams: Team[];
  conferences = [];

  isLoading = false;

  constructor(private teamService: TeamService) {
  }

  ngOnInit(): void {
    this.getTeamList();
  }

  ngAfterViewInit(): void {
    this.resetDatasource();
  }

  resetDatasource() {
    this.dataSource.data = this.teams;
    this.searchValue = '';
    this.dataSource.filter = this.searchValue;
    this.dataSource.sort = this.sort;
  }

  searchEvent(event: Event) {
    this.searchValue = ((event.target as HTMLInputElement).value).trim().toLowerCase();
    this.dataSource.filter = this.searchValue;
    this.dataSource.sort = this.sort;
  }

  selectConference() {
    this.teams = this.teamsAll;
    if (this.selectedConference !== 'All') {
      this.teams = this.teams.filter((team: Team) => team.conference === this.selectedConference);
    }
    this.dataSource.data = this.teams;
  }

  private getTeamList() {
    this.isLoading = true;
    this.teamService.getAllTeams()
      .subscribe((response: any) => {
        this.teamsAll = response;
        this.teams = this.teamsAll;
        this.dataSource.data = this.teams;
        this.getConferences();
        this.isLoading = false;
      });
  }

  private getConferences() {
    this.conferences = [...new Set(this.teamsAll.map(team => team.conference))];
    this.conferences.sort();
  }

}
