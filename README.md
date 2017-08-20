# Read Me
This RESTful web service is built using Test Driven Development (TDD) and Behavioural Driven Development (BDD)

*To know the process, I followed to develop this WebService, please read*
[BDD and TDD process](PROCESS.md)

## About the repository
This repository contains a Maven project which includes:
#### Compute-BDD module
BDD Scenarios written using Cucumber in Gherkin format
#### Compute-TDD module
TDD Scenarios written using MockitoJUnitRunner and JUnit

Following tools and frameworks are used while developing this project:
1. **Programming Languge**: Java
2. **Project Management Tool**: Maven
3. **Standalone Rest Framework**: Springboot
4. **Spring Client**: RestTemplate
5. **BDD**: Cucumber/Gherkin
6. **TDD**: Junit and MockitoJUnitRunner
7. **IDE**: IntelliJ Idea

## Prerequisite
1. Maven installed and configured
2. Java installed and configured
3. IDE \*optional

## How do I get setup
1. Download the repository
2. Extract it
### Perform TDD
1. Open CMD prompt
2. Go to module **Compute-TDD**
3. Run command: 
```
mvn clean test
```
### Run Server and Application
1. Open CMD prompt
2. Go to module **Compute-TDD**
3. Run command: 
```
mvn spring-boot:run
```
**HTTP request Example**

*GET - To get the total
```
http://localhost:8080/calculator/add/253683/7653721
```
### Perform BDD
Prerequisite: Start the springboot application and server
1. Open CMD prompt
2. Go to module **Compute-BDD**
3. Run command: 
```
mvn clean test
```
### Who do I talk to? ###

For more information Contact: :email: Udit Choudhary at uditchoudhary@gmail.com
