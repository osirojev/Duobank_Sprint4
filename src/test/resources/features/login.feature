
@login
Feature: As a user, I should be able to login using login page.


  Background: Common steps for all scenarios
    Given The user is on the homepage



  Scenario: Login using valid credentials


    When The user enters the valid credentials
    Then The user should be able to login and land on the homepage



  Scenario: Login using invalid credentials

    When the user enters invalid credentials
    Then the user should not be able to login and get an error message



  Scenario: Login using empty credentials

    When the user enters empty credentials
    Then the user should not be able to login




    Scenario: Login with number credentials
      When The user enters wrong email type
      Then The user should not be able to login on homepage

      Scenario: Login with correct email and wrong password
        When The user enters correct email type
        Then The user should not be able to login