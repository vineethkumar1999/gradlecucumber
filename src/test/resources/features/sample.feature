@featureTag
Feature: Sample feature

  @test
  Scenario: Sample scenario
    Given I have a sample step
    When I run the step
    Then I see the output

  @test2
  Scenario: Sample scenario
    Given I have a sample step
    When I run the step
    Then I see the output2

  @test3
  Scenario Outline: Testing outline
    Given I have a sample step
    When I run the step <msg>
    Then I see the output2
    Examples:
      | msg     |
      | 'Hello' |
      | 'Hai'   |