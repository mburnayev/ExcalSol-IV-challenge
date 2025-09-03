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
<img width="748" height="550" alt="Screenshot 2025-09-01 at 12 58 24 PM" src="https://github.com/user-attachments/assets/294e6a30-a52a-4bc3-907f-08fa644b10df" />

### Core Component Deployment Diagram
xyz

### Setup Instructions
- Download your MySQL community server from [here](https://dev.mysql.com/downloads/) and install it
    - Optionally install MySQL Workbench to access and interact with your databases through a GUI
- Create a MySQL database
- Using the database you just created, create tables in your database based on your schema
- Your database, while running, will by default be hosted on port 3306

- Create Spring Boot backend using its [bootstrapper](https://start.spring.io), set up using the screenshot configuration
<img width="660" height="370" alt="springbootstrap" src="https://github.com/user-attachments/assets/d3dc9899-f371-42a7-a6a8-106b6ff8662e" />


- Hit "generate" and extract the zip contents into your workspace
- Inside your workspace, navigate to src/main/resources and update application.properties to allow your backend access to your database
- Inside your workspace, navigate to src/main/java/<your group>
- If the controller, entity, repository, and service subdirectories aren't present, make them
- Implement the respective functionalities inside each of these subdirectories
- Once complete, run your backend server using mvn `mvn spring-boot:run`, you'll have to have Maven installed for this
- Your backend, while running, will by default be hosted on port 8080

- Create a landing page that will allow users to log in and sign up
- Create a page where scores will be displayed

### Testing Steps
#### Database
Since I opted for a very simple schema with only one table, testing the database by directly querying in the minimalist fashion that the backend will also be doing it is also simple — the Student table has 13 columns: 1 for an id, 1 for a username, 1 for a password hash, and 10 for grades.

As such, entries can be created using
```
INSERT INTO Student
VALUES(<integer>, "username", "password", "2 char string"/NULL, ..., "2 char string"/NULL);
```

Entries can be filtered through using
```
SELECT <column(s)> FROM Student WHERE <criteria>;
```
#### Backend
Backend testing can be done using Postman since API endpoints are set up (though testing using localhost requires installing Postman Agent), and GET and POST requests can be tested as follows:\
GET:<img width="1367" height="651" alt="get_example" src="https://github.com/user-attachments/assets/af69a276-cee1-473c-94ba-bff201cbd652" />
POST:<img width="1377" height="660" alt="post_exmaple" src="https://github.com/user-attachments/assets/009b2364-b8ba-424d-b9b0-83b1e2b8a237" />

### Notes
Originally created so that entire system runs locally and frontend can be accessed via localhost
(Plans to get this implementation) Revised and fully public-facing using cloud services

As mentioned in the Testing Steps, the database schema I used is very simple and not a good representation of best practices when using relational databases; I opted for this solution strictly for demonstrative purposes. I initially came up with a more complex schema, as shown below, that made use of relations, but realized it would take longer to create test queries and even longer to implement backend calls that would satisfy the relations, so I opted for what I knew I could implement in the time I had alloted.
<img width="580" height="397" alt="better_schema" src="https://github.com/user-attachments/assets/fdeacfdb-cbd6-42b4-8f68-9c5904ad063c" />

Tech stack used:
- HTML + TypeScript with Angular Framework
- Java with Spring Boot Framework
- MySQL Database
- Postman
---
- Locally hosted frontend -> AWS EC2s for hosting w/ Nginx
- Locally hosted backend -> AWS EC2 as well probably
- Locally hosted MySQL DB -> AWS RDS
- Docker
- Jenkins

### Sources Used
Frontend:\
https://www.w3schools.com/css/css_align.asp <br>
https://v17.angular.io/guide/router <br>

Backend: \
https://www.geeksforgeeks.org/advance-java/easiest-way-to-create-rest-api-using-spring-boot/ <br>
https://stackoverflow.com/questions/40902280/what-is-the-recommended-project-structure-for-spring-boot-rest-projects <br>
https://stackoverflow.com/questions/54758872/spring-boot-security-postman-gives-401-unauthorized <br>
https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/ <br>

Database: \
https://www.youtube.com/watch?v=ODA3rWfmzg8 <br>
https://www.w3schools.com/sql/sql_syntax.asp <br>
https://www.w3schools.com/sql/sql_datatypes.asp and adjacent pages on keywords <br>

