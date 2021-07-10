Feature: Test Petstore APIs

  @get
  Scenario: Get pet by id
    When user executes "GET" request
    Then status code is 200
    And pet has following attributes
      | petName | petId | petStatus |
      | gala    | 1050  | fol sale   |