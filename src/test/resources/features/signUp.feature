Feature: SignUp related scenarios

  Background: Common steps for all scenarios
    Given The user is on SignUp page

  @ui @db_only @Irina
  Scenario: SignUp new User using proper credentials
    When I fill out all input fields with proper credentials and click submit button
    Then I should be land on login page

    @ui @Irina
    Scenario Outline: Sign up a new user using wrong credentials

      When The user enters the invalid credentials as "<firstName>" for first name, "<lastName>" for last name, "<email>" for email, and "<password>" for password
      Then User should not going to another page

      Examples: Invalid credentials
        | firstName | lastName | email              | password               | comment                     |
        | #$%kl     | Young    | mat99@gmail.com    | mattyoung77            | character in first name     |
        | Oyat      | fr%#$@   | oyat4@gmail.com    | oya1siroj91            | character in last name      |
        | G         | GularaA  | gulara4@gmail.com  | gularaaalakbarova96    | single letter as first name |
        | ricky     | Y        | mat9987@gmail.com  | matt&oung77            | single letter as lastt name |
        | .....     | l        | oyatu84@gmail.com  | oyauyt1siroj91         | dots as a first name        |
        | Gulari    | ****     | 643jhgty@gmail.com | gulahnyraaalakbarova96 | stars as a last name        |




  @ui @Irina
  Scenario Outline: Sign up a new user leaving empty space as first name

    When The user enters the valid credentials as "<lastName>" for last name, "<email>" for email, and "<password>" for password
    Then User should not going to another page

    Examples: Invalid credentials
      | lastName | email           | password    | comment                |
      | Youst    | mat69@gmail.com | mattioung77 | empty spase first name |

  @ui @Irina
  Scenario Outline: Sign up a new user leaving empty space as last name

    When The user enters the valid credentials as "<firstName>" for first name, "<email>" for email, and "<password>" for password
    Then User should not going to another page

    Examples: Invalid credentials
      | firstName | email            | password     | comment               |
      | Yousty    | mart69@gmail.com | matitioung77 | empty spase last name |


  @db_only @Irina
  Scenario Outline: Sign up a new user using proper credentials

    When The user click on SignUp link and enters the valid credentials as "<firstName>" for first name, "<lastName>" for last name, "<email>" for email, and "<password>" for password
    Then User should be added to database

    Examples: Valid credentials
      | firstName | lastName | email              | password    |
      | Lulu      | Lolo     | lololulu@gmail.com | luluyoung77 |