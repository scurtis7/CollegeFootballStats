# College Football Stats

## Description
College football stats contains two applications for showing information and statistics for college football.

### Server
The `cfs-server` is a SpringBoot application that makes the backend calls to get the statistics and information for the UI.  The server
makes calls to the [College Football Data API](https://api.collegefootballdata.com/api/docs/?url=/api-docs.json#/)
to get the information.

#### Technology Stack

- Java - 17
- Spring Boot - 3.x
- Webflux
- Angular - 16.x

## UI
The `cfs-ui` is an Angular application to show the statistics and information to the user.

#### Technology Stack

- Angular - 16.x
- Material UI - 16.x
- BootStrap - 5.x
- BootStrap Icons - 1.x
