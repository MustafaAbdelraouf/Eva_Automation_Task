# E2E Admin Automation

This project is an end-to-end (E2E) automation testing suite for the OrangeHRM Admin page. The tests are written using Java, Selenium WebDriver, and Cucumber to validate functionalities like logging in, adding a new user, searching for users, and deleting users.

## Features
- Login to the OrangeHRM platform.
- Navigate to the Admin page.
- Add a new admin user.
- Verify the number of records before and after actions.
- Search for a user.
- Delete an existing user.
- Ensure UI elements behave as expected.

---

## Technologies Used
- **Java**: Core programming language.
- **Selenium WebDriver**: For browser automation.
- **Cucumber**: To define test scenarios in BDD (Behavior-Driven Development) style.
- **TestNG**: Test execution framework.
- **Maven**: Dependency management.

---

## Prerequisites
- **Java Development Kit (JDK)**: Version 8 or above.
- **Maven**: Installed and configured.
- **IntelliJ IDEA** or any IDE with Maven support.
- A browser (e.g., Chrome) and its corresponding WebDriver.

---

## Installation and Setup
1. Clone this repository:
   ```bash
   git clone https://github.com/MustafaAbdelraouf/Eva_Automation_Task.git
   ```
2. Navigate to the project directory:
   ```bash
   cd E2E_Admin_Automation
   ```
3. Install dependencies using Maven:
   ```bash
   mvn clean install
   ```
4. Update the `config.properties` file in the `resources` folder:
    - Set the `baseURL` to the OrangeHRM login URL.
    - Provide the browser name and WebDriver path.

---

## Running Tests
1. **Using Maven**:
   Execute the following command to run all test scenarios:
   ```bash
   mvn test
   ```
2. **Using IntelliJ IDEA**:
    - Open the project in IntelliJ.
    - Navigate to the `LoginRunner` class in the `test` folder.
    - Run the test using the green play button.

---

## Project Structure
- **src/main/java**: Contains the reusable pages and base setup.
    - `ReusePages`: Page Object Models for LoginPage and AdminPage.
    - `ReuseTests`: Base test setup for browser and WebDriver.
- **src/test/java**: Contains step definitions for test scenarios.
    - `E2E_Admin_Steps`: Step definitions using Cucumber.
- **resources**: Configuration files and property settings.

---

## Key Test Scenarios
### Login Tests:
- Open the OrangeHRM login page.
- Enter valid credentials and login.
- Verify successful login by checking the dashboard title.

### Admin Page Tests:
- Navigate to the Admin page.
- Verify the number of records before and after adding a new user.
- Add a new user with required details.
- Search for the newly added user.
- Delete the new user and verify the record count is updated.

---

## Known Issues
- Hardcoded data like usernames and passwords.
- Usage of `Thread.sleep()`, which can be replaced with explicit waits for better reliability.

---

## Future Improvements
- Use a data-driven approach to test with multiple sets of inputs.
- Replace `Thread.sleep()` with Selenium explicit waits.
- Enhance the framework to include parallel test execution.

---

## Author
**Mustafa Abdelraouf**

For any queries, feel free to reach out through GitHub.

---
