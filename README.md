# John Spink Individual Project

This repository is for my egg calender project 

# Problem 

I get chicken eggs and duck eggs and would like to keep track of them.
I would like to have a enter date for when I received the egg and have a calender update with a wash by date and a use by date generated with an ID for the egg.

## simplified 

* enter egg ID 
####Update 
* Update fields 
 
#### Insert Data
* enter egg date
* enter egg type
* enter user with zipcode
#### Generate Data
* have an ID  
* have a Wash by date / refrigarate by date 2 week after entering
* have a use by date 3 weeks after refrigeration
* use zipcode to reseve weather data from api
#### Use Data
* add dates with ID's to a datatable

# Technologies 
#### Custom tag lib
[TagLib](https://github.com/Norskknight/customTagLib)
#### security
    
    Tomcat's JDBC Realm Authentication
    Admin role: create/read/update/delete (crud) of all data
    User role: create/read/update/delete egg, edit data they have entered previously
#### Database
    MySQL
    Store users and roles
    store egg entered date and type 
#### Orm Framework - Object Relational Mapping
    Hibernate 5
#### Dependency Managemnt 
    maven
#### CSS
    css Grid
    dataTables
#### Data Validation
    TBD
#### Logging
    Configurable logging using Log4J2.
    In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting.
#### Hosting
    AWS
#### Independent Research Topic
    CSS Grid
#### Unit Testing
    JUnit tests to achieve 80% coverage
#### IDE
    IntelliJ IDEA
    Atom
    
### [AWS Terminated]
### [Screen Designs](design/Screens.md)
### [Project Plan](Project%20Plan.md)
### [TimeLog](timeLog.md)
### [Database Diagram](design/DB.png)
### [Test Coverage](design/TestCoverage.png)
### [Logging](design/Logging.png)
### [Demo Video](https://www.youtube.com/watch?v=xgMt1UEpXGI&feature=youtu.be)
