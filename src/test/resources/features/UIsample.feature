Feature: This feature will contain example of how UI automation with cucumber works


  @UITest
  Scenario: Finding some cheese
    Given Simple Test
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"