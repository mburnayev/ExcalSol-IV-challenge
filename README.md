# README
An implementation of the provisioned interview coding challenge\
**Due end of day Wednesday, September 3, 2025**

## Project Specifics
### Assumptions
- I imagine the interview challenge doc is confidential, so it should probably not go in this repository
- I should probably keep this repository private until the day of presentation (or just add my IVers?)
- I can create arbitrary records as soon as a user is created [confirmed]
- Considering that I'm created a gradebook that's only viewable by students, implementing just GET/POSTS is sufficient [confirmed]
- I imagine the business context highlights are not merely suggestions, and I should actually have a robust system that is publicly accessible

### High-Level System Diagram
xyz

### Core Component Deployment Diagram
xyz

### Setup Instructions
- Create a landing page that will allow users to log in and sign up
- Create a page where scores will be displayed
- Create a MySQL database
- Create schema and tables for holding students, classes, enrollments, and grades
- Create Spring Boot backend using https://start.spring.io, set up using the screenshot configuration

- Generate and extract zip contents
- TBD

### Testing Steps
xyz

### Notes
Originally created so that entire system runs locally and frontend can be accessed via localhost
(Plans to get this implementation) Revised and fully public-facing using cloud services

Tech stack used:
- HTML + TypeScript with Angular Framework
- Java with Spring Boot Framework
- MySQL Database

- Locally hosted frontend -> AWS EC2s for hosting w/ Nginx
- Locally hosted backend -> AWS EC2 as well probably
- Locally hosted MySQL DB -> AWS RDS
- Docker
- Jenkins

### Sources Used
Frontend:
https://www.w3schools.com/css/css_align.asp
https://v17.angular.io/guide/router

Backend:

Database:
https://www.youtube.com/watch?v=ODA3rWfmzg8

