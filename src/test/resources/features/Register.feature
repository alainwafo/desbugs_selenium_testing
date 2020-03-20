Feature: Register Feature
  Verify if user is able to Register on the site

  @test
  Scenario Outline: Register as a hunter without photo
    Given I am on the Register Page
    And I fill the Register Hunter Form:
      | firstname |  lastname  | username  |   email  |  password  |pwdConfirmation |  cgu  |
      |<firstname>| <lastname> |<username> |  <email> | <password> |   <password>   | <cgu> |
    When I valid the Register Form
    Then the Registration validation Message should be displayed

    Examples:
      | firstname |  lastname  |  username  |   email    |  password   |  cgu  |
      | String<10>| String<10> | String<10> | String<10> |  String<20> |  true |