Feature: New Bug Feature
  Verify if user is able to create a new bug


  Scenario Outline: Create a bug as a authenticated user - Open new bug
    Given I login with:
      | username  |   password  |
      |<username> |  <password> |
    When I select the <menu> menu
    Then the New Bug Plateform Page should be displayed

    Examples:
      | username  |   password  |   menu    |
      |   hunter  |   hunter    | NEW_BUG   |


  Scenario Outline: Create a bug as a authenticated user - First step
    Given I login with:
      | username  |   password  |
      |<username> |  <password> |
    And I am on the New Bug Plateform Page
    When I select the plateform <plateform>
    Then the New Bug Device Page should be displayed

    Examples:
      | username  |   password  | plateform |
      |   hunter  |   hunter    | SOFTWARE  |
      |   hunter  |   hunter    |    WEB    |

  Scenario Outline: Create a bug as a authenticated user - Second step
    Given I login with:
      | username  |   password  |
      |<username> |  <password> |
    And I am on the New Bug Plateform Page
    And I select the plateform <plateform>
    When I select the device <device>
    Then the New Bug Detail Page should be displayed

    Examples:
      | username  |   password  | plateform |   device    |
      |   hunter  |   hunter    |    WEB    |   COMPUTER  |
      |   hunter  |   hunter    |    WEB    |     PAD     |
      |   hunter  |   hunter    |    WEB    | SMARTPHONE  |

  Scenario Outline: Create a bug as a authenticated user - Third step
    Given I login with:
      | username  |   password  |
      |<username> |  <password> |
    And I am on the New Bug Plateform Page
    And I select the plateform <plateform>
    And I select the device <device>
    And I fill the New Bug Detail Form:
      |  webSiteName  | webSiteUrl    |  bugDescription   |   os   |   browser   |
      | <webSiteName> | <webSiteUrl>  |  <bugDescription> |  <os>  |  <browser>  |
    When I valid the New Bug Form
    Then the My Bugs Page should be displayed

    Examples:
      | username  |   password  | plateform |   device    | webSiteName | webSiteUrl  |  bugDescription |  os   |  browser  |
      |   hunter  |   hunter    |    WEB    |   COMPUTER  | webSiteName  | webSiteUrl.com  |     bugDescriptionComplexe  | os  | browser|

  @test
  Scenario Outline: Create a bug as a gost user
    Given I am on the New Bug Plateform Page
    And I close the information popUp
    And I select the plateform <plateform>
    And I select the device <device>
    And I fill the New Bug Detail Form:
      |  webSiteName  | webSiteUrl    |  bugDescription   |   os   |   browser   |
      | <webSiteName> | <webSiteUrl>  |  <bugDescription> |  <os>  |  <browser>  |
    When I valid the New Bug Form
    Then the Login Page

    Examples:
      | plateform |   device    | webSiteName | webSiteUrl  |  bugDescription |  os   |  browser  |
      |   WEB    |   COMPUTER  | webSiteName  | webSiteUrl.com  |     bugDescriptionComplexe  | os  | browser|