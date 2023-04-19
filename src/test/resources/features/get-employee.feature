Feature: Get Employee

  Scenario: Send a valid Request to get Employees

    Given Employees presents
      |name       | address     |
      | Tony      | Los Angeles |
      | Gwenaelle | Bretagne    |
    When I send a request to get employees
    Then the response will return status 200