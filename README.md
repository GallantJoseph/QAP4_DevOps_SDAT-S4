# QAP 4 - DevOps/SDAT - Golf Club Tournament API
# Documentation

## Docker

To build the image and run a container, execute the following commands:<br><br>
docker build -t josephgallant/golftournamentapp .<br>
docker compose up<br>

## RDS
To use the RDS instance:
- For the local application: in /src/main/resources/applications.properties, comment the spring.datasource.url line which contains "localhost", and uncomment the next line which contains "rds" in the URL.
- For the Docker container: in Docker-compose.yml, comment the spring.datasource.url line which contains "host.docker.internal", and uncomment the next line which contains "rds" in the URL.<br><br>

Note: the RDS instance will not be available. Only for demonstration purposes.

## Feedback
Docker was a bit intricate to get up and running, especially pushing the image on my Docker Hub the first time. 
The Docker action on GitHub worked just fine afterward. I had to do some research in order to get everything working properly.<br>

Amazon RDS was easy to set up. I didn't have much trouble at all. The security group was simple to create, RDS gave me to option to create it alongside.

---
# Screenshots

## AWS & RDS Configuration

### RDS Instance Information
![AWS RDS Infos](./screenshots/AWS_RDS_Infos.png)

### RDS Security Group Configuration
![AWS RDS Security Group](./screenshots/AWS_RDS_Security_Group.png)

### RDS Application Configuration
![RDS Config](./screenshots/RDS_Config.png)

### RDS Database Structure
![RDS Database](./screenshots/RDS_Database.png)

### Members POST Operation in RDS
![RDS Members POST](./screenshots/RDS_Members_POST.png)

---

## Docker & CI/CD Pipeline

### GitHub Actions Workflow
![GitHub Actions](./screenshots/GitHub_Actions.png)

### Docker Action Step
![Docker Action](./screenshots/Docker_Action.png)

### Running Docker Container
![Docker Container](./screenshots/Docker_Container.png)

### Docker Hub Containers List
![Docker Hub Container List](./screenshots/Docker_Hub_Containers_List.png)

### Pushing Image to Docker Hub
![Docker Push Hub](./screenshots/Docker_Push_Hub.png)

---

## Member API Endpoints

### Create Member (POST)
![Member POST](./screenshots/Member_POST.png)

### Get All Members
![Member GET All](./screenshots/Member_GET_all.png)

### Get Member by ID
![Member GET by ID](./screenshots/Member_GET_id.png)

### Get Members by First Name
![Member GET by First Name](./screenshots/Member_GET_firstName.png)

### Get Members by Last Name
![Member GET by Last Name](./screenshots/Member_GET_lastName.png)

### Get Members by Tournament Start Date
![Member GET by Tournament Start Date](./screenshots/Member_GET_by_tournamentStartDate.png)

### Update Member (PUT)
![Member PUT](./screenshots/Member_PUT.png)

### Delete Member (DELETE)
![Member DELETE](./screenshots/Member_DELETE.png)

---

## Tournament API Endpoints

### Create Tournament (POST)
![Tournament POST](./screenshots/Tournament_POST.png)

### Add Member to Tournament
![Tournament POST Add Member](./screenshots/Tournament_POST_addMemberToTournament.png)

### Get All Tournaments
![Tournament GET All](./screenshots/Tournament_GET_all.png)

### Get Tournament by ID
![Tournament GET by ID](./screenshots/Tournament_GET_id.png)

### Get Tournaments by Location
![Tournament GET by Location](./screenshots/Tournament_GET_location.png)

### Get Tournaments by Start Date
![Tournament GET by Start Date](./screenshots/Tournament_GET_startDate.png)

### Update Tournament (PUT)
![Tournament PUT](./screenshots/Tournament_PUT.png)

### Delete Tournament
![Tournament DELETE](./screenshots/Tournament_DELETE.png)

### Delete Member From Tournament
![Tournament DELETE Member](./screenshots/Tournament_DELETE_deleteMemberFromTournament.png)

---

