Feature: Employment and Income Page
  Background: Common steps for all scenarios
    Given I am on Employment and Income Page

  Scenario: Checking employment and Income page with correct information
    When I filled up all necessary information and click next
    Then Should land on next page