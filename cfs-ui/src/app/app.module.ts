import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from "./common/material.module";
import { FormsModule } from "@angular/forms";
import { RouterModule, Routes } from "@angular/router";
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { TeamsComponent } from './components/teams/teams.component';
import { HttpClientModule } from "@angular/common/http";
import { SpinnerComponent } from './components/shared/spinner/spinner.component';
import { FpiComponent } from './components/fpi/fpi.component';
import { MenuComponent } from './components/shared/menu/menu.component';
import { SpComponent } from './components/sp/sp.component';
import { LinesComponent } from './components/lines/lines.component';
import { RosterComponent } from './components/roster/roster.component';
import { PortalComponent } from './components/portal/portal.component';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'teams', component: TeamsComponent },
  { path: 'roster', component: RosterComponent },
  { path: 'portal', component: PortalComponent },
  { path: 'fpi', component: FpiComponent },
  { path: 'sp', component: SpComponent },
  { path: 'lines', component: LinesComponent },
  { path: '**', redirectTo: 'dashboard' }
];

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    TeamsComponent,
    SpinnerComponent,
    FpiComponent,
    MenuComponent,
    SpComponent,
    LinesComponent,
    RosterComponent,
    PortalComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    // {
    //   provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true
    // }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
