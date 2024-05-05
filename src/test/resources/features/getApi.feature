@regression
Feature: API Test

  Scenario: Get User Data
    Given I make a GET request to "api/users/2"
    Then I should get a successful response