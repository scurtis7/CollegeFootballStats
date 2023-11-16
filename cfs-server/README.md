# College Football Stats Server

College football stats server provides the backend service for the college 
football stats UI.  A REST controller is exposed for the UI to make calls 
to the  [College Football Data API](https://api.collegefootballdata.com/api/docs/?url=/api-docs.json#/).

## Stack

The CFS Server is built on top of a few core technologies:

* Java 17
* Webflux
* [Maven](https://maven.apache.org) (3.0.0+)
* [Spring Boot](https://spring.io/projects/spring-boot)

## Build

To build without running tests:

`mvn clean compile`

To build and run tests:

`mvn clean test`

To build and generate code coverage:

`mvn clean verify`

## Environment

In order to run the server, the following environmental variables must be set:

| VARIABLE     | Description                                                    |
|:-------------|:---------------------------------------------------------------|
| CFS_BASE-URL | URL to the college football data REST service                  |
| CFS_API-KEY  | The api key needed to make REST calls to college football data |
