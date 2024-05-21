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

## Prerequisites

Before running the Search API tests, ensure you have the following set up:

1. **Java Development Kit (JDK):** Install JDK on your system, as the project requires Java to run.
2. **Dependencies:** Install the required dependencies listed in the `pom.xml` file. You can use Maven to manage the dependencies.

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

## Running the Tests

To run the tests and generate reports:

1. **Run the tests:**
    ```
    mvn clean test
    ```

2. **Generate the HTML report:**
    ```
    mvn verify
    ```

The HTML report will be generated in the `target/report` directory.

## Step Definitions

The step definitions for the Cucumber scenarios are implemented in the `SearchApiSteps` class. It uses the RestAssured library to interact with the Search API and validates the response using assertions.

## Logging Configuration

The `logback.xml` file is used for logging configuration.

## Troubleshooting
If you encounter any issues while running the tests, consider the following troubleshooting steps:

1. **Dependency Issues:** Ensure that all dependencies listed in the pom.xml file are installed and properly configured.
2. **Cucumber Step Definitions:** Verify that the step definitions in the SearchApiSteps class are correctly implemented for each scenario.

## Running Tests Using Command Line
To run the Search API tests using the command line, follow these steps:

Open a terminal and navigate to the root folder of the project.

**Use Maven to build the project:**

```
mvn clean install
```
**Run the tests using the following command:**

```
mvn test
```

The tests will execute, and the results will be displayed on the terminal.

## Running Tests Using Jenkins and Generating Cucumber Report
To run the automated tests using Jenkins and generating report, follow these steps:

1. Download the Jenkins war file, navigate to the directory and execute the following command:

```
java -jar jenkins.war --httpPort=8080
```

2. Install the `cucumber-reports` plugin.

3. Create a new Freestyle project.

4. In the project configuration, set up the following:

	a. Specify the Git repository URL where the project is hosted.
	b. Add a build step to execute a Maven build, specifying the goals as `clean install test`.

5. Save the configuration and run the Jenkins project. Jenkins will fetch the code, build the project, and execute the tests.

6. After the test execution, you can access the generated Cucumber JSON report for further analysis.

## Test Results
The test results are generated in a Cucumber JSON report, which can be found at `target/report/cucumber.json`. You can customize the reporting format and output by modifying the CucumberOptions in the `TestRunner` class.

