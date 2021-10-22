Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

  Background:
    Given I am on age page

    @bug @test @anytag
  Scenario: a new scenario 1 with regex
    When I enter name: "Ann"
    And I enter age: 5
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"
   @test @anytag
  Scenario: a new scenario 2 with regex
    When I enter name: "Bob"
    And I enter age: 61
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"
    @anytag
  Scenario: enter a number
    When I am on number page
    And I enter 5 in the field
    And I click the result
    Then I see text "Number is too small"



