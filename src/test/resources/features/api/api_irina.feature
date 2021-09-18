@api @db
Feature: API scenarios

  Scenario: Create new user Positive
    Given I add payload
      | firstName | lastName | email            | password   |
      | Loly      | Lang     | kllloo@gmail.com | lilylang77 |
    When I send POST request to "/register.php" endpoint
    Then The response status should be 200
    And The response is succeeded

  Scenario: Create new User using POJO
    Given I use pojo to create new User
    When I send POST request to "/register.php" endpoint
    Then The POJO response status should be 200
    And The response POJO is succeeded

  Scenario Outline: Create new User Negative
    Given I add the following payload as "<firstName>" for first name, "<lastName>" for last name, "<email>" for email, and "<password>" for password
    When I send POST request to "/register.php" endpoint
    Then The response should not be succeeded

    Examples: Invalid credentials
      | firstName | lastName | email              | password               | comment                     |
      | #$%kl     | Young    | mat99@gmail.com    | mattyoung77            | character in first name     |
      | Oyat      | fr%#$@   | oyat4@gmail.com    | oya1siroj91            | character in last name      |
      | G         | GularaA  | gulara4@gmail.com  | gularaaalakbarova96    | single letter as first name |
      | ricky     | Y        | mat9987@gmail.com  | matt&oung77            | single letter as lastt name |
      | .....     | l        | oyatu84@gmail.com  | oyauyt1siroj91         | dots as a first name        |
      | Gulari    | ****     | 643jhgty@gmail.com | gulahnyraaalakbarova96 | stars as a last name        |








