Feature: Expenses  page related features
  Background: Common steps for all scenarios
    Given I am on Expenses Page checking functions

  Scenario: Checking "own" click button
    When I click on "own" button
    Then Specific text place holder should appear on screen

  Scenario: Checking 'rent" click button
    When I click on rent button
    Then Monthly rental payment place holder should appear

  Scenario: After adding correct amount to First Total Mortgage field and click next button to proceed Employment and Income Page
    When I add correct amount and click next button
    Then Should land on next page