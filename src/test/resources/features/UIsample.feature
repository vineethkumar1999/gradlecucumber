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

    

