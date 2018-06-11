## Task 
Assignment based on POM framework , uses Page Factory along with Selenium ,Junit , Maven and Hamcrest. 

### User Stories

1. As a user I want to ask for a loan of amount 2750 at smava.de, to pay during 24 months for living (Wohnen), click on next (Weiter) and verify that the page is completely loaded.

2. As a user I want to click on “Anmelden” and be able to introduce data, but not being able to log-in because the data is not correct. 

### Project
- Provided is pom.xml and src folder
- pom.xml will download all the dependencies
- src/main/java/pageObjects has elements of the page and methods using those elements
- src/test/pageTest has test methods which call the page object methods ,initialised using selenium page factory
- src/test/pageTest /BaseSetup which is extended by all tests has Before and After methods. Used to set the driver properties
- src/utils/configuration.properties is where browser, driver and url can be modified 

### Steps to Execute Tests 
Prerequisites 
- JDK 7 and above Download here http://www.oracle.com/technetwork/java/javase/downloads/index.html
- Maven 3+ Download here https://maven.apache.org/download.cgi 
- Chrome on Linux machine 
- Firefox 25+ Linux machine

### System configuration 
For Linux set system variables 
- JAVA_HOME and M2_HOME 
- Firefox binary path as $PATH 
Dependencies Will be taken care be pom.xml 
- selenium-java:3.5.3 • selenium-common:2.0b1 • hamcrest:1.3 • junit:4.8.2 

### mvn commands to execute the test on linux machine

1. Open command prompt , traverse to a folder on machine
    ```
    git clone 
    cd pom
   ```
2. Make chrome driver for selenium as executable
  ```
  cd src/utils 
  chmod +x chromedriver
  ```

3. Compile the code and skip the tests
  ```
  mvn clean install -DskipTest
  ```

4. This will run a single test 
 ``` 
  mvn test -Dtest=SignInTest
  mvn test –Dtest=LoanResultTest 
  ```

5 To run all tests run 
    ```mvn test ``` or use 
 ``` mvn surefire-report:report ```
 
### Check the results at - /target/site/surefire-report.html
