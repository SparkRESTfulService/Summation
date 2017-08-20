Feature: RESTful WebService to Add two numbers
  In order to add "Addition" functionality to a calculator
  As a developer
  I want to build "Add" module
  So that calculator can add two numbers

  Scenario Outline: Send request to add two numbers: "<num1>" and "<num2>"
    Given I have two numbers "<num1>" and "<num2>"
    When I request the addition of both
    Then the result should be the total of both
    Examples:
    |num1|num2|
    |  52976147  |  2147483648   |
    |  7463558.5784198  |    5940125635    |
    |  -4830.34382   | -2147483648  |
    |  -0.9880564651  |  92233720368547  |
    |  0.1761217507  | -3618785   |

  Scenario: Send request with single number
    Given I have one number
    When I send the request with only that number
    Then I should get the same number in response

  Scenario: Send request to add three numbers
    Given I have three numbers
    When I send the request to add all of them
    Then I should get "404 Not Found" exception

  Scenario: Send request to add a number with a string
    Given I have a number and a string
    When I request the addition of both
    Then I should get "400 Bad Request" exception

    Scenario: Send request to add a number and a special character
      Given I have a number and a special character
      When I request the addition of both
      Then I should get "400 Bad Request" exception