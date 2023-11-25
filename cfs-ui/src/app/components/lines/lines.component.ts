import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from "@angular/material/sort";
import { MatTableDataSource } from "@angular/material/table";
import { Line } from "../../model/line";
import { LineService } from "../../service/line.service";

@Component({
  selector: 'app-lines',
  templateUrl: './lines.component.html',
  styleUrls: ['./lines.component.scss']
})
export class LinesComponent implements OnInit, AfterViewInit {

  @ViewChild(MatSort) sort: MatSort;
  searchValue = '';
  selectedYear = '2023';
  selectedWeek = '13';

  displayedColumns: string[] = ['homeTeam', 'homeConference', 'homeScore', 'awayTeam', 'awayConference', 'awayScore', 'bovadaSpread', 'draftKingsSpread', 'espnSpread'];
  dataSource: MatTableDataSource<Line> = new MatTableDataSource<Line>();

  private linesAll: Line[];
  private lines: Line[];
  years: string[] = [];
  weeks: string[] = [];

  isLoading = false;

  constructor(private lineService: LineService) {
  }

  ngOnInit(): void {
    this.getYears();
    this.getWeeks();
    this.getLines();
  }

  ngAfterViewInit(): void {
    this.resetDatasource();
  }

  resetDatasource() {
    this.dataSource.data = this.lines;
    this.searchValue = '';
    this.dataSource.filter = this.searchValue;
    this.dataSource.sort = this.sort;
  }

  selectYear() {
    this.getLines();
  }

  selectWeek() {
    this.getLines();
  }

  searchEvent(event: Event) {
    this.searchValue = ((event.target as HTMLInputElement).value).trim().toLowerCase();
    this.dataSource.filter = this.searchValue;
    this.dataSource.sort = this.sort;
  }

  private getLines() {
    this.isLoading = true;
    this.lineService.getLines(this.selectedYear, this.selectedWeek)
      .subscribe((response: any) => {
        this.linesAll = response;
        this.lines = this.linesAll;
        this.dataSource.data = this.lines;
        this.isLoading = false;
      });
  }

  private getYears() {
    // this.selectedYear = '2023';
    this.years = ['2024', '2023', '2022', '2021', '2020', '2019', '2018', '2017', '2016', '2015'];
  }

  private getWeeks() {
    // this.selectedWeek = '1';
    this.weeks = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15'];
  }

}
