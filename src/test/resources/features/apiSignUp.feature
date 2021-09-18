Feature: SignUp endpoint positive test

  @api

  Scenario Outline: Create a New User
    Given I add the headers "Content-Type", "application/json" and "Accept", "application/json"
    And I create a valid credentials using "<first_name>", "<last_name>", "<email>" and "<password>"
    When I send a POST request to "/register.php" endpoint
    Then I verify the status code should be 200
    And The success "message" should be "You have successfully registered."

    Examples:
      | first_name | last_name | email                  | password     |
      | Houston    | Texas     | houstontexas@gmail.com | houston_2021 |