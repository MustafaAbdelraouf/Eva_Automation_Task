# AutoTest-Script-01

Welcome to the **AutoTest-Script-01** repository! This project contains automated test scripts designed using the **TestNG** framework. These tests are built to ensure the quality and functionality of web applications through comprehensive and reliable automation.

## Project Overview

The **AutoTest-Script-01** project is designed to automate testing scenarios for web applications. It utilizes TestNG, a popular testing framework for Java, to execute and manage test cases.
The project uses a **POM** Design Pattern.
## Project Structure

- `src/main/java/` - Contains Java source code and utility classes (Pages locators) used by the tests.
- `src/test/java/` - Contains TestNG test cases and test suites.
- `src/test/java/DBConnections/SQLServerConnection` - Contains connection to SQLServer DB and gets data from it.
- `src/test/java/DBConnections/MySQLConnection` - Contains connection to MySQL DB and Asserts the data with it.
- `pom.xml` - Maven configuration file that manages project dependencies and build lifecycle.

## Features

- **Comprehensive Test Coverage:** Includes various test cases to validate different functionalities and Pages (Product Page, Purchase invoice, Purchase invoice return, POS invoice).
- **Still making the pages and updates in the project**
- **Easy Configuration:** Configurable test settings and parameters via property files.
- **Maven Integration:** Managed dependencies and build processes through Maven.

## Getting Started

To get started with the project, follow these instructions:

### Prerequisites

- **Java Development Kit (JDK) 8 or higher**
- **Maven 3.6.0 or higher**
- **IntelliJ IDEA** (or any other IDE that supports Java and Maven)

### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/readerorg/AutoTest-Script-01.git
2. **Navigate to the Project Directory**
    cd AutoTest-Script-01
3. **Install Project Dependencies**
    mvn install
4. **Environment Variable**
    1. Put the Java JDK to the environment variable
    2. download maven zip file and extract it
    3. Put the maven to the environment variable
    4. download allure zip file and extract it -> to make a testing report
    5. Put the allure to the environment variable
5. **Running the script**
    mvn test -> which will run the testng.xml file using **maven-surefire-plugin** and **maven-compiler-plugin**
