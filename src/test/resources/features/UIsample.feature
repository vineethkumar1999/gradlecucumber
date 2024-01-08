Feature: This feature will contain example of how UI automation with cucumber works


  @UITest
  Scenario: Finding some cheese
    Given Simple Test
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"
    And I search for "Automation Exercise"
    And I click on website
    Then the page title should start with "automation"
    When I click on login or Signup
    Then I fill name and email
    Then I fill the signupform
    When I click on Products

  @UITest2
  Scenario: Finding some cheese
    Given Simple Test
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"
    And I search for "Automation Exercise"
    And I click on website
    Then the page title should start with "automation"
    When I click on login or Signup
    Then I fill name and email
    Then I fill the signupform


  @UITest3
  Scenario: Alert example
    Given I navigate to "https://webdriveruniversity.com/Click-Buttons/index.html"
    When I click on Click me Web element


  @UITest4
  Scenario: windows and Tab management
    Given I navigate to "https://www.amazon.com"
    When I search for "Headphones" in amazon
    Then Click on first item and open in new tab


