Feature: Task1 feature

  Background:
    Given I am on the number page

  @valid
  Scenario: User types correct number
    When I enter "81" to the number box
    And I click on the submit button
    Then I should see success message

  @invalid
  Scenario Outline: User types wrong <number> and should see <message>
    When I enter "<number>" to the number box
    And I click on the submit button
    Then I should see "<message>"
    Examples:
    | number |  | message               |
    | 23     |  | Number is too small   |
    | 110    |  | Number is too big     |
    | www    |  | Please enter a number |



