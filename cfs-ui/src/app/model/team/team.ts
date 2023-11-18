import { TeamLocation } from "./team-location";

export class Team {
  id: number;
  school: string;
  mascot: string;
  abbreviation: string;
  alt_name1: string;
  alt_name2: string;
  alt_name3: string;
  conference: string;
  classification: string;
  color: string;
  alt_color: string;
  logos: string[];
  twitter: string;
  location: TeamLocation;
}
