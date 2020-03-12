Feature: Login Feature
  Verify if user is able to Login in to the site

  @test
  Scenario: Login as a authenticated user
    Given I am on the Login Page
    And I fill the Login Form
    When I valid the Login Form
    Then the logged home should be displayed