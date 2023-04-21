Feature: Assigner etiquette

  Scenario: Assigner etiquette à un colis contenant un ours en peluche

    Given I have a package "colis123"
    When I create the etiquette "abc123" to the package "colis123"
    Then the response will return status 201
    And The package "colis123" contain etiquette "abc123"