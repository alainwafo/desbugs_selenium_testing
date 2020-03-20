
Feature: New Bug Feature
  Verify if user is able to create a new bug

  Scenario Outline: Create a bug as a authenticated user - Open new bug from the NEW BUG menu
    Given I login with:
      | username  |   password  |
      |<username> |  <password> |
    When I select the <menu> dashboard menu
    Then the New Bug Plateform Page should be displayed

    Examples:
      | username  |   password  |   menu    |
      |   hunter  |   hunter    | NEW_BUG   |

  Scenario Outline: Create a bug as a authenticated user - Open new bug from the MY BUGS menu
    Given I login with:
      | username  |   password  |
      |<username> |  <password> |
    And I am on the My Bugs Page
    When I click the Add New Bug button of the My Bugs Page
    Then the New Bug Plateform Page should be displayed

    Examples:
      | username  |   password  |
      |   hunter  |   hunter    |

  Scenario Outline: Create a bug as a authenticated user - Open new bug from the CREATE A BUG of the landing home
    Given I login with:
      | username  |   password  |
      |<username> |  <password> |
    And I am on the Landing Home Page
    When I select the <menu> landing menu
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

  @DES-368 @old
  Scenario Outline: Create a bug as a authenticated user - Third step - Description KO
    Given I login with:
      | username  |   password  |
      |<username> |  <password> |
    And I am on the New Bug Plateform Page
    And I select the plateform <plateform>
    And I select the device <device>
    When I fill the Description on New Bug Detail Form with <bugDescription>
    Then An error message field should be displayed

    Examples:
      | username  |   password  | plateform |   device    | bugDescription |
      |   hunter  |   hunter    |    none   |     none    | String<9>      |
      |   hunter  |   hunter    |    none   |     none    | String<501>    |

  @DES-368 @old
  Scenario Outline: Create a bug as a authenticated user - Third step - Title KO
    Given I login with:
      | username  |   password  |
      |<username> |  <password> |
    And I am on the New Bug Plateform Page
    And I select the plateform <plateform>
    And I select the device <device>
    When I fill the Website name on New Bug Detail Form with <webSiteName>
    Then An error message field should be displayed

    Examples:
      | username  |   password  | plateform |   device    | webSiteName |
      |   hunter  |   hunter    |    none   |     none    | String<4>   |
      |   hunter  |   hunter    |    none   |     none    | String<51>  |

  @DES-141 @old
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
    And the new bug validation message should be displayed

    Examples:
      | username  |   password  | plateform |   device    | webSiteName | webSiteUrl  |  bugDescription |  os   |  browser  |
      |   hunter  |   hunter    |    WEB    |   COMPUTER  | String<10>  | String<10>  |     String<50>  |random |   random  |

  @DES-141 @old
  Scenario Outline: Create a bug as a ghost user
    Given I am on the New Bug Plateform Page
    And I close the information popUp
    And I select the plateform <plateform>
    And I select the device <device>
    And I fill the New Bug Detail Form:
      |  webSiteName  | webSiteUrl    |  bugDescription   |   os   |   browser   |
      | <webSiteName> | <webSiteUrl>  |  <bugDescription> |  <os>  |  <browser>  |
    When I valid the New Bug Form
    Then the Login Page should be displayed
    And the new bug validation message should be displayed

    Examples:
      | plateform |   device    | webSiteName | webSiteUrl  |  bugDescription |  os   |  browser  |
      |   WEB    |   COMPUTER  | String<10>  | String<10>   |     String<50>  |random |  random   |