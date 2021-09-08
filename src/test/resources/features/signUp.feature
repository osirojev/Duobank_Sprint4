Feature: SignUp related scenarios
  @ui
  Scenario: SignUp new User using proper credentials
    Given I am on SignUp page
    When I fill out all input fields with proper credentials and click submit button
    Then I should be land on login page

    @ui
    Scenario Outline: Sign up a new user using wrong credentials

      Given I am in homepage and click on SignUp
      When The user enters the invalid credentials as "<username>" for username, "<firstName>" for first name, "<lastName>" for last name, "<email>" for email, and "<password>" for password
      Then User should not going to another page

      Examples: Invalid credentials
        | username               | firstName | lastName  | email              | password               | comment                     |
        | m.young                | #$%kl     | Young     | mat99@gmail.com    | mattyoung77            | character in first name     |
        | o.ghfj                 | Oyat      | fr%#$@    | oyat4@gmail.com    | oya1siroj91            | character in last name      |
        | g                      | Gulara    | GularaA   | gulara4@gmail.com  | gularaaalakbarova96    | single letter as username   |
        | myoung                 | r         | Younger   | mat9987@gmail.com  | matt&oung77            | single letter as first name |
        | o67hfj                 | Oyat      | l         | oyatu84@gmail.com  | oyauyt1siroj91         | single letter in last name  |
        | ...................... | Gulari    | GularaAii | 643jhgty@gmail.com | gulahnyraaalakbarova96 | dots as username            |





