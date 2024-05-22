# Woolworths API Testing

This repository contains automated tests for the Search API provided by Woolworths. The tests are written using Cucumber and RestAssured to validate various scenarios.

## Test Description

The Search API testing framework includes Cucumber scenarios that cover three main test cases:

1. **Verify search count response with a valid search term:** This scenario tests the API's response when queried with a valid search term.
2. **Verify search count response with an empty search term:** This scenario checks the API's behavior when the search term is empty.
3. **Verify search count response with special characters in the search term:** This scenario evaluates how the API handles search terms containing special characters.

## Project Structure

The project follows the Page Object Model (POM) design pattern, which separates the page-related logic from the step definitions. Here's a brief explanation of the project structure:

- **src/test/java**: Contains the Java source code.
- **features**: Holds the Cucumber feature files that define test scenarios.
- **stepDefinitions**: Contains the Cucumber step definitions.
- **pojo**: Contains the POJO (Plain Old Java Object) classes used for mapping JSON responses.
- **cucumber/Options**: Configures the Cucumber test runner.

## Tool Requirements

- **Java Development Kit (JDK)**
- **Maven**
- **Cucumber**
- **RestAssured**
- **SLF4J**
- **JUnit**
- **Reporting Plugin**
- **Git**
- **Jenkins** (for CI/CD integration)

## Getting Started

To get started with the Search API testing, follow these steps:

1. Clone the repository to your local machine:
    ```
    git clone https://github.com/parajuli/WoolworthsAPI.git
    ```

2. Install the required dependencies using Maven:
    ```
    mvn clean install
    ```

3. Navigate to the `src/test/java/cucumber/Options/TestRunner.java` class and run it as a JUnit test to execute the Cucumber scenarios.

## Step Definitions

The step definitions for the Cucumber scenarios are implemented in the `SearchApiSteps` class. It uses the RestAssured library to interact with the Search API and validates the response using assertions.

## Logging Configuration

The `logback.xml` file is used for logging configuration.

## Troubleshooting

If you encounter any issues while running the tests, consider the following troubleshooting steps:

1. **Dependency Issues:** Ensure that all dependencies listed in the `pom.xml` file are installed and properly configured.
2. **Cucumber Step Definitions:** Verify that the step definitions in the `SearchApiSteps` class are correctly implemented for each scenario.

## How to Execute the Tests
## 1. Running Tests Using Command Line

To run the tests and generate reports:

1. **Run the tests:**
    ```
    mvn clean test
    ```

2. **Generate the HTML report:**
    ```
    mvn verify
    ```

The test results are generated in a Cucumber JSON report, which can be found at `target/report`. You can customize the reporting format and output by modifying the CucumberOptions in the `TestRunner` class. 

![Cucumber Report](https://github.com/parajuli/woolworths/blob/main/htmlreport.PNG)

## 2. Running Tests Using Jenkins and Generating Cucumber Report

To run the automated tests using Jenkins and generate reports, follow these steps:

1. **Download the Jenkins war file, navigate to the directory and execute the following command:**
    ```
    java -jar jenkins.war --httpPort=8080
    ```

2. **Install the `cucumber-reports` plugin.**

3. **Create a new Freestyle project.**

4. **In the project configuration, set up the following:**
   	- Specify the Git repository URL where the project is hosted.
	- Add a build step to execute a Maven build, specifying the goals as `clean install test`.

5. **Save the configuration and run the Jenkins project. Jenkins will fetch the code, build the project, and execute the tests.**

6. **After the test execution, you can access the generated Cucumber JVM report for further analysis.**

![Cucumber Report](https://github.com/parajuli/woolworths/blob/main/jvmreport.PNG)


## Limitations of the Tests

- The tests depend on the availability and responsiveness of the Woolworths Search API. If the API service is down or experiencing issues, the tests will fail.
- The test scenarios cover only a limited set of cases (valid, empty, and special character search terms). Additional scenarios may be needed for comprehensive coverage.
- The tests require network connectivity to access the Woolworths Search API. Network issues can cause test failures.

## Assumptions Made During Development

- The Search API is assumed to be stable and accessible during testing.
- The structure of the API response is assumed to be consistent as per the current implementation.
- The tests assume that the network connectivity is reliable and there are no significant delays or interruptions during API calls.
