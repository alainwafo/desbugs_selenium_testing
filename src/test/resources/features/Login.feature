Feature: Login Feature
  Verify if user is able to Login in to the site

  Scenario Outline: Login as a authenticated user
    Given I am on the Login Page
    And I fill the Login Form:
      | username  |   password  |
      |<username> |  <password> |
    When I valid the Login Form
    Then the Logged Home should be displayed

    Examples:
      | username  |   password  |
      |   admin   |   admin     |
      |   tester  |   tester    |
      |   hunter  |   hunter    |