sudo apt update
sudo apt-get install openjdk-17-jdk maven mysql-client-core-8.0 -y
# because I couldn't access the DB from outside the VPC, we will set it up through this EC2 instance instead
# connect to your database instance using a command similar to 
# `mysql -h es-database.cajukacwqnpg.us-east-1.rds.amazonaws.com -P 3306 -u admin -p` and enter your password

# once connected, execute the uncommented in queries.sql in the database folder to create your database and tables
# once that's finished, you can log out of the database server by typing `exit`, which should bring you back to your backend server

# with your database set up, make sure to update `application.properties` to reflect the RDS DB credentials

git clone -b public https://github.com/mburnayev/ExcalSol-IV-challenge.git
cd backend/ESGBBackend
mvn package
mv /home/ubuntu/ExcalSol-IV-challenge/backend/ESGBBackend/target/ESGBBackend-0.0.1-SNAPSHOT.jar /home/ubuntu
nohup java -jar ESGBBackend-0.0.1-SNAPSHOT.jar &
