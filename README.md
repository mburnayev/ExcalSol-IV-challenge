# README
An implementation of the provisioned interview coding challenge\
**Due end of day Wednesday, September 3, 2025**

## Project Specifics
### Assumptions
- I imagine the interview challenge doc is confidential, so it should probably not go in this repository
- I should probably keep this repository private until the day of presentation (or just add my IVers?)
- I can create arbitrary records as soon as a user is created [confirmed]
- Considering that I'm created a gradebook that's only viewable by students, implementing just GET/POSTs is sufficient [confirmed]
- I imagine the business context highlights are not merely suggestions, and I should actually have a robust system that is publicly accessible
- I don't think I need to include literally *every* resource I came across since that would work against keeping my README concise
    - I think including just the ones that provided the most utility would be satisfactory
- The instructions ask to include all required artifacts, but including some cloud stuff (e.g. ssh keys) doesn't seem smart, so I will omit those inclusions
    - I'll include what seems right, but will also make sensitive artifacts available upon request

### High-Level System Diagram
<img width="748" height="550" alt="Screenshot 2025-09-01 at 12 58 24 PM" src="https://github.com/user-attachments/assets/294e6a30-a52a-4bc3-907f-08fa644b10df" />

### Core Component Deployment Diagram
<img width="976" height="534" alt="deployment_diagram" src="https://github.com/user-attachments/assets/4c15a9b3-8a4f-4c70-95bf-23a5a580cebb" />

### Setup Instructions
- Download your MySQL community server from [here](https://dev.mysql.com/downloads/) and install it
    - Optionally install MySQL Workbench to access and interact with your databases through a GUI
- Create a MySQL database
- Using the database you just created, create tables in your database based on your schema
- Your database, while running, will by default be hosted on port 3306
---
- Create Spring Boot backend using its [bootstrapper](https://start.spring.io), set up using the screenshot configuration
<img width="660" height="400" alt="springbootstrap" src="https://github.com/user-attachments/assets/1b38401e-e3d7-40d5-b31b-3485febff5db" />


- Hit "generate" and extract the zip contents into your workspace
- Inside your workspace, navigate to src/main/resources and update application.properties to allow your backend access to your database
- Inside your workspace, navigate to src/main/java/<your group>
- If the controller, entity, repository, and service subdirectories aren't present, make them
- Implement the respective functionalities inside each of these subdirectories
- Once complete, run your backend server using `mvn spring-boot:run`, you'll have to have Maven installed for this
- Your backend, while running, will by default be hosted on port 8080
---
- Assuming you have `npm` installed, create a new Angular project using `ng new <project-name>
- Create a landing page component that will allow students to log in and sign up
- Create a scores page component where student scores will be displayed
- Configure routing from landing page to scores page on successful login
- In landing page TS, add logic to handle form inputs and use them to access backend API endpoints
- In scores page TS, add logic to display results of API responses on successful login
- Once complete, run your backend server using `ng serve`
- Your frontend, while running, will by default be hosted on port 4200

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
<img width="310" height="280" alt="get_ex" src="https://github.com/user-attachments/assets/1aea607a-af91-4998-8ac7-c602385c6808" />
<img width="310" height="280" alt="check_ex" src="https://github.com/user-attachments/assets/da9678fb-34f8-4a19-82cd-6d5c394fdeec" />
<img width="310" height="280" alt="post_ex" src="https://github.com/user-attachments/assets/c86b8121-2c22-4b17-adf5-07f2e5be59b0" />

#### Frontend
Around the time I was able to successfully create new students through the frontend, I remembered that a duplicate CREATE command would probably not work since usernames are unique and this would cause issues, so I made the backend POST/CREATE service check the Student repository for student with a potentially existing username before creating and adding a new student. I also figured I shouldn't allow users to create new students using nothingburger credentials, so I added empty string checks to all input fields.

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
https://www.w3schools.com/css/css_align.asp and adjacent pages on styling <br>
https://v17.angular.io/guide/router <br>
https://www.youtube.com/watch?v=bCB6i6y0unA <br>
https://angular.dev/api/forms/FormControl <br>
https://v17.angular.io/guide/router-tutorial-toh#query-parameters <br>
https://stackoverflow.com/questions/55924562/angular-routing-passing-json-object-but-param-is-1-solid-string <br>

Backend:\
https://www.geeksforgeeks.org/advance-java/easiest-way-to-create-rest-api-using-spring-boot/ <br>
https://stackoverflow.com/questions/40902280/what-is-the-recommended-project-structure-for-spring-boot-rest-projects <br>
https://stackoverflow.com/questions/54758872/spring-boot-security-postman-gives-401-unauthorized <br>
https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/ <br>

Database:\
https://www.youtube.com/watch?v=ODA3rWfmzg8 <br>
https://www.w3schools.com/sql/sql_syntax.asp <br>
https://www.w3schools.com/sql/sql_datatypes.asp and adjacent pages on keywords <br>

System Modeling:\
https://drawio-app.com/blog/create-uml-deployment-diagrams-in-draw-io/ <br>
https://www.lucidchart.com/pages/uml-deployment-diagram <br>

