Feature: Task2

  Background:
    Given I am on the people page

  @add
  Scenario Outline: add new person
    When I click on the add person button
    And I enter the name "<name>" and surname "<surname>"
    And I enter the job status "<job>"
    And I enter the birthday "<birthday>"
    And I choose my language "<language>"
    And I choose my gender "<gender>"
    And I choose my employee status "<employee status>"
    And I click on the add button
    Then I should see new person added "<name>" and "<surname>"
    And I click on the reset list button
    Then I should see the list reseted

    Examples:
      | name    |  | surname |  | job    |  | birthday   |  | language |  | gender |  | employee status |
      | Alperen |  | Ulker   |  | Intern |  | 04/04/1990 |  | French   |  | Male   |  | Intern          |

  @edit
  Scenario: Edit a person
    When I want to edit person name "Mike" surname "Kid"
    And I enter a new name "Michael" and surname "Kido"
    And I enter a new job status "test engineer"
    And I click on edit button
    Then I should see the person edited as name "Michael" and surname "Kido"
    And I click on the reset list button
    Then I should see the list reseted

  @remove
  Scenario: Remove a person
    When I want to remove person name "Jill" surname "Watson"
    And I should see that the person is removed name "Jill" surname "Watson"
    And I click on the reset list button
    Then I should see the list reseted

    @clearFields
  Scenario Outline: check clear functionality on adding a user
    When I click on the add person button
    And I enter the name "<name>" and surname "<surname>"
    And I enter the job status "<job>"
    And I enter the birthday "<birthday>"
    And I choose my language "<language>"
    And I choose my gender "<gender>"
    And I choose my employee status "<employee status>"
    And I click on clear all fields button
    Then I should see all fields are clear

    Examples:
      | name    |  | surname |  | job    |  | birthday   |  | language |  | gender |  | employee status |
      | Alperen |  | Ulker   |  | Intern |  | 04/04/1990 |  | French   |  | Male   |  | Intern          |



