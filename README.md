# Person Management System
Microservice for managing person records

## Requirements
* Java 8
* Maven 3.6.0
* Eclipse or other IDE having maven

## Setup

This repo contains an Spring Boot framework application. To setup the dev environment do the following:

* Clone the repo
* Import the maven project inside eclipse.

## Setup using command prompt

* To build the project locally go inside personmgmtsystem folder and run below command

   mvn clean install

## Run using command prompt

* To run the services locally go inside personmgmtsystem/pms-war/target and run below command

    java -jar pms-war-1.0.0-SNAPSHOT.war

* Server starts at http://localhost:8080


* To access all the REST API's as Postman collections, please go to the folder data/request
	APIs in the microservices(Documentation avaialble at https://documenter.getpostman.com/view/10177101/SWT8hf1n?version=latest)
	* API to create new person in the system
    * API to List persons which will list paginated results.
	* API to fetch details of specific person by ID
	* API to update details of specific person by ID
	* API to delete one or more persons by passing ID/ID's(comma seperated)