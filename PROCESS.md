# About
This documents states the process followed to build the RESTful webservice using both Test Drivern Development and Behaviour Driven Development process

1. **Create the project structure:**
*this will be a parent project containing two modules*

    1. RESTFul web service including unit test, and 
    2. Service‘s behaviour test scnearios

2. **Create first module: Compute-BDD**

    1. Write the feature file – test scenarios (Behaviour of the WebService)
    2. Create the setup to run the test scenario 
    3. Implement the step definition, create required class and interfaces, add required dependencies
    4. Do the required configuration to run it with other frameworks such as springboot


3. **Create Second module: Compute-TDD**

    1. Create the springboot server and add the controller
        > Start the springboot server 
        
        > Run the Cucumber test and let it fail
    2. Add the test configuration, and all required dependencies
    3. Create a class with method to add two number 
    4. Add the test cases using MockitoJUnitRunner
    5. Run them, let them fail
    6. Refactor code and Run the test again,
    7. Repeat the step until all the tests pass


4. **Build and install the app using maven** 
5. **Run the springboot server**
6. **Run the Cucumber test and Repeat step [3.vi]**
