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
#### Localhost
---
- Download your MySQL community server from [here](https://dev.mysql.com/downloads/) and install it
    - Optionally install MySQL Workbench to access and interact with your databases through a GUI
- Create a MySQL database
- Using the database you just created, create tables in your database based on your schema
- Your database, while running, will by default be hosted on port 3306
---
- Create Spring Boot backend using its [bootstrapper](https://start.spring.io), set up using the screenshot configuration
<img width="660" height="400" alt="Screenshot 2025-09-03 at 2 38 06 PM" src="https://github.com/user-attachments/assets/189e211b-73d2-4df8-983c-7fadb08b7e85" />


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
---
#### Greater Internet
---
- Once you are ready to deploy your database, save your SQL queries used to create the schema of your database
- In AWS, navigate to the Aurora and RDS dashboard and select "create a database"
- Choose the following selections in the following fields
    - Select Easy create under "Choose a database creation method"
    - MySQL under "Configuration"  
        - MySQL Community under "Edition"
        - Free tier under "DB instance size"
    - an appropriate name for your DB instance identifier
    - an appropriate username for your Master username
    - Self Managed under "Credentials management"
    - a strong password under Master password
    - Connect to an EC2 compute resource and select your backend EC2 under "Set up EC2 connection - optional"
    - Select "Create database"
[Here I got tremendously stuck accessing it and wasted a lot of time so I opted for an alternate solution]
- Further steps present in the backend setup
---
- In AWS, navigate to the EC2 dashboard and launch a new instance
- To complete the EC2 GUI configuration select/enter these options into the following fields:
    - <your_backend_server_name> in Name under Name and tag
    - Ubuntu Server 24.04 LTS (HVM) under Application and OS Images (Amazon Machine Image)
    - c7i-flex.large under Instance type
    - Select the key pair name you created when making your frontend under Key pair (login)
    - Select the common security group you created when making your frontend under Network Settings
    - Select "launch instance"
- Make sure to move your pemfile somewhere accessible for the following steps
- ssh into your new EC2 instance using your variables in the following command:
    - `ssh -i <pemfile>.pem ubuntu@ec2-44-212-29-14.compute-1.amazonaws.com`
- Once logged in, follow the steps in `backend_config.sh`
- If you get through the steps, you have a working spring app that is ready to handle requests 
- To test that my endpoints work, I can use this URL, `http://ec2-44-212-29-14.compute-1.amazonaws.com:8080/get/1`, which if it works, will return a valid response 
---
- With your backend set up, remember to retroactively update the API URL in the frontend to use the AWS URL and redeploy
- Once you have a production-ready frontend build, you can export your project using `ng build --configuration=production`
    - This will produce artifacts which are output in <angular_project>/dist/ which in my cases included
        - /browser
        - 3rdpartlicenses.txt
        - prerendered-routes.json
- For simplicity, also zip it and name it appropriately
- In AWS, navigate to the EC2 dashboard and launch a new instance
- To complete the EC2 GUI configuration select/enter these options into the following fields:
    - <your_frontend_server_name> in Name under Name and tag
    - Ubuntu Server 24.04 LTS (HVM) under Application and OS Images (Amazon Machine Image)
    - t3.micro under Instance type
    - "Create a new pair" and give it a relevant name for your project under Key pair (login), this will generate a .pem file which you should download
    - Allow SSH traffic from "My IP", HTTP and HTTPS traffic from the internet under Network Settings
    - Select "launch instance"
- Make sure you still have your pemfile from earlier
- ssh into your new EC2 instance using your variables in the following command:
    - `ssh -i <pemfile>.pem ubuntu@ec2-54-226-141-7.compute-1.amazonaws.com`
- Once logged in, follow the steps in `frontend_config.sh`
- If you get through the steps, you should see your Angular app when you visit your EC2 URL
---
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
Originally created so that entire system runs locally and frontend can be accessed via localhost, revised and made fully public-facing using cloud services

As mentioned in the Testing Steps, the database schema I used is very simple and not a good representation of best practices when using relational databases; I opted for this solution strictly for demonstrative purposes. I initially came up with a more complex schema, as shown below, that made use of relations, but realized it would take longer to create test queries and even longer to implement backend calls that would satisfy the relations, so I opted for what I knew I could implement in the time I had alloted.
<img width="580" height="397" alt="better_schema" src="https://github.com/user-attachments/assets/fdeacfdb-cbd6-42b4-8f68-9c5904ad063c" />

As you might've noticed when you successfully navigate to the `/grades` route, the URL also tacks on the JSON response body, which isn't a good practice and something I meant to fix, but I opted to start the great migration to public availability. Outside of the demo, I would resolve this security issue by using routing guards to just show the route.

Access to the Spring App server currently isn't secure since I initially had trouble fulfilling POST requests when I would authenticate all requests and I disabled it for development purposes, but didn't have time to go back and figure out why GETs worked without issue while POSTs returned 401s, despite both requiring (and providing) valid authentication credentials.

You may have noticed the frontend is not secure: I wanted to setup up an HTTPS connection since I had tried it in the past before for a different project, but I once again ran out of time. If I were to revise this project, I'd add the necessary references to certificates and keys and bring back the Inbound and Outbound rules for HTTPS traffic to my EC2s.

While I'm pretty sure AWS' services are managed in such a way that they are supposed to guarantee high uptime and performance, I unfortunately also didn't have time to hook up a load balancer to my frontend EC2 that I would've used in conjunction with Auto Scaling to spin up as many backends I would've needed to in different availability zones to handle hypothetical traffic. Fotunately, AWS is generous enough to provide a little bit of database redudancy by creating a backup database, but it's a far cry from using Aurora to get the horizontal scaling for maximal redundancy (and there's no free tier option to use it).

Tech stack used:
- HTML + TypeScript with Angular Framework
- Java with Spring Boot Framework
- MySQL Database
- Postman
- AWS EC2 for frontend hosting w/ Nginx     (ec2-54-226-141-7.compute-1.amazonaws.com)
- AWS EC2 for backend hosting               (ec2-13-218-50-88.compute-1.amazonaws.com)
- AWS RDS for database hosting my MySQL DB  (database-1.cajukacwqnpg.us-east-1.rds.amazonaws.com)

### Sources Used
Frontend:\
https://www.w3schools.com/css/css_align.asp and adjacent pages on styling <br>
https://v17.angular.io/guide/router <br>
https://www.youtube.com/watch?v=bCB6i6y0unA <br>
https://angular.dev/api/forms/FormControl <br>
https://v17.angular.io/guide/router-tutorial-toh#query-parameters <br>
https://stackoverflow.com/questions/55924562/angular-routing-passing-json-object-but-param-is-1-solid-string <br>
https://docs.angular.lat/cli/build <br>

Backend:\
https://www.geeksforgeeks.org/advance-java/easiest-way-to-create-rest-api-using-spring-boot/ <br>
https://stackoverflow.com/questions/40902280/what-is-the-recommended-project-structure-for-spring-boot-rest-projects <br>
https://stackoverflow.com/questions/54758872/spring-boot-security-postman-gives-401-unauthorized <br>
https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/ <br>
https://stackoverflow.com/questions/10036090/how-to-create-jar-using-maven-pom-xml <br>

Database:\
https://www.youtube.com/watch?v=ODA3rWfmzg8 <br>
https://www.w3schools.com/sql/sql_syntax.asp <br>
https://www.w3schools.com/sql/sql_datatypes.asp and adjacent pages on keywords <br>
https://stackoverflow.com/questions/16287559/mysql-adding-user-for-remote-access <br>
https://stackoverflow.com/questions/8348506/grant-remote-access-of-mysql-database-from-any-ip-address <br>

System Modeling:\
https://drawio-app.com/blog/create-uml-deployment-diagrams-in-draw-io/ <br>
https://www.lucidchart.com/pages/uml-deployment-diagram <br>

Cloud Setup:\
https://stackoverflow.com/questions/50378664/permission-denied-inside-var-www-html-when-creating-a-website-and-its-files-wi <br>
https://medium.com/globant/manual-deployment-of-angular-app-to-aws-ec2-b5cb5466bbfc <br>
https://www.digitalocean.com/community/tutorials/nginx-location-directive <br>
https://medium.com/@sharma1996priya/deploying-a-spring-boot-application-to-an-amazon-ec2-instance-using-the-scp-command-4656e330aa61 <br>
https://www.youtube.com/watch?v=qdk1p1zgBPI <br>
https://stackoverflow.com/questions/35858538/error-2003-hy000-cant-connect-to-mysql-server-on-aws-rds <br>
https://stackoverflow.com/questions/54211638/unable-to-open-jdbc-connection-for-ddl-execution <br>
https://stackoverflow.com/questions/39673660/springboot-app-running-on-aws-ec2-unable-to-connect-to-mysql-aws-rds-database <br>
