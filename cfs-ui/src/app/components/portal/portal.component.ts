import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from "@angular/material/sort";
import { MatTableDataSource } from "@angular/material/table";
import { PortalPlayer } from "../../model/portal-player";
import { PlayerService } from "../../service/player.service";

@Component({
  selector: 'app-portal',
  templateUrl: './portal.component.html',
  styleUrls: ['./portal.component.scss']
})
export class PortalComponent implements OnInit, AfterViewInit {

  @ViewChild(MatSort) sort: MatSort;
  selectedYear = '2024';
  selectedOriginTeam = 'All';
  selectedDestinationTeam = 'All';
  selectedPosition = 'All';

  displayedColumns: string[] = ['firstName', 'lastName', 'position', 'origin', 'destination', 'rating', 'stars', 'transferDate', 'eligibility'];
  dataSource: MatTableDataSource<PortalPlayer> = new MatTableDataSource<PortalPlayer>();

  private playersAll: PortalPlayer[];
  private players: PortalPlayer[];
  totalPlayers = 0;
  years: string[] = [];
  originTeams: string[] = [];
  destinationTeams: string[] = [];
  positions: string[] = [];

  isLoading = false;

  constructor(private playerService: PlayerService) {
  }

  ngOnInit(): void {
    this.resetFilters();
    this.getYears();
    this.getPortalPlayers();
  }

  ngAfterViewInit(): void {
    this.resetDatasource();
  }

  resetDatasource() {
    this.dataSource.data = this.players;
    this.dataSource.sort = this.sort;
  }

  resetFilters() {
    this.selectedOriginTeam = 'All';
    this.selectedDestinationTeam = 'All';
    this.selectedPosition = 'All';
  }

  selectYear() {
    this.resetFilters();
    this.getPortalPlayers();
  }

  selectFilter() {
    this.players = this.playersAll;
    if (this.selectedOriginTeam !== 'All') {
      this.players = this.players.filter((player: PortalPlayer) => player.origin === this.selectedOriginTeam);
    }
    if (this.selectedDestinationTeam !== 'All') {
      this.players = this.players.filter((player: PortalPlayer) => player.destination === this.selectedDestinationTeam);
    }
    if (this.selectedPosition !== 'All') {
      this.players = this.players.filter((player: PortalPlayer) => player.position === this.selectedPosition);
    }
    this.dataSource.data = this.players;
    this.totalPlayers = this.players.length;
  }

  private getPortalPlayers() {
    this.isLoading = true;
    this.playerService.getPortalPlayersByYear(this.selectedYear)
      .subscribe((response: any) => {
        this.playersAll = response;
        this.players = this.playersAll;
        this.dataSource.data = this.players;
        this.totalPlayers = this.players.length;
        this.getOriginTeams();
        this.getDestinationTeams();
        this.getPositions();
        this.isLoading = false;
      });
  }

  private getYears() {
    this.years = ['2024', '2023', '2022', '2021', '2020', '2019', '2018', '2017', '2016', '2015'];
  }

  private getOriginTeams() {
    this.originTeams = [...new Set(this.playersAll.map(player => player.origin))];
    this.originTeams.sort();
  }

  private getDestinationTeams() {
    this.destinationTeams = [...new Set(this.playersAll.map(player => player.destination))];
    this.destinationTeams.sort();
  }

  private getPositions() {
    this.positions = [...new Set(this.playersAll.map(player => player.position))];
    this.positions.sort();
  }

}
