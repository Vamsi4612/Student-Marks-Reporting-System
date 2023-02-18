# Student-Marks-Reporting-System

## Description


The Student Marks Reporting System is a comprehensive platform designed to streamline and simplify the process of managing and reporting academic performance. This intuitive system provides students, teachers, and administrators with a user-friendly interface that allows for efficient tracking and analysis of student progress. With real-time access to grades, attendance records, and other key metrics, this system empowers educational institutions to make data-driven decisions and provide personalized support to students. Say goodbye to cumbersome paper-based reporting and embrace the future of education with the Student Marks Reporting System.


## Modules

- Student Module
- MarksReport Module
- CustomQuerie Module


## ER Diagram
Following ER diagram indicates the database tables and thier interaction which we are using.
![Untitled Workspace](https://github.com/Vamsi4612/Student-Marks-Reporting-System/blob/main/ER%20Diagram.PNG)


## Features

* Student Features:
    * Can register the Student via Post method
    * Can check whether a student is present or not in the DataBase
    * Admin can access the details of different users, buses and routes.
* MarksReport Features:
    * Can insert the values into the database by choosing between the semester and subject
    * Can find the marks of the student by id or by branch or by semester
    * Can Update the values is given the given vvalues are wrong
* AverageReporting Features:
    * Using An Api can find the average percentage of whole class in recent semester
    * Can check the average score comparing the perfoemance in first and second semester  




## Contributors
- [@Vamsi Krishna](https://github.com/Vamsi4612)


## Installation & Run

- Before running the API server, you should update the database config inside the [application.properties](https://github.com/yendasivakumar/BusReservationSystem/tree/main/src/main/resources) file.
- Update the port number, username and password as per your local database config.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/reportsDb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```


## Techstack

- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL



