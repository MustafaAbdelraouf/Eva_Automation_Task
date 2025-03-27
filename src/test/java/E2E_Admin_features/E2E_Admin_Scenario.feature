Feature: Login to OrangeHRM Website

  Scenario Outline: Add and Delete Admin User
    Given I open the OrangeHRM login page
    When I enter the username "<username>"
    And I enter the password "<password>"
    And I click on the login button
    Then I should see the dashboard with the title
   When I click on the Admin tab on the left side menu


    Then I should see the number of records found

    When I click on the add button
    And I fill the required data for a new user
    And I click on the save button

    Then I should see the number of records increased by 1

    When I search with the username
   And I delete the new user
   Then I should see the number of records decreased by 1

    Examples:
      | username | password |
      | Admin    | admin123 |
